package com.Ewallets.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddtransactionRecord {
	private String uid;
	private String facc;
	private String tacc;
	private String tamt;
	public String status;
	public String getStatus() {
		return status;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public String getFacc() {
		return facc;
	}
	public void setFacc(String facc) {
		this.facc = facc;
	}
	public String getTacc() {
		return tacc;
	}
	public void setTacc(String tacc) {
		this.tacc = tacc;
	}
	public String getTamt() {
		return tamt;
	}
	public void setTamt(String tamt) {
		this.tamt = tamt;
		insertData();
	}
	
	public void insertData() {
		Connection con;
		PreparedStatement pst;
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		Date date=new Date();
		
		String time= formatter.format(date);
		WalletUsersDBConnection obj=new WalletUsersDBConnection();

		try {
			con=obj.getDbconnection();
			pst=con.prepareStatement("INSERT INTO TransactionRecord VALUES(?,?,?,?)");
			pst.setString(1, facc);
			pst.setString(2, tacc);
			pst.setString(3, tamt);
			pst.setString(4, time);
			pst.executeUpdate();
			status="success";
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
			status="failed";
		}
	}
	
}
