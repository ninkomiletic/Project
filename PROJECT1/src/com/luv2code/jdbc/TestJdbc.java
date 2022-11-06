package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/ninkoDB?useSSL=false";
		String user="root";
		String password="my-secret-password";
		try {
			System.out.println("Connection to database: "+jdbcUrl);
			
			Connection myConn=
					DriverManager.getConnection(jdbcUrl,user,password);
			System.out.println("Connection successful!!!");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}

	}

}
