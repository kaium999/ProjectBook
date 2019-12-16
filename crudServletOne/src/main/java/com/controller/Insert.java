package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.entity.Book;
import com.service.*;
@WebServlet("/insert")
public class Insert extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response) {
		doGet(request,response);
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) {
		String id=request.getParameter("id");
		String Book_name=request.getParameter("name");
		String Book_price=request.getParameter("price");
		String Book_author=request.getParameter("author");
		Book book=new Book();
		book.setId(id);
		book.setBook_name(Book_name);
		book.setBook_price(Book_price);
		book.setBookAuthor(Book_author);
		ConnectionDao connection = new ConnectionDao();
		connection.insertBook(book);
		RequestDispatcher rs=request.getRequestDispatcher("ShowList");
		try {
			rs.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
