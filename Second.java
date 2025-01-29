package com;

import java.sql.*;

public class Second {

	public static void main(String[] args) {
		
		Connection c = null;
		
        try {
        	//1.Load or register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Checked exceptions are not actual exception they warnings that exception may occur in future
			
			//2.Establish Connection
			c= DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db", "root", "root");
			
			//3.Create Statement
			Statement s=c.createStatement();
			
			//4.Execute Query
			s.executeUpdate("insert into emp values(3,'stuart',21000,'stuart@gmail.com','456')");
			
			System.out.println("Data inserted");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(c!=null) {
				//5.Close the connection
				c.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
}