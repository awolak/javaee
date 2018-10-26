package pl.awolak.javaee.zad03.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/add-bed")
public class AddBedServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Add Bed:</h2>" +
				"<form action='all-beds'>" +
				"Name: <input type='text' name='name' /> <br />" +
				"Production date: <input type='text' name='productionDate' /> <br />" +
				"Width: <input type='text' name='width' /> <br />" +
				"Is Wood: <select name='isSoftStatus'>" +
				"<option value='true'>Yes</option>" +
				"<option value='false'>No</option>" +
				"</select><br />" +
				"<input type='submit' value=' Add ' />" +
				"</form>" +
				"</body></html>");
		out.close();
	}

}
