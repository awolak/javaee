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

@WebServlet(urlPatterns = "/all-beds")
public class AllBedsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");

        List<Bed> allBeds = ss.getAllBeds();

        out.append("<html><body><h2>All Beds:</h2>");

        for (Bed bed: allBeds) {
            if(bed.getQuantity() > 0){
                out.append("<form action='add-to-cart'>");
                out.append("<input type='hidden' name='id' value='" + bed.getId() + "'/>");
                out.append("<p>id: " + bed.getId() + "</p>");
                out.append("<p>Producer: " + bed.getProducer() + "</p>");
                out.append("<p>Production date: " + bed.getProductionDate() + "</p>");
                out.append("<p>Width: " + bed.getWidth() + "</p>");
                out.append("<p>Price: " + bed.getPrice() + "</p>");
                out.append("<p>Quantity: " + bed.getQuantity() + "</p>");
                out.append("<p>Is soft: " + bed.getIsSoft() + "</p><br>");
                out.append("<input type='submit' value=' Add to Cart' />");
                out.append("</form>");
            }
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
