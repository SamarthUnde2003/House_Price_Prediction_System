package org.dao;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class DBConfig {
	protected Connection conn ;
	protected PreparedStatement ptst ;
	
	
	public DBConfig()
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/predictionweb","root","root");
		} catch (Exception e) {
			System.out.println("Error while connecting Database "+e);
		}
	}
}
