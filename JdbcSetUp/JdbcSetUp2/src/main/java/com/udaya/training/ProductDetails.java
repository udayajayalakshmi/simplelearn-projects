package com.udaya.training;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductDetails")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductDetails() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			InputStream in = getServletContext().getResourceAsStream("/WEBINF/config.properties");
			Properties props = new Properties(); props.load(in);
			DBConnection conn = new DBConnection(props.getProperty("url"),
			props.getProperty("userid"), props.getProperty("password")); 
			Statement stmt = conn.getConnection().createStatement(ResultSet.
			TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.executeUpdate("insert into eproduct (name, price, date_added)values ('New Product', 17800.00, now())\");
			
					+ " out.println("Executed an insert operation<br>");
			stmt.executeUpdate("update eproduct set price=2000 where name =
			'New Product'"); 
					out.println("Executed an update operation<br>");
			stmt.executeUpdate("delete from eproduct where name = 'New Product'" );
			out.println("Executed a delete operation<br>"); stmt.close();
			conn.closeConnection();
			out.println("</body></html>");
			conn.closeConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


