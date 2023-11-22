package saturdayPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleExecuteQueryJDBC {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Driver driver = new Driver();
		
		//step1: register the driver(DriverManager--- mysql)
		DriverManager.registerDriver(driver);
		
		//step2: get connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb","root","root");
		
		//step3: issue create statement
		Statement state = con.createStatement();
		
		//step4: execute a query
		ResultSet result = state.executeQuery("select * from customerinfo;");
		
		while(result.next())
		{
			String value = result.getString(1)+" "+result.getString(2)+" "+result.getInt(3);
			System.out.println(value);
		}
		
		//Step 5: close the database
				con.close();

	}

}


/*
 * 
 * public static void main(String[] args) throws SQLException {
		
        Driver driver = new Driver();
		
		//Step 1: Register the driver
		DriverManager.registerDriver(driver);
		
		//Step 2: Get Connection with Database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "root");
		
		//Step 3: issue create statement
		Statement state = con.createStatement();
		
		//Step 4: execute a query
		ResultSet result = state.executeQuery("select * from empinfo;");
		while(result.next())
		{
			String value = result.getString(1)+" "+result.getString(2)+" "+result.getInt(3);
			System.out.println(value);
		}
		
		
		//Step 5: close the database
		con.close();
		
	}
	*/
