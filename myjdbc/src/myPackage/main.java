package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //driver load
		//conn established
		//statement
		//execute-query
		//close
		
		
		try {
			
			String url = "jdbc:mysql://localhost:3306/jdbc";
			String userName = "root";
			String password = "";
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection(url,userName,password);
			System.out.println("connected");
			
		}catch(Exception e) {
			  e.printStackTrace();
		}
		
	}

}
