package com.Ewallets.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.lang.*;

public class JdbcInsertFileOne {

	 public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost:3306/company";
	        String user = "root";
	        String password = "";
	        
	        String filePath = "C:/Users/YASHWANT/Downloads/Rpatt.webp";
	        
	        try {
	            Connection conn = DriverManager.getConnection(url, user, password);
	 
	            String sql = "INSERT INTO kycdoc (name, id, file) values (?, ?, ?)";
	            PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setString(1, "Robert");
	            statement.setString(2, "101");
	            InputStream inputStream = new FileInputStream(new File(filePath));
	 
	            statement.setBlob(3, inputStream);
	 
	            int row = statement.executeUpdate();
	            if (row > 0) {
	                System.out.println("A contact was inserted with photo image.");
	            }
	            conn.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
		
}
