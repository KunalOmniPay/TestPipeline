package com.mindtree;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class hello {
public static void main(String[] args){
	Connection con = null;
	ResultSet rs;
	try {
	
	int ch;
	Statement stmt;
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "123456");
	stmt = con.createStatement();
	rs = stmt.executeQuery("select * from book");
	System.out.println("Available books are - ");
	System.out.println("ID \t\t Name \t\t AuthorName \t\t Genre \t\t Quantity");
	while (rs.next())
		System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3) + "\t\t"
				+ rs.getString(4) + "\t\t" + rs.getInt(5));
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	try {
		con.close();
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}
}
