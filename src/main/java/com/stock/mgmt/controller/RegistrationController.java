package com.stock.mgmt.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.mgmt.entity.User;
import com.stock.mgmt.service.AuthenticationService;
import com.stock.mgmt.service.impl.UserPasswordBasedAuthenticationService;

/**
 * Servlet implementation class LoginController
 */
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AuthenticationService authService;

	/**
	 * Default constructor.
	 */
	public RegistrationController() {
		authService = new UserPasswordBasedAuthenticationService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		
		User user = new User();
		user.setName(name);
		user.setUsername(username);
		user.setAddressId(address);
	    Date date1 = null;
		try {
			date1 = new SimpleDateFormat("YYYY-mm-dd").parse(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		user.setDob(date1);
		user.setEmail(email);
		user.setPhone(phone);
		user.setPassword(password);
		authService.register(user);
		response.sendRedirect("login.jsp?msg=Register Successful");
	}

}
