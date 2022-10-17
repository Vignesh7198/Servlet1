package com.js.sc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/login")
public class Login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		
		String email = req.getParameter("email");
		
		String password = req.getParameter("password");
	
		
		if(email.equals("vickymcchss@gmail.com") && password.equals("12345")) {
			
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("start", email);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("home.html");
			dispatcher.forward(req, resp);
			
		}
		else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.print("wrong credentials");
			
			resp.sendRedirect("login.html");
		}
		
	
	}
	
	

	
	
	
}
