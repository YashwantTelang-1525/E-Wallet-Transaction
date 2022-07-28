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
import javax.servlet.http.HttpSession;

import com.Ewallets.beans.WalletUsersDBConnection;

/**
 * Servlet implementation class Deleteaccount
 */
@WebServlet("/Deleteaccount")
public class Deleteaccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deleteaccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String accountid;
		accountid=request.getParameter("uid");
		
		
		Connection con;
        PreparedStatement pst;

        WalletUsersDBConnection obj=new WalletUsersDBConnection();
		
        
        try{
        	con=obj.getDbconnection();
           // Class.forName("com.mysql.cj.jdbc.Driver");
           //con = DriverManager.getConnection("jdbc:mysql://b778m35afj0hm3pmhpou-mysql.services.clever-cloud.com:3306/b778m35afj0hm3pmhpou?user=uuphcvlz6eijcak1&password=2eDCMXWnjGW6w5S9WYTW");
            pst = con.prepareStatement("delete from E_wallet_users where userid=?;");
            pst.setString(1, accountid);
            int cnt = pst.executeUpdate();
            if(cnt == 1){
               out.println("account deleted succeesfully");
            }
            else{
                out.println("account not found");
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        response.sendRedirect("ewalletuserrecord.jsp");
		
		
	}

}
