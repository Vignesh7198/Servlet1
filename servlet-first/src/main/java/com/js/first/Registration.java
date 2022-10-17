package com.js.first;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Registration extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
String name = req.getParameter("name");
String email = req.getParameter("email");




		PrintWriter pw = res.getWriter();
		pw.print("Welcome" +name);
		pw.print("Your mail is" +email);

		
	}
	


}
