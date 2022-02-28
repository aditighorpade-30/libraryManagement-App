package com.library.entities;

public class Borrowers {
	
long borrowerId;
String borrowerName;
String borrowerAddress;
String borrowerPassword;
long Phone;
String mail;
String bookname;

public Borrowers() {
	super();
	// TODO Auto-generated constructor stub
}

public Borrowers(long borrowerId, String borrowerName, String borrowerAddress,String borrowerPassword, long phone, String mail, String bookname ) {
	super();
	this.borrowerId = borrowerId;
	this.borrowerName = borrowerName;
	this.borrowerAddress = borrowerAddress;
	this.borrowerPassword=borrowerPassword;
	Phone = phone;
	this.mail = mail;
	this.bookname = bookname;
}

public long getBorrowerId() {
	return borrowerId;
}
public void setBorrowerId(long borrowerId) {
	this.borrowerId = borrowerId;
}
public String getBorrowerName() {
	return borrowerName;
}
public void setBorrowerName(String borrowerName) {
	this.borrowerName = borrowerName;
}
public String getBorrowerAddress() {
	return borrowerAddress;
}
public void setBorrowerAddress(String borrowerAddress) {
	this.borrowerAddress = borrowerAddress;
}

public String getBorrowerPassword() {
	return borrowerPassword;
}
public void setBorrowerPassword(String borrowerPassword) {
	this.borrowerPassword = borrowerPassword;
}


public long getPhone() {
	return Phone;
}
public void setPhone(long phone) {
	Phone = phone;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}

public String getBookName() {
	return bookname;
}
public void setBookName(String bookname) {
	this.bookname = bookname;
}
}
