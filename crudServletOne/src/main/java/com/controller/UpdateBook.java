package com.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Book;
import com.service.ConnectionDao;
@WebServlet("/update")
public class UpdateBook extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response) {
		doGet(request,response);
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) {
		String Book_name=request.getParameter("name");
		String Book_price=request.getParameter("price");
		String Book_author=request.getParameter("author");
		Book book=new Book(Book_name,Book_price,Book_author);
		ConnectionDao.updateBook(book);
		try {
			response.sendRedirect("ShowList");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
