package pl.awolak.javaee.zad03.web;

import pl.awolak.javaee.zad03.domain.Bed;
import pl.awolak.javaee.zad03.service.StorageService;

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

@WebServlet(urlPatterns = "/all-beds")
public class AllBedsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();

		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");


		String name = request.getParameter("name");
		Date productionDate = null;
		try {
			productionDate = formatter.parse(request.getParameter("productionDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		double width = Double.parseDouble(request.getParameter("width"));
		boolean isSoft = Boolean.parseBoolean(request.getParameter("isSoft"));

		StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");


		Bed newBed = new Bed(name, productionDate, width, isSoft);

		ss.add(newBed);

		List<Bed> allBeds = ss.getAllBeds();

		out.append("<html><body><h2>All Beds:</h2>");

		for (Bed bed: allBeds) {
			out.append("<p>Name: " + bed.getName() + "</p>");
			out.append("<p>Production date: " + bed.getProductionDate() + "</p>");
			out.append("<p>Width: " + bed.getWidth() + "</p>");
			out.append("<p>Is wood: " + bed.isSoftStatus() + "</p><br>");
		}

		out.append("</body></html>");
		out.close();
	}

	@Override
	public void init() throws ServletException {

		// application context
		getServletContext().setAttribute("storage_service", new StorageService());
	}
}
