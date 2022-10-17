package com.js.first;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Login extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		if(email.equals("vickymcchss@gmail.com") && password.equals("1234")) {
			RequestDispatcher rd = req.getRequestDispatcher("Sucess.html");
			rd.forward(req, res);
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
			
		
		

	}

}
