package com.Ewallets.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetDocument
 */
@WebServlet("/GetDocument")
public class GetDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDocument() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "";
        
       ResultSet rs;
        
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
 
            String sql = "select * from kycdoc where id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, "id");
            rs=statement.executeQuery();
        	while(rs.next())
        	{
        		
        		out.println(rs.getString("id"));
        		out.println(rs.getString("name"));
        		out.println(rs.getString("file"));
        	}
 
            conn.close();
        } catch (Exception e) {
            out.println(e);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
