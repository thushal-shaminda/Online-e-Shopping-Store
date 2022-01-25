package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connect {
	
	private static String url = "jdbc:mysql://localhost:3306/online_shopping";
	private static String username = "root";
	private static String password = "root";
	private static Connection cn;
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			cn = DriverManager.getConnection(url, username, password);
			
		} catch(Exception e) {
			System.out.println("Database connection is not success...!!!");
		}
		
		return cn;
	}
}
