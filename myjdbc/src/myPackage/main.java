package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //driver load
		//conn established
		//statement
		//execute-query
		//close
		
		student st = new student();
		
		st.createDatabase();
		
		st.createStudent();
		st.insertStudent("koushik","koushik.srist.mondal@gmail.com",8820909295L,15);
		st.showStudent(1);
	}

}
