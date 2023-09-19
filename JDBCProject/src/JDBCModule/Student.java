package JDBCModule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;

public class Student {
	public void CreateDatabases() {
		
		// Driver load
			try {
				// That was the field was accept the access the MySQl database of the offline data.
				String url = "jdbc:mysql://localhost";
				String username = "root";
				String password = "Akash@2002";
				
		// connection establish 
				// That was establish the connection between the code and the database.
				Connection conn = DriverManager.getConnection(url,username,password);
		// Statement create
				// We are create the statement of the query which was fired.
				Statement stm = conn.createStatement();
				
		// Execute - Query
				// Query for the add the new databases in the your databases.
				String query = "create database Akash";
				stm.execute(query);
				System.out.println("Connection Established");
				
		// Connection close
				// Here the connection was closed by the coder for the secure connection of the database.
				conn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}

	public void createTable() {
		
		// Code for the add an the table into your data for the proper formating of data into your database
		try {
			// That was the field was accept the access the MySQl database of the offline data.
			String url = "jdbc:mysql://localhost/Akash";
			String username = "root";
			String password = "Akash@2002";
			
			// That was establish the connection between the code and the database.
			Connection conn = DriverManager.getConnection(url,username,password);
			// We are create the statement of the query which was fired.
			Statement stm = conn.createStatement();
			
			// Query for the add the new databases in the your databases.
			String query = "create table studentnew (sid int primary key,sname varchar(20),semail varchar(60))";
			stm.execute(query);
			System.out.println("Table created Sucessfully");
			
			// Here the connection was closed by the coder for the secure connection of the database.
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void createData() {
		
		// Method for add the new data into the student table.
		try {
			// That was the field was accept the access the MySQl database of the offline data.
			String url = "jdbc:mysql://localhost/Akash";
			String username = "root";
			String password = "Akash@2002";
			
			// Accept the data from the user dynamically.
			int id1;
			String sname1;
			String semail;
			System.out.println("Enter the student id,name and email:");
			Scanner s1 = new Scanner(System.in);
			id1 = s1.nextInt();
			sname1 = s1.next();
			semail = s1.next();
			
			// That was establish the connection between the code and the database.
			Connection conn = DriverManager.getConnection(url,username,password);
			
			// Query for the add the new databases in the your databases.
			// Normal query for add an the data into database.
			//String query = "insert into studentnew (sid,sname,semail) values (11,'Akash','akashsawant020202@gmail.com')";
			// New SQL query for add the data dynamically in database.
			String query = "insert into studentnew (sid,sname,semail) values (?,?,?)";
			// We are create the statement of the query which was fired.
			PreparedStatement pstm = conn.prepareStatement(query);
			// get the data dynamically.
			pstm.setInt(1, id1);
			pstm.setString(2, sname1);
			pstm.setString(3, semail);
			pstm.executeUpdate();
			System.out.println("Data inserted Sucessfully");
			
			// Here the connection was closed by the coder for the secure connection of the database.
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public void readData() {
		// Code for the read the data from the database.
		try {
			// That was the field was accept the access the MySQl database of the offline data.
			String url = "jdbc:mysql://localhost/Akash";
			String username = "root";
			String password = "Akash@2002";
			
			// That was establish the connection between the code and the database.
			Connection conn = DriverManager.getConnection(url,username,password);
			
			// Query for the add the new databases in the your databases.
			String query = "select *from studentnew";
			
			// We are create the statement of the query which was fired.
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			// Here we have read the data into proper format.
			while(rs.next())
			{
				// Print the output into the proper format.
				System.out.println("id = "+rs.getInt(1));
				System.out.println("name = "+rs.getString(2));
				System.out.println("email = "+rs.getString(3));
			}
			
			System.out.println("Read Sucessfully");
			
			// Here the connection was closed by the coder for the secure connection of the database.
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void UpdateData() {
		// That was the method which was update the data from the current data of database.
		try {
			// That was the field was accept the access the MySQl database of the offline data.
			String url = "jdbc:mysql://localhost/Akash";
			String username = "root";
			String password = "Akash@2002";
			
			// Data whose id for update their data into your database.
			int id1;
			String sname1;
			String semail;
			System.out.println("Enter id whose data want to update:");
			Scanner s2 = new Scanner(System.in);
			
			id1 = s2.nextInt();
			sname1 = s2.next();
			semail = s2.next();
			
			// That was establish the connection between the code and the database.
			Connection conn = DriverManager.getConnection(url,username,password);
			
			// Query for the add the new databases in the your databases.
			// ? mark was denote the data which was dynamically get by the user for the proper information update.
			String query = "update studentnew set sid = ? where sname = ? and semail= ?";
			
			// We are create the statement of the query which was fired.
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, id1);
			pstm.setString(2,sname1);
			pstm.setString(3, semail);
			pstm.execute();
			System.out.println("Data Updated Sucessfully");
			
			// Here the connection was closed by the coder for the secure connection of the database.
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public void deleteData() {
		// This method is basically used for delete the specific data from the database.
		try {
			// That was the field was accept the access the MySQl database of the offline data.
			String url = "jdbc:mysql://localhost/Akash";
			String username = "root";
			String password = "Akash@2002";
			
			// That was establish the connection between the code and the database.
			Connection conn = DriverManager.getConnection(url,username,password);
			
			// Id for their data want to be deleted from your database.
			int id1;
			System.out.println("Enter the id whose data want to be deleted:");
			Scanner s3 = new Scanner(System.in);
			id1 = s3.nextInt();
			// Query for the add the new databases in the your databases.
			// ? mark was denote the data which was dynamically get by the user for the proper information update.
			String query = "delete from studentnew where sid = ?";
			
			// We are create the statement of the query which was fired.
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, id1);
			pstm.execute();
			System.out.println("Data Deleted Sucessfully");
			
			// Here the connection was closed by the coder for the secure connection of the database.
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	 
			
			
}
