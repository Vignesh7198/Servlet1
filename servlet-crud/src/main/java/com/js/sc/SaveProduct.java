package com.js.sc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/register")
public class SaveProduct extends HttpServlet {
	
	static int i = 1;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	Product p = new Product();
	p.setId(Integer.parseInt(req.getParameter("id")));
	p.setBrand(req.getParameter("brand"));
	p.setName(req.getParameter("name"));
	p.setPrice(Double.parseDouble(req.getParameter("price")));
	p.setQuantity(Integer.parseInt(req.getParameter("quantity")));

	System.out.println(p.getId());
	System.out.println(p.getBrand());
	System.out.println(p.getName());
	System.out.println(p.getPrice());
	System.out.println(p.getQuantity());



ProductCrud pc = new ProductCrud();

int a = pc.saveProduct(p);

PrintWriter pw = resp.getWriter();
if(a>0) {
	RequestDispatcher dispatcher = req.getRequestDispatcher("home.html");
	dispatcher.forward(req, resp);}
else
	pw.print("Product Not Saved");



	}

	
	
	
}
