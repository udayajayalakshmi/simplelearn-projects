package com.udaya.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ListProducts")
public class ListProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession(); 
			// using HQL 
			List<EProduct> list = session.createQuery("from EProduct").list();
			session.close();
			PrintWriter out = response.getWriter();
			out.println("<html><body>"); 
			out.println("<b>Product Listing</b><br>");
			for(EProduct p: list) { 
				String br;
				out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.
			
			getName() + ", Price: " + String.valueOf(p.getPrice()) + ", Date Added:"
			" + p.getDateAdded().toString() + "<br>"); 
					}
			out.println("</body></html>");
			} 
	catch (Exception ex) { 
				throw ex;
	}

	}
}
