package com.jsp;
//wac to fetch the data and update the proper data after consuming? and print thr

//bill using get connection(url,proporties ref)
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.*;

public class bill {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mock","root","root");
			Statement st=con.createStatement();
			System.out.println("which product you want to purchase? 1.medimix 2.ponds 3.santoor");
			String pname=sc.next();
			System.out.println("quantity you want to buy");
			int Quantity=sc.nextInt();
			ResultSet rs=st.executeQuery("select * from products where pname="+"'"+pname+"'");
			if(rs.next())
			{
				int cost=rs.getInt(2);
				int quantity=rs.getInt(3);
				System.out.println("the cost of the product for 1 item "+cost+" and quantity available is "+quantity);
				int remaining=quantity-Quantity;
				System.out.println(remaining);
				st.execute("update products set quantity="+remaining+" where pname = "+"'"+pname+"'");
				System.out.println("updated to the table successfully ");
				System.out.println("total bill "+cost*Quantity);
			}
			
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		}
}
