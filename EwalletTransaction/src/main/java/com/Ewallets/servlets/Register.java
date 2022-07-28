package com.Ewallets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Ewallets.beans.WalletUsersDBConnection;

//import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String id,ps,ct,em,mo;
		id=request.getParameter("uid");
		ps=request.getParameter("psw");
		ct=request.getParameter("city");
		em=request.getParameter("eml");
		mo=request.getParameter("mob");
		
		//out.println(id+","+ps+","+ct+","+mo+","+em);
		
		Connection con;
		PreparedStatement pst;
		
		WalletUsersDBConnection obj=new WalletUsersDBConnection();
		con=obj.getDbconnection();
		
		//Resultset rs;
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//con=DriverManager.getConnection("jdbc:mysql://b778m35afj0hm3pmhpou-mysql.services.clever-cloud.com:3306/b778m35afj0hm3pmhpou?user=uuphcvlz6eijcak1&password=2eDCMXWnjGW6w5S9WYTW");
			pst=con.prepareStatement("insert into E_wallet_users values(?,?,?,?,?,default,default)");
			pst.setString(1, id);
			pst.setString(2, ps);
			pst.setString(3, ct);
			pst.setString(4, em);
			pst.setString(5, mo);
			pst.executeUpdate();
			con.close();
		}
		catch(Exception e){
			out.println(e);
		}
		response.sendRedirect("login.jsp");
	}

}
