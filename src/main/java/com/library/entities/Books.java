package com.library.entities;

public class Books {

	long bookId;
	String bookName;
	String bookAuthor;
	String booktype;
	long quantity;
	
	
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Books(long bookId, String bookName, String bookAuthor, String booktype, long quantity) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.booktype = booktype;
		this.quantity = quantity;
	}
	
	
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBooktype() {
		return booktype;
	}
	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	
	
	
	
}
