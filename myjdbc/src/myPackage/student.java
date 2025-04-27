package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class student {
	
	public void createDatabase() {
		try {
			
			String url = "jdbc:mysql://localhost:3306";
			String userName = "root";
			String password = "";
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection(url,userName,password);
			Statement stm = conn.createStatement();
			String checkDbQuery = "SHOW DATABASES LIKE 'java_jdbc'";
		    ResultSet rs = stm.executeQuery(checkDbQuery);
		    
		    if (rs.next()) {
		        System.out.println("Database 'java_jdbc' already exists.");
		    } else {
		        String createDbQuery = "CREATE DATABASE java_jdbc";
		        boolean bl = stm.execute(createDbQuery);
		        if (bl==true) {
		            System.out.println("Database 'java_jdbc' created.");
		        }
		    }

		    System.out.println("Connected to MySQL database.");
			
			System.out.println("connected");
			
			conn.close();
			
		}catch(Exception e) {
			  e.printStackTrace();
		}
	}
	
	public void createStudent() {
	    try {
	        String url = "jdbc:mysql://localhost:3306/java_jdbc";
	        String userName = "root";
	        String password = "";
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        Connection conn = DriverManager.getConnection(url, userName, password);
	        Statement stm = conn.createStatement();
	        
	        // Query to create table
	        String createTableQuery = "CREATE TABLE IF NOT EXISTS `student` ("
	                + "id INT AUTO_INCREMENT PRIMARY KEY, "
	                + "name VARCHAR(255), "
	                + "email VARCHAR(255), "
	                + "phone VARCHAR(20), "
	                + "roll INT, "
	                + "is_active BOOLEAN"
	                + ")";
	        
	        // Execute the create table statement
	        stm.executeUpdate(createTableQuery);

	        System.out.println("Table 'your_table_name' created successfully.");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
}
