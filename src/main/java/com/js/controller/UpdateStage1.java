package com.js.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.dao.BookCRUD;
import com.js.dto.Book;
@WebServlet(value="/update")
public class UpdateStage1 extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookCRUD bc =new BookCRUD();
		Book b=bc.getBookById(Integer.parseInt(req.getParameter("id")));
		if(b!=null) {
			RequestDispatcher rd=req.getRequestDispatcher("update.jsp");
			req.setAttribute("book", b);
			rd.forward(req, resp);
		}else {
			RequestDispatcher rd=req.getRequestDispatcher("result.jsp");
			req.setAttribute("msg", "FAILED TO UPDATE");
			rd.forward(req, resp);

		}
	}
}
