package com.stock.mgmt.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.stock.mgmt.entity.User;

public class LoginDAO {
	private static final String VALIDATE_QUERY = "SELECT count(*) FROM `user` " + "";

	public static boolean validate(String username, String password) {
		Connection con = DatabaseConnector.getConnection();
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet result = statement.executeQuery(
					VALIDATE_QUERY + " where username='" + username + "' and password='" + password + "'");
			result.next();
			int count = result.getInt(1);
			if (count == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void register(User user) {
		Connection con = DatabaseConnector.getConnection();
		StringBuilder builder = new StringBuilder();
		builder.append(" INSERT INTO user ");
		builder.append(" (name, address_id, phone_number, email, dob, username, password )");
		builder.append(" VALUES ( ");
		builder.append("'");
		builder.append(user.getName());
		builder.append("',  ");
		
		
		builder.append("'");
		builder.append(user.getAddressId());
		builder.append("',  ");
		
		builder.append("'");
		builder.append(user.getPhone());
		builder.append("',  ");
		
		builder.append("'");
		builder.append(user.getEmail());
		builder.append("',");
		
		
	      DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	        //to convert Date to String, use format method of SimpleDateFormat class.
	        String strDate = dateFormat.format(user.getDob());
		
		builder.append("'");
		
		
		builder.append(strDate);
		builder.append("',");
		
		builder.append("'");
		builder.append(user.getUsername());
		builder.append("',");
		
		builder.append("'");
		builder.append(user.getPassword());
		builder.append("' )");
		
		String query = builder.toString();
		System.out.println(query);
		
		Statement statement;
		try {
			statement = con.createStatement();
			statement.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*public static void main(String[] args) {
		User user = new User();
		user.setAddressId("1");
		user.setDob(new Date());
		user.setEmail("prem62900@gmail.com");
		user.setName("Milan");
		user.setUsername("milan");
		user.setPassword("sdfdsf");
		user.setPhone("9878767776");
		
		
		
		
		new LoginDAO().register(user);
	}*/

}
