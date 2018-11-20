package com.stock.mgmt.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	private static final String URL = "jdbc:mysql://localhost:3306/stock_management";
	private static final String USER = "root";
	private static final String PASS = "";

	/**
	 * @return Connection object
	 */
	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_mgmt_system",
			//		"root", "");
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
