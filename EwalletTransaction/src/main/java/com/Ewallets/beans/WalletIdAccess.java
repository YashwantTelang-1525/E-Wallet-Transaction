package com.Ewallets.beans;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class WalletIdAccess {

	    Connection con;
		Statement st;
	    ResultSet rs;
	public WalletIdAccess() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://b778m35afj0hm3pmhpou-mysql.services.clever-cloud.com:3306/b778m35afj0hm3pmhpou?user=uuphcvlz6eijcak1&password=2eDCMXWnjGW6w5S9WYTW");
			st=con.createStatement();
		  	rs=st.executeQuery("select * from walletaccounts;");
		  	while(rs.next()) {
		  		rs.getString("accno");
		  	}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
	public Connection getDbconnection() {
		return con;
	}
}
