package com.Ewallets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Ewallets.beans.WalletUsersDBConnection;



/**
 * Servlet implementation class Checklogin
 */
@WebServlet("/Checklogin")
public class Checklogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checklogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String id,ps;
		id=request.getParameter("uid");
		ps=request.getParameter("psw");
		
		//below code is for accessing servelets data into jsp
		//request.setAttribute("userloginid", id);
		//RequestDispatcher rd=request.getRequestDispatcher("/userprofile.jsp");
		//rd.forward(request, response);
		//done
		
		
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		
		WalletUsersDBConnection obj=new WalletUsersDBConnection();
		con=obj.getDbconnection();
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//con=DriverManager.getConnection("jdbc:mysql://b778m35afj0hm3pmhpou-mysql.services.clever-cloud.com:3306/b778m35afj0hm3pmhpou?user=uuphcvlz6eijcak1&password=2eDCMXWnjGW6w5S9WYTW");
			
			pst=con.prepareStatement("select * from E_wallet_users where userid=? and password=? and userstatus='active';");
			pst.setString(1, id);
			pst.setString(2, ps);
			rs=pst.executeQuery();
			
			if(rs.next())
			{
				
				HttpSession session=request.getSession(true);
				session.setAttribute("userid", id);
				
				
				if(rs.getString("usertype").equals("customer"))
					response.sendRedirect("homepage.jsp");
				else
					//out.println("Unknown user. No match found in DB");
					response.sendRedirect("adminpage.jsp");
			}
			else
				//out.println("authentication failed");
				response.sendRedirect("index.jsp");
			
			con.close();
			
		}
		catch(Exception e) {
			out.println(e);
		}
		
	}

}
