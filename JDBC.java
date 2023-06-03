//wac to display the entered data is matched with proper user credentials 
package com.jsp;
import java.util.*;
import java.sql.*;

public class JDBC {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter mail");
	String mail=sc.next();
	System.out.println("enter password");
	String pswd=sc.next();
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mock", "root", "root");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from userdetails where gmail ="+"'"+mail+"'");
		if(rs.next())
		{
			String tmail=rs.getString(1);
			String tpswd=rs.getString(2);
			System.out.println(tmail+" "+tpswd);
			if(mail.equals(tmail)&&pswd.equals(tpswd))
			{
				System.out.println("data matched");
			}
			else
			{
				System.out.println("data not matched");
			}
		}
		
	}
	catch(ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	
	
}
}
