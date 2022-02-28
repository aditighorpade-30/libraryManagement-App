package com.library.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;
import com.library.entities.Books;
import com.library.entities.Borrowers;

public class BorrowersDBOperation {

//database connection
	DBconnection ob=new DBconnection();
	Connection conn=ob.connection();

//login
	public boolean login(long accid, String password) throws SQLException
	{
		
		PreparedStatement stmt=conn.prepareStatement("select * from borrowers where borrowerid=? and borrowerpassword=? ");
		stmt.setLong(1, accid);
		stmt.setString(2, password);
		
		ResultSet result=stmt.executeQuery();
		if(result.next()) //true or false
		{
		return true;
		}
		else
		{
			return false;
		}
	}
	
//logout
	public void logout() throws SQLException
	{
		conn.close();
		
	}
	
//change password
	public boolean changePassword(long accid,String newPassword) throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement("update borrowers set borrowerpassword=? where borrowerid=? ");
		stmt.setString(1,newPassword);
		stmt.setLong(2, accid);
		int affectedRows=stmt.executeUpdate();
		if(affectedRows>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
		
//add Books
	

	public boolean addBooks(Books e) throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement("insert into books values(?,?,?,?,?) ");
		
		stmt.setLong(1, e.getBookId());
		stmt.setString(2,e.getBookName());
		stmt.setString(3,e.getBookAuthor());
		stmt.setString(4,e.getBooktype());
		stmt.setLong(5, e.getQuantity());
	
		int affectedRows=stmt.executeUpdate();
		if(affectedRows>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}	
	
	
 public ResultSet booksList(long accid)
   {
	   ResultSet rs=null;
	   try
	   {
	   PreparedStatement pr=conn.prepareStatement("select * from books where bookId=? ");
	   pr.setLong(1, accid);
	   rs=pr.executeQuery();
	   }
	   catch(Exception e)
	   {
		   System.out.println("something went wrong!!!");
	   }
	   return rs;
   }

}

