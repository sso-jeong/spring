package com.example.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class DBConnector {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/member?serverTimezone=UTC";
	private String user = "root";
	private String pwd = "root";

	@Test
	public void dbConnection() throws ClassNotFoundException {
		Class.forName(driver);
		try {
			Connection conn = DriverManager.getConnection(url, user, pwd);
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
