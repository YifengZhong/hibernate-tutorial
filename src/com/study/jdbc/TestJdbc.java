package com.study.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent"
				;
		try {
			System.out.println("connecting to database:"+ jdbcUrl);
			Connection myConn =
					DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection successful");
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
