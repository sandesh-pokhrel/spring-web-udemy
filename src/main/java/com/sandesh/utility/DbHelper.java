package com.sandesh.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
	
	private String connectionString = "jdbc:h2:~/test";
	private String username = "sa";
	private String password = "";

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("org.h2.Driver");   
			connection =  DriverManager.getConnection(connectionString, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
