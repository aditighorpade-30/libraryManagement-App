package com.library.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.library.dao.DBconnection;
import com.library.entities.*;

public class LibraryEmployeesDBOperation {

	DBconnection ob=new DBconnection();
	Connection conn=ob.connection();
	public boolean login(long eid,String password) throws SQLException
	{
		
		
		PreparedStatement stmt=conn.prepareStatement("select * from librarystaff where staffid=? and staffpassword=? ");
		stmt.setLong(1, eid);
		stmt.setString(2,password);
		
		ResultSet result=stmt.executeQuery();
		if(result.next())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean accountClose(long userId) throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement("delete from borrowers where borrowerid=? ");
		stmt.setLong(1, userId);
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
	public boolean openAccount(Borrowers e) throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement("insert into borrowers values(?,?,?,?,?,?,?) ");
		
		stmt.setLong(1, e.getBorrowerId());
		stmt.setString(3,e.getBorrowerName());
		stmt.setString(4,e.getBorrowerAddress());
		stmt.setString(2, e.getBorrowerPassword());	
		stmt.setLong(5,e.getPhone());
		stmt.setString(6, e.getMail());
		stmt.setString(7, e.getBookName());
		
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
	public ResultSet checkBorrowersinfo(long accId) 
	{
		ResultSet result=null;
		try
		{
		PreparedStatement stmt=conn.prepareStatement("select * from borrowers where borrowerId=? ");
		stmt.setLong(1, accId);
		result=stmt.executeQuery();
	
		}
		catch(Exception e)
		{
			System.out.println("Wrong Borrowers Id..!!");
		}
		return result;
	}

	public boolean changePassword(long eid,String newPassword) throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement("update librarystaff set staffpassword=? where staffid=? ");
		stmt.setString(1,newPassword);
		stmt.setLong(2, eid);
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
	
	public void logout() throws SQLException
	{
		conn.close();
		
	}

}
