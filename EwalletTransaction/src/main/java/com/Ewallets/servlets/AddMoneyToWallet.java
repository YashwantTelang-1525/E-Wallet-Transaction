package com.Ewallets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Ewallets.beans.WalletUsersDBConnection;

/**
 * Servlet implementation class AddMoneyToWallet
 */
@WebServlet("/AddMoneyToWallet")
public class AddMoneyToWallet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMoneyToWallet() {
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
		
		String accountid,walletid,amount,password;
		accountid=request.getParameter("uid");
		password=request.getParameter("pws");
		walletid=request.getParameter("wid");
		amount=request.getParameter("amt");
		
		//out.println(accountid+walletid+amount);
		Connection con;
        PreparedStatement pst,pst1;
        ResultSet rs;
        
		 WalletUsersDBConnection obj=new WalletUsersDBConnection();
			
	        
	        try{
	        	con=obj.getDbconnection();
	           // Class.forName("com.mysql.cj.jdbc.Driver");
	           //con = DriverManager.getConnection("jdbc:mysql://b778m35afj0hm3pmhpou-mysql.services.clever-cloud.com:3306/b778m35afj0hm3pmhpou?user=uuphcvlz6eijcak1&password=2eDCMXWnjGW6w5S9WYTW");
	           
	            //
	            pst1=con.prepareStatement("select * from E_wallet_users where userid=? and password=?");
	            pst1.setString(1,accountid);
	            pst1.setString(2, password);
	            rs=pst1.executeQuery();
	            //
	            if(rs.next()) {
	            pst = con.prepareStatement("UPDATE walletaccounts SET balance=balance+? where accno=?;");
	            pst.setString(1, amount);
	            pst.setString(2, accountid);
	            
	            int cnt = pst.executeUpdate();
	            
	            if(cnt == 1){
	              response.sendRedirect("moneyaddedtowallet.html");
	            }
	            else{
	            	response.sendRedirect("fail.html");
	            }
	            }
	            con.close();
	        }
	        catch(Exception e){
	            System.out.println(e);
	        }
	        //response.sendRedirect("moneyaddedtowallet.html");
	}

}
