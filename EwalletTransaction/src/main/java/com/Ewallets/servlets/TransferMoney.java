package com.Ewallets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Ewallets.beans.AddtransactionRecord;
import com.Ewallets.beans.WalletUsersDBConnection;

/**
 * Servlet implementation class TransferMoney
 */
@WebServlet("/TransferMoney")
public class TransferMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferMoney() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		AddtransactionRecord T=new AddtransactionRecord();
		 
		
		String userid,fromacc,toacc,amount,pass;
		userid = request.getParameter("uid");
		T.setUid(userid);
		fromacc=request.getParameter("facc");
		T.setFacc(fromacc);
		toacc=request.getParameter("tacc");
		T.setTacc(toacc);
		amount=request.getParameter("tamt");
		T.setTamt(amount);
		pass=request.getParameter("pws");
		
		//out.println(accountid+walletid+amount);
		Connection con;
        PreparedStatement pst,pst1,pst2,pst3;
        ResultSet rs;
		WalletUsersDBConnection obj=new WalletUsersDBConnection();
			
	      
	        try{
	        	con=obj.getDbconnection();
	           // Class.forName("com.mysql.cj.jdbc.Driver");
	           //con = DriverManager.getConnection("jdbc:mysql://b778m35afj0hm3pmhpou-mysql.services.clever-cloud.com:3306/b778m35afj0hm3pmhpou?user=uuphcvlz6eijcak1&password=2eDCMXWnjGW6w5S9WYTW");
	        	pst2=con.prepareStatement("select * from E_wallet_users where userid=? and password=? and userstatus='active';");
				pst2.setString(1, userid);
	        	pst2.setString(2, pass);
				rs=pst2.executeQuery();
				
				//for pass failure trying
				
				//
				
	        	if(rs.next()) {
	            
	           
	        	
	            pst1 = con.prepareStatement("UPDATE walletaccounts SET balance=balance-? where accno=? and accno=?;");
	            pst1.setString(1, amount);
	            pst1.setString(2, fromacc);
	            pst1.setString(3, userid);
	            
	            pst = con.prepareStatement("UPDATE walletaccounts SET balance=balance+? where accno=?;");
	            pst.setString(1, amount);
	            pst.setString(2, toacc);
	            //pst1.setString(4, amount);
	           
	            int cnt1 = pst1.executeUpdate();
	            int cnt = pst.executeUpdate();
	            if(cnt == 1 && cnt1 == 1){
	               response.sendRedirect("moneytransffersuccessful.html");
	            }
	           
	        	
	            else{
	            	pst3 = con.prepareStatement("UPDATE walletaccounts SET balance=balance-? where accno=?;");
		            pst3.setString(1, amount);
		            pst3.setString(2, toacc);
		            pst3.execute();
	                response.sendRedirect("transferfailed.html");
	            }
	        	}
	            con.close();
	          //System.out.println("<h2>NO data found</h2>");
	        }
	        catch(Exception e){
	            System.out.println(e);
	            System.out.println("NO data found");
	           // response.sendRedirect("moneytransactionfail.html");
	        }
	      
	        
	}

}
