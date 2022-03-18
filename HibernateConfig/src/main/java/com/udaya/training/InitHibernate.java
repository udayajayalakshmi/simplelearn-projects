package com.udaya.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.websocket.Session;

/**
 * Servlet implementation class InitHibernate
 */
@WebServlet("/InitHibernate")
public class InitHibernate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InitHibernate() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			out.println("<html><body>"); 
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			out.println("Hibernate Session opened.<br>");
			session.close(); out.println("Hibernate Session closed.<br>");
			out.println("</body></html>");
			} 
		catch (Exception ex) { 
			throw ex;
			}
	}

}
