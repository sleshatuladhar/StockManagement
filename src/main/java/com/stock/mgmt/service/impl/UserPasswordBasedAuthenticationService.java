package com.stock.mgmt.service.impl;

import java.io.IOException;

import com.stock.mgmt.database.LoginDAO;
import com.stock.mgmt.entity.User;
import com.stock.mgmt.service.AuthenticationService;
import com.stock.mgmt.util.PasswordEncryptionUtil;

public class UserPasswordBasedAuthenticationService implements AuthenticationService {

	@Override
	public boolean validate(String username, String password) throws IOException {
		if(null == username || "".equals(username.trim())) {
			throw new IOException("Username is empty.");
		}
		if(null == password || "".equals(password.trim())) {
			throw new IOException("Password is empty.");
		}
		
        //Encrpt password using Md5 Algorithm
		String encryptedPassword = PasswordEncryptionUtil.encryptPassword(password);
		
		return LoginDAO.validate(username, encryptedPassword);
					
		
	}


	@Override
	public String getLoggedInUsername() {
		
		return null;
	}


	@Override
	public void register(User user) {
		String encryptedPassword = PasswordEncryptionUtil.encryptPassword(user.getPassword());
		user.setPassword(encryptedPassword);
		 LoginDAO.register(user);
	}

}
