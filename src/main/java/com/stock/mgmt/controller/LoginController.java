package com.stock.mgmt.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stock.mgmt.service.AuthenticationService;
import com.stock.mgmt.service.impl.UserPasswordBasedAuthenticationService;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AuthenticationService authService;

	/**
	 * Default constructor.
	 */
	public LoginController() {
		authService = new UserPasswordBasedAuthenticationService();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		if (authService.validate(username, password)) {
			HttpSession session=request.getSession();  
	        session.setAttribute("username" , username); 

	        if(null != remember) {
	           Cookie cookie = new Cookie("username", username);
	          Cookie cookie1 = new Cookie("password", password);
	             response.addCookie(cookie);
	             response.addCookie(cookie1);
	        }
	        
			response.sendRedirect("welcome.jsp");
		} else {
			response.sendRedirect("login.jsp?msg=506");
		}

	}

}
