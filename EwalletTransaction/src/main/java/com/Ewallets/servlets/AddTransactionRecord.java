package com.Ewallets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddTransactionRecord
 */
@WebServlet("/AddTransactionRecord")
public class AddTransactionRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTransactionRecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Connection con;
        PreparedStatement pst4;
        
		
        String fromacc,toacc,amount;
		
		fromacc=request.getParameter("facc");
		toacc=request.getParameter("tacc");
		amount=request.getParameter("tamt");
		
		
		try {
			
		Date date = new Date();
    	String datee = date.toString();
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	con = DriverManager.getConnection("jdbc:mysql://b778m35afj0hm3pmhpou-mysql.services.clever-cloud.com:3306/b778m35afj0hm3pmhpou?user=uuphcvlz6eijcak1&password=2eDCMXWnjGW6w5S9WYTW");
    	pst4 = con.prepareStatement("insert into TransactionRecord values(?,?,?,?);");
    	pst4.setString(1,fromacc);
    	pst4.setString(2, toacc);
    	pst4.setString(3, amount);
    	pst4.setString(4, datee);
    	
		}
		catch(Exception e) {
			out.print(e);
		}
	}

}
