package com.js.sc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/view")
public class GetAllProducts extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ProductCrud productCrud = new ProductCrud();
		List<Product> products = productCrud.getAllProduct();
		if(products.size()>0) {
			RequestDispatcher rd = req.getRequestDispatcher("getAll.jsp");
			req.setAttribute("list", products);
			rd.forward(req, resp);
		}
		else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.print("NO PRODUCTS");
			
		}
	
	}

	
	
}
