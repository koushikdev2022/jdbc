package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	
	public void insertStudent(String name,String email, double number,int roll ) {
	    try {
	        String url = "jdbc:mysql://localhost:3306/java_jdbc";
	        String userName = "root";
	        String password = "";
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        Connection conn = DriverManager.getConnection(url, userName, password);
	        Statement stm = conn.createStatement();
	        
	        // Query to create table
	        String insertQuery = "INSERT INTO `student` (name, email, phone, roll, is_active) "
	                + "VALUES (?, ?, ?, ?, ?)";

	        // Prepare the statement
	        PreparedStatement pstmt = conn.prepareStatement(insertQuery);
	        

	        pstmt.setString(1, name);
	        pstmt.setString(2, email);
	        pstmt.setDouble(3, number);  // Assuming 'number' is the 'phone' field (you might need to clarify its usage)
	        pstmt.setInt(4, roll);
	        pstmt.setBoolean(5, true);  // Assuming 'is_active' is a boolean value and you want to set it to true
	        
	     
	        int result = pstmt.executeUpdate();
	        

	        System.out.println("Table 'your_table_name' created successfully.");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	public void showStudent(int id ) {
		try {
	        String url = "jdbc:mysql://localhost:3306/java_jdbc";
	        String userName = "root";
	        String password = "";
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        Connection conn = DriverManager.getConnection(url, userName, password);
	        Statement stm = conn.createStatement();
	        
	        // Query to create table
	        String showQuery = "SELECT * FROM `student` WHERE id = ?";

	        // Prepare the statement
	        PreparedStatement pstmt = conn.prepareStatement(showQuery);
	        

	       
	        pstmt.setInt(1,id);
	       
	        
	     
	        ResultSet rs = pstmt.executeQuery();
	        
	        // Process the result set
	        if (rs.next()) {
	            // Assuming the columns are 'id', 'name', 'email', 'phone', 'roll', 'is_active'
	            int studentId = rs.getInt("id");
	            String name = rs.getString("name");
	            String email = rs.getString("email");
	            String phone = rs.getString("phone");
	            int roll = rs.getInt("roll");
	            boolean isActive = rs.getBoolean("is_active");
	            
	            // Print the student details
	            System.out.println("Student ID: " + studentId);
	            System.out.println("Name: " + name);
	            System.out.println("Email: " + email);
	            System.out.println("Phone: " + phone);
	            System.out.println("Roll: " + roll);
	            System.out.println("Active: " + isActive);
	        } else {
	            System.out.println("No student found with id: " + id);
	        }
	        

	        System.out.println("Table 'your_table_name' created successfully.");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
}
