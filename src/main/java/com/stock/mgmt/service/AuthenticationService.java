package com.stock.mgmt.service;

import java.io.IOException;

import com.stock.mgmt.entity.User;

public interface AuthenticationService {
	/**
	 * This method is used to validate user based on user credentials
	 * @param username
	 * @param password
	 * @return true if user is authenticated
	 * @throws IOException 
	 */
	public boolean validate(String username, String password) throws IOException;
	
	/**
	 * 
	 * @return currently Logged in User
	 */
	public String getLoggedInUsername();

	/**
	 * This method registers user
	 * @param user
	 */
	public void register(User user);

}
