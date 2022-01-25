package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB_Connect;



public class SellerDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static boolean validate(String username,String password) {
		
		try {
			con = DB_Connect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from sellerinfo where username = '"+username+"' and password = '"+password+"'";	
			rs = stmt.executeQuery(sql);
			
			
			if(rs.next()) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public static List<Seller> getSeller(String username){
		
		ArrayList<Seller> Seller = new ArrayList<>();
		try {
			con = DB_Connect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from sellerinfo where username = '"+username+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int sellerID = rs.getInt(1);
				String fullname = rs.getString(2);
				String address = rs.getString(3);
				String nic = rs.getString(4);
				String phone = rs.getString(5);
				String email = rs.getString(6);
				String user2 = rs.getString(7);
				String pass2 = rs.getString(8);
				String producttypes = rs.getString(9);
				String frontimg = rs.getString(10);
				String backimg = rs.getString(11);
				
				Seller sel = new Seller(sellerID,fullname,address,nic,phone,email,user2,pass2,producttypes,frontimg,backimg);
				Seller.add(sel);
			}
			
		}catch(Exception e){
			
		}
		
		
		return Seller;
		
	}
	
	/*public static Seller getThiSeller(int sellerID){
		
		Seller sel = null;
		try {
			con = DB_Connect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from sellerinfo where sellerID = "+sellerID+"";
			rs = stmt.executeQuery(sql);

				int sid = rs.getInt(1);
				String fullname = rs.getString(2);
				String address = rs.getString(3);
				String nic = rs.getString(4);
				String phone = rs.getString(5);
				String email = rs.getString(6);
				String user2 = rs.getString(7);
				String pass2 = rs.getString(8);
				String producttypes = rs.getString(9);
				String frontimg = rs.getString(10);
				String backimg = rs.getString(11);
				
				sel = new Seller(sid,fullname,address,nic,phone,email,user2,pass2,producttypes,frontimg,backimg);

		} catch(Exception e){
			e.printStackTrace();
		}
		
		return sel;
		
	}*/
	
	public static int getSellerID(String username) {
		int sellerID = 0;
		
		try {
			con = DB_Connect.getConnection();
			stmt = con.createStatement();
			String sql = "select sellerID from sellerinfo where username = '"+username+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				sellerID = rs.getInt(1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return sellerID;
	}
	
	
	
	
	public static boolean insertseller(String fullname, String address, String nic, String phone,String email, String username, String password, String producttypes, String frontimg, String backimg ) {
		
		boolean isSuccess = false;
		
	
		try {
			
			
			con = DB_Connect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into sellerinfo (sellerID,fullname,address,nic,phone,email,username,password,producttypes,frontimg,backimg)"
					+ "values (0,'"+fullname+"','"+address+"','"+nic+"','"+phone+"','"+email+"','"+username+"','"+password+"','"+producttypes+"','"+frontimg+"','"+backimg+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static boolean updateseller(String sellerID, String fullname,String address, String nic, String phone, String email, String username, String password, String producttypes, String frontimg, String backimg) {
		
		
		
		try {
			
			con = DB_Connect.getConnection();
			stmt = con.createStatement();
			String sql = "update sellerinfo set fullname='"+fullname+"',address='"+address+"',nic='"+nic+"',phone='"+phone+"',email='"+email+"',username='"+username+"',password='"+password+"',producttypes='"+producttypes+"',frontimg='"+frontimg+"',backimg='"+backimg+"'"
						+ "where sellerID='"+sellerID+"'" ;
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	
		return isSuccess;
	}
	
	public static List<Seller> getSellerDetails(String sellerID){
		
		int convertedsellerID = Integer.parseInt(sellerID);
		
		ArrayList<Seller> sel = new ArrayList<>();
		
		try {
			
			con = DB_Connect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from sellerinfo where sellerID='"+convertedsellerID+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int sellerid = rs.getInt(1);
				String fullname = rs.getString(2);
				String address = rs.getString(3);
				String nic = rs.getString(4);
				String phone = rs.getString(5);
				String email = rs.getString(6);
				String username = rs.getString(7);
				String password = rs.getString(8);
				String producttypes = rs.getString(9);
				String frontimg = rs.getString(10);
				String backimg = rs.getString(11);
				
				Seller s = new Seller(sellerid,fullname,address,nic,phone,email,username,password,producttypes,frontimg,backimg);
				sel.add(s);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return sel;
		
	}
	
	public static boolean deleteseller(String sellerID) {
		
		int convertId = Integer.parseInt(sellerID);
		try {
			con = DB_Connect.getConnection();
			stmt = con.createStatement();
			String sql = "delete from sellerinfo where sellerID = '"+convertId+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return isSuccess;
	}
}
