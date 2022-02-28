package com.library.entities;

public class LibraryEmployee {

	int staffid;
	String staffname;
	String staffpassword;
	
	public LibraryEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LibraryEmployee(int staffid, String staffname, String staffpassword) {
		super();
		this.staffid = staffid;
		this.staffname = staffname;
		this.staffpassword = staffpassword;
	}
	
	public int getStaffid() {
		return staffid;
	}
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	public String getStaffname() {
		return staffname;
	}
	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}
	public String getStaffpassword() {
		return staffpassword;
	}
	public void setStaffpassword(String staffpassword) {
		this.staffpassword = staffpassword;
	}
		
	
}
