package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.Book;

public class ConnectionDao {
	private static Connection connection = null;
	public static Connection getconection() {
		if(connection!=null) {
			return connection;
		}else {
			 PreparedStatement pst = null;
			   ResultSet rs = null;
			   Statement statement = null;
			 String url = "jdbc:postgresql://localhost/BookInformation";
			 String driver = "org.postgresql.Driver";
		     String user = "postgres";
		     String password = "1234";
		     try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     try {
				connection=DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	}
	public static void insertBook(Book book) {
		
		 ResultSet rs = null;
		 Statement statement = null;
		 Connection connection = null;
		 
		 String url = "jdbc:postgresql://localhost/BookInformation";
		 String driver = "org.postgresql.Driver";
	     String user = "postgres";
	     String password = "1234";
	     try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     connection = getconection();
	     try {
			statement=connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			String insert_query="insert into book(id,book_name,book_price,book_author)values('"+book.getId()+"','"+book.getBook_name()+"','"+book.getBook_price()+"','"+book.getBookAuthor()+"')";
			try {
				statement.executeUpdate(insert_query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static List<Book>listAllBooks(){
		 String url = "jdbc:postgresql://localhost/BookInformation";
		 String driver = "org.postgresql.Driver";
	     String user = "postgres";
	     String password = "1234";
	     ResultSet rs = null;
		 Statement statement = null;
		 Connection connection = null;
		
		 try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 connection=getconection();
		 try {
			statement=connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 String listQuery="select * from book;";
		 List<Book>booklist=new ArrayList<Book>();
		 try {
			rs = statement.executeQuery(listQuery);
			while(rs.next()) {
				 Book book=new Book();
				 book.setId(rs.getString("id"));
				 book.setBook_name(rs.getString("book_name"));
				 book.setBook_price(rs.getString("book_price"));
				 book.setBookAuthor(rs.getString("book_author"));
				 booklist.add(book);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return booklist;
	}
	public static Book getBook(String id) {
		 String url = "jdbc:postgresql://localhost/BookInformation";
		 String driver = "org.postgresql.Driver";
	     String user = "postgres";
	     String password = "1234";
	     ResultSet rs = null;
		 Statement statement = null;
		 Connection connection = null;
		 Book book=new Book();
		 try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection=getconection();
		try {
			statement=connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String UpdateQuery="update book set book_name='"+book.getBook_name()+"',book_price'"+book.getBook_price()+"',book_author='"+book.getBookAuthor()+"';";
		try {
			rs=statement.executeQuery(UpdateQuery);
			while(rs.next()) {
				//Book book=new Book();
				 book.setId(rs.getString("id"));
				 book.setBook_name(rs.getString("book_name"));
				 book.setBook_price(rs.getString("book_price"));
				 book.setBookAuthor(rs.getString("book_author"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	public static void updateBook(Book book) {
		 String url = "jdbc:postgresql://localhost/BookInformation";
		 String driver = "org.postgresql.Driver";
	     String user = "postgres";
	     String password = "1234";
	     ResultSet rs = null;
		 Statement statement = null;
		 Connection connection = null;
		 try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 connection=getconection();
		 try {
			statement=connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String updateQuery="update book set book_name='"+book.getBook_name()+"',book_price'"+book.getBook_price()+"',book_author='"+book.getBookAuthor()+"';";
		 try {
			statement.executeUpdate(updateQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*public static void  DeleteBook(Book book) {
		 String url = "jdbc:postgresql://localhost/BookInformation";
		 String driver = "org.postgresql.Driver";
	     String user = "postgres";
	     String password = "1234";
	     ResultSet rs = null;
		 Statement statement = null;
		 Connection connection = null;
		 try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 connection=getconection();
		 try {
			statement=connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String deleteQuery="delete from book where id='"+book.getId()+"';";
		 try {
			statement.executeUpdate(deleteQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}*/
	
}
