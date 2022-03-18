package com.udaya.learning;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoJdbc
 */
@WebServlet("/demoJdbc")
public class DemoJdbc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoJdbc() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter(); 
			out.println("<html><body>");
			InputStream in = getServletContext().getResourceAsStream("/WEBINF/config.properties");
			Properties props = new Properties();
			props.load(in);
		JdbcConnection conn = new JdbcConnection(props.getProperty("url"),
					props.getProperty("userid"), props.getProperty("password"));
			out.println("DB Connection initialized.<br>");
					conn.closeConnection();
					out.println("DB Connection closed.<br>");
					out.println("</body></html>"); 
					conn.closeConnection();
					} 
		catch (ClassNotFoundException e) { 
						e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
					
	
	
