package ug.awolak.javaee.zad03.web;

import com.sun.org.apache.xpath.internal.operations.Bool;
import ug.awolak.javaee.zad03.domain.Bed;
import ug.awolak.javaee.zad03.service.StorageService;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/store-bed")
public class StoreBedServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();

		StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");

		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

		String producer = request.getParameter("producer");
		Date productionDate = null;
		try {
			productionDate = formatter.parse(request.getParameter("productionDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		double width = Double.parseDouble(request.getParameter("width"));
		boolean isSoft = Boolean.parseBoolean(request.getParameter("isSoft"));
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		int id = ss.getId();

		Bed newBed = new Bed(id, producer, productionDate, width, price, quantity, isSoft);

		ss.add(newBed);

		List<Bed> allBeds = ss.getAllBeds();

		out.append("<html><body><h2>All Beds:</h2>");

		for (Bed bed: allBeds) {
			out.append("<p>id: " + bed.getId() + "</p>");
			out.append("<p>Producer: " + bed.getProducer() + "</p>");
			out.append("<p>Production date: " + bed.getProductionDate() + "</p>");
			out.append("<p>Combustion: " + bed.getWidth() + "</p>");
			out.append("<p>Price: " + bed.getPrice() + "</p>");
			out.append("<p>Quantity: " + bed.getQuantity() + "</p>");
			out.append("<p>Is soft: " + bed.getIsSoft() + "</p><br>");
		}

		out.append("<a href='add-bed'>Add bed</a><br>");
		out.append("<a href='all-beds'>Go to store</a>");
		out.append("</body></html>");
		out.close();
	}

	@Override
	public void init() throws ServletException {

		// application context
		getServletContext().setAttribute("storage_service", new StorageService());
	}
}
