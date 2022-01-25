package model;


import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Blob;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;

import db.DB_Connect;


public class ItemUtil {
	
	private static Connection cn = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	private static PreparedStatement pstmt = null;
	private static boolean isSuccess= false;

	public static boolean addItem(String name,String category, int qty, float price, String desc, int sid, String pic) {
		
		FileInputStream fis=null;
		
		try {
			cn = DB_Connect.getConnection();
			
			File image= new File(pic);
			fis=new FileInputStream(image);
			
			
			pstmt = (PreparedStatement) cn.prepareStatement("insert into item values(0, ?, ?, ?, ?, ?, ?, ?)");
			
			pstmt.setString(1, name);
			pstmt.setString(2, category);
			pstmt.setInt(3, qty);
			pstmt.setFloat(4, price);
			pstmt.setString(5, desc);
			pstmt.setInt(6, sid);
			pstmt.setBinaryStream(7, (InputStream) fis, (int) (image.length()));
			
			int count = pstmt.executeUpdate();
			
			if(count>0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
	
	public static HashSet<Item> getItemList() {
		
		HashSet<Item> item = new HashSet<>();
		
		try {
			cn = DB_Connect.getConnection();
			st = cn.createStatement();
			
			String sql= "select * from item";
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String category =rs.getString(3);
				int qty = rs.getInt(4);
				float price = rs.getFloat(5);
				String desc = rs.getString(6);
				String sid = rs.getString(7);
				Blob image = rs.getBlob(8);
				
				byte[] imgData = image.getBytes(1, (int)image.length());
				String imgString = new String(Base64.getEncoder().encode(imgData));
				
				Item i = new Item(id, name, category, qty, price, desc, sid);
				i.setImage(imgString);
				item.add(i);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return item;
	}
	
	public static ArrayList<Item> getMyItems(int sellerID) {
		
		ArrayList<Item> item = new ArrayList<>();
		
		try {
			cn = DB_Connect.getConnection();
			st = cn.createStatement();
			
			String sql= "select * from item where seller_id = '"+sellerID+"'";
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String category =rs.getString(3);
				int qty = rs.getInt(4);
				float price = rs.getFloat(5);
				String desc = rs.getString(6);
				String sid = rs.getString(7);
				Blob image = rs.getBlob(8);
				
				byte[] imgData = image.getBytes(1, (int)image.length());
				String imgString = new String(Base64.getEncoder().encode(imgData));
				
				Item i = new Item(id, name, category, qty, price, desc, sid);
				i.setImage(imgString);
				item.add(i);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return item;
	}
	
	public static boolean deleteItem(String itemID) {
		
		try {
			cn = DB_Connect.getConnection();
			st = cn.createStatement();

			String sql= "DELETE FROM item WHERE item_number = '"+itemID+"'";
			int rs = st.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
				
			} 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static  boolean updateItem(int itemID, String name, String category, int qty, float price, String desc) {
		
		try {
			cn = DB_Connect.getConnection();
			st = cn.createStatement();

			String sql= "update item set item_name='"+name+"', item_category='"+category+"', quantity='"+qty+"', item_price='"+price+"', item_description='"+desc+"' where item_number='"+itemID+"'";
			int rs = st.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
				
			} 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
public static HashSet<Item> getSearchItems(String search) {
		
		HashSet<Item> item = new HashSet<>();
		String sql;
		
		try {
			cn = DB_Connect.getConnection();
			st = cn.createStatement();
			
			sql= "select * from item where item_name like '%"+search+"%'";
			
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String category =rs.getString(3);
				int qty = rs.getInt(4);
				float price = rs.getFloat(5);
				String desc = rs.getString(6);
				String sid = rs.getString(7);
				Blob image = rs.getBlob(8);
				
				byte[] imgData = image.getBytes(1, (int)image.length());
				String imgString = new String(Base64.getEncoder().encode(imgData));
				
				Item i = new Item(id, name, category, qty, price, desc, sid);
				i.setImage(imgString);
				item.add(i);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return item;
	}


public static HashSet<Item> getCatSearchItems(String search) {
	
	HashSet<Item> item = new HashSet<>();
	String sql;
	
	try {
		cn = DB_Connect.getConnection();
		st = cn.createStatement();
		
		sql= "select * from item where item_category='"+search+"'";
		
		rs = st.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String category =rs.getString(3);
			int qty = rs.getInt(4);
			float price = rs.getFloat(5);
			String desc = rs.getString(6);
			String sid = rs.getString(7);
			Blob image = rs.getBlob(8);
			
			byte[] imgData = image.getBytes(1, (int)image.length());
			String imgString = new String(Base64.getEncoder().encode(imgData));
			
			Item i = new Item(id, name, category, qty, price, desc, sid);
			i.setImage(imgString);
			item.add(i);
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	return item;
}


public static void addtocart(String cid) throws SQLException{
	
	
	
	
	//connection
	cn = DB_Connect.getConnection();
	Statement stmt = cn.createStatement();
	rs = stmt.executeQuery("SELECT item_number,item_name,item_description,item_category,item_price FROM item WHERE item_number='"+cid+"'");
	
	while(rs.next()) {
		
		int id = rs.getInt(1);
		String name = rs.getString(2);
		String desc = rs.getString(3);
		String category =rs.getString(4);
		float price = rs.getFloat(5);
		
		
		
		int qty=1;			
		
		
		PreparedStatement pstat1=cn.prepareStatement("INSERT INTO cart VALUES ("+id+",'"+name+"','"+desc+"','"+category+"',"+price+","+qty+")");
		
		pstat1.executeLargeUpdate();
	}
	
	
}



public static List<Item> getcartItemList() throws SQLException{
	
	ArrayList<Item> item = new ArrayList<>();
	
	//connection
	cn = DB_Connect.getConnection();
	Statement stmt = cn.createStatement();
	ResultSet rs = stmt.executeQuery("select c.Item_id, c.Item_name, c.Item_desc, c.Item_category, c.Item_price, c.Quantity, i.photo from cart c, item i where c.Item_id=i.item_number");
	
	
	while(rs.next()) {
		
		int id = rs.getInt(1);
		String name = rs.getString(2);
		String desc = rs.getString(3);
		String category =rs.getString(4);
		float price = rs.getFloat(5);
		int qty = rs.getInt(6);
		Blob image = rs.getBlob(7);
		
		byte[] imgData = image.getBytes(1, (int)image.length());
		String imgString = new String(Base64.getEncoder().encode(imgData));
		
		
		Item i = new Item(id, name, category, qty, price, desc);
		i.setImage(imgString);
		item.add(i);
	}
	
	return item;
	
	
}


 public static void deleteCartItem(String cid) throws SQLException {
	
	int newid=Integer.parseInt(cid);
	
	cn=DB_Connect.getConnection();
	PreparedStatement pstat=cn.prepareStatement("Delete from cart where Item_id="+newid+"");
	pstat.executeUpdate();
	
}

 
 public static void updateitem(String qty,String eid) throws SQLException {
	 
	 int uid=Integer.parseInt(eid);
	 
	cn=DB_Connect.getConnection();
		PreparedStatement pstat=cn.prepareStatement("update cart set Quantity="+qty+" where Item_id="+uid+"");
		pstat.executeUpdate();
 }
 
 
 
 public static void gettotal(String total) throws SQLException {
	 
	 float ftotal=Float.parseFloat(total);    	 
	 cn=DB_Connect.getConnection();
	 PreparedStatement pstat2=cn.prepareStatement("INSERT INTO online_shopping.order VALUES(0,"+ftotal+");");		
	
	 pstat2.executeLargeUpdate();
	 
	 PreparedStatement pstat3=cn.prepareStatement("DELETE FROM cart");
	 pstat3.executeUpdate();
	
	 
 }
	
}
