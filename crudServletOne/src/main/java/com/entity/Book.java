package com.entity;

public class Book {
private String id;
private String Book_name;
private String Book_price;
private String BookAuthor;
public Book(String id, String book_name, String book_price, String bookAuthor) {
	super();
	this.id = id;
	Book_name = book_name;
	Book_price = book_price;
	BookAuthor = bookAuthor;
}
public Book(String book_name, String book_price, String bookAuthor) {
	super();
	Book_name = book_name;
	Book_price = book_price;
	BookAuthor = bookAuthor;
}
public Book() {
	super();
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getBook_name() {
	return Book_name;
}
public void setBook_name(String book_name) {
	Book_name = book_name;
}
public String getBook_price() {
	return Book_price;
}
public void setBook_price(String book_price) {
	Book_price = book_price;
}
public String getBookAuthor() {
	return BookAuthor;
}
public void setBookAuthor(String bookAuthor) {
	BookAuthor = bookAuthor;
}

}
