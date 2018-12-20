package ug.awolak.javaee.kolokwium2.web;

import com.sun.org.apache.xpath.internal.operations.Bool;
import ug.awolak.javaee.kolokwium2.domain.Lace;
import ug.awolak.javaee.kolokwium2.service.StorageService;

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

@WebServlet(urlPatterns = "/all-laces")
public class AllLacesServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");

        List<Lace> allLaces = ss.getAllLaces();

        out.append("<html><body><h2>All Laces:</h2>");

        for (Lace lace: allLaces) {
            if(lace.getQuantity() > 0){
                out.append("<form action='add-to-cart'>");
                out.append("<input type='hidden' name='id' value='" + lace.getId() + "'/>");
                out.append("<p>id: " + lace.getId() + "</p>");
                out.append("<p>Producer: " + lace.getProducer() + "</p>");
                out.append("<p>Production date: " + lace.getProductionDate() + "</p>");
                out.append("<p>Width: " + lace.getWidth() + "</p>");
                out.append("<p>Price: " + lace.getPrice() + "</p>");
                out.append("<p>Quantity: " + lace.getQuantity() + "</p>");
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
