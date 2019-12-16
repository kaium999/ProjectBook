package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.entity.Book;
import com.service.ConnectionDao;
@WebServlet("/ShowList")
public class ShowBook extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	

	protected void doPost(HttpServletRequest request,HttpServletResponse response) {
		doGet(request,response);
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse reponse) {
		//ConnectionDao connection = new ConnectionDao();
		List<Book>listBook=ConnectionDao.listAllBooks();
		request.setAttribute("listBook", listBook);
		RequestDispatcher rd=request.getRequestDispatcher("/views/ShowList.jsp");
		try {
			rd.forward(request, reponse);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
