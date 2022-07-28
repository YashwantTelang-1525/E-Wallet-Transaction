package com.Ewallets.beans;
import java.sql.*;

public class WalletUsersDBConnection {
	
	private Connection dbconnection;
	
	public WalletUsersDBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbconnection=DriverManager.getConnection("jdbc:mysql://b778m35afj0hm3pmhpou-mysql.services.clever-cloud.com:3306/b778m35afj0hm3pmhpou?user=uuphcvlz6eijcak1&password=2eDCMXWnjGW6w5S9WYTW");
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
	public Connection getDbconnection() {
		return dbconnection;
	}
}
