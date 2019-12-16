package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Book;
import com.service.ConnectionDao;
import com.service.DeleteDao;
@WebServlet("/delete")
public class BookDelete extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		doGet(request,response);
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String id=request.getParameter("id");
		//PrintWriter out = response.getWriter();
		//out.println(id);
		
		
		Book book=new Book();
		book.setId(id);
		DeleteDao.DeleteBook(book);
		try {
			response.sendRedirect("ShowList");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
