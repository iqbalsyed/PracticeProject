package com.simplilearn.webapp.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.webapp.db.DatabaseConnection;

/**
 * Servlet implementation class retrive
 */
@WebServlet("/retrieve-details")
public class retrive extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public retrive() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		response.sendRedirect("retrieve-details.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		DatabaseConnection db = null;
		String productId = request.getParameter("product_id");
		
		try {
			// step 1: create connection
			db = new DatabaseConnection();
			db.init();
			
			// step 2: create statement and execute query 
			String query = "SELECT * FROM eproducts WHERE product_id =" +productId;
			int nfra = db.executeUpdate(query);
			//request.getRequestDispatcher("index.jsp").include(request, response);

	
			ResultSet rst = db.executeQuery(query);
			if(rst.next()) {
				 String productName = rst.getString("product_name");
			     String productDescription = rst.getString("product_desc");
			     double productPrice = rst.getDouble("price");
			     
			     
			     
			     response.getWriter().println("<h1>Product Details</h1>");
			     response.getWriter().println("<p>Product ID: " + productId + "</p>");
			     response.getWriter().println("<p>Product Name: " + productName + "</p>");
			     response.getWriter().println("<p>Product Description: " + productDescription + "</p>");
			     response.getWriter().println("<p>Product Price: " + productPrice + "</p>");
			}else {
		        response.getWriter().println("<h1>Product not found!</h1>");
		      }
			} catch (Exception e) {
				e.printStackTrace();
				out.println("<h2> Exception Occured </h2>");
			} finally {
				out.close();
				db.close();
			}
	}

}
