package net.javaguides.etustage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	String username = "root";
	String pass = "javaDB";
	String con_string = "jdbc:mysql://localhost:3306/etustage";
	
    

	public Connection connection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(con_string, username, pass);
	}
}
