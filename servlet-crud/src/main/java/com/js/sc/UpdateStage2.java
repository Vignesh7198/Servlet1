package com.js.sc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/updateproduct")
public class UpdateStage2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Product p = new Product();
		p.setId(Integer.parseInt(req.getParameter("id")));
		p.setBrand(req.getParameter("brand"));
		p.setName(req.getParameter("name"));
		p.setPrice(Double.parseDouble(req.getParameter("price")));
		p.setQuantity(Integer.parseInt(req.getParameter("quantity")));
	
		ProductCrud productCrud = new ProductCrud();
		int a = productCrud.updateProduct(p.getId(), p);
		if(a>0) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("view");
			dispatcher.forward(req, resp);
		}else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.print("NO PRODUCT WITH GIVEN ID TO UPDATE");
		}	}
	
	

}
