package com.Ewallets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Ewallets.beans.WalletUsersDBConnection;

/**
 * Servlet implementation class Addaccount
 */
@WebServlet("/Addaccount")
public class Addaccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addaccount() {
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

		String no,nm,atp,bal,wid;
		no=request.getParameter("accnum");
		nm=request.getParameter("accname");
		atp=request.getParameter("actype");
		bal=request.getParameter("wbal");
		wid=request.getParameter("watid");
		
		//out.println(no+nm+atp+bal+wid);
		
		
		
		try {
			WalletUsersDBConnection obj=new WalletUsersDBConnection();
			Connection con=obj.getDbconnection();
            PreparedStatement pst;
            //ResultSet rs;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://b778m35afj0hm3pmhpou-mysql.services.clever-cloud.com:3306/b778m35afj0hm3pmhpou?user=uuphcvlz6eijcak1&password=2eDCMXWnjGW6w5S9WYTW");
			pst=con.prepareStatement("insert into walletaccounts values(?,?,?,?,?,default)");
			pst.setString(1,no);
			pst.setString(2,nm);
			pst.setString(3,atp);
			pst.setString(4,bal);
			pst.setString(5,wid);
			pst.executeUpdate();
			out.println("added");
			con.close();
		}
		catch(Exception e) {
			out.println(e);
		}
		response.sendRedirect("accountadded.jsp");
	}

}
