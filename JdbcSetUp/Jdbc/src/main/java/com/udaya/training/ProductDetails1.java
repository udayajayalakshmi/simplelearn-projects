package com.udaya.training;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductDetails1
 */
@WebServlet("/ProductDetails1")
public class ProductDetails1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetails1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			InputStream in = getServletContext().getResourceAsStream("/WEBINF/config.properties"); 
			Properties props = new Properties(); props.load(in);
			DBConnection conn = new DBConnection(props.getProperty("url"),
			props.getProperty("userid"), props.getProperty("password"));
			CallableStatement stmt = conn.getConnection().prepareCall("{call
			add_product(?, ?)}");"
					 stmt.setString(1, "new product");stmt.setBigDecimal(2, new BigDecimal(1900.50));
					 stmt.executeUpdate();
			out.println("Stored procedure has been executed.<Br>"); stmt.close();
			out.println("</body></html>"); conn.closeConnection();
			}
	catch (ClassNotFoundException e) { e.printStackTrace();
			} 
			catch (SQLException e) {
				e.printStackTrace();
	}

}
