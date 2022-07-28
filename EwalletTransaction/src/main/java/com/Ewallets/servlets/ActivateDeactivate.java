package com.Ewallets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Ewallets.beans.WalletUsersDBConnection;

import java.sql.*;
/**
 * Servlet implementation class ActivateDeactivate
 */
@WebServlet("/ActivateDeactivate")
public class ActivateDeactivate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivateDeactivate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String accountid,status;
		accountid=request.getParameter("uid");
		status=request.getParameter("accountstatus");
		
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		
		WalletUsersDBConnection obj=new WalletUsersDBConnection();
		con=obj.getDbconnection();
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//con=DriverManager.getConnection("jdbc:mysql://b778m35afj0hm3pmhpou-mysql.services.clever-cloud.com:3306/b778m35afj0hm3pmhpou?user=uuphcvlz6eijcak1&password=2eDCMXWnjGW6w5S9WYTW");
			
			pst=con.prepareStatement("update E_wallet_users set userstatus=? where userid=?");
			pst.setString(1, status);
			pst.setString(2, accountid);
			
			pst.executeUpdate();
			con.close();
		}
		catch(Exception e){
			out.println(e);
		}
		response.sendRedirect("ewalletuserrecord.jsp");
		
	}

}
