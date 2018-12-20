package ug.awolak.javaee.kolokwium2.web;

import ug.awolak.javaee.kolokwium2.domain.Lace;
import ug.awolak.javaee.kolokwium2.service.StorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //session context
        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();

        StorageService ss = null;

        if (session.getAttribute("session_cart") == null) {
            ss = new StorageService();
        } else {
            ss = (StorageService) session.getAttribute("session_cart");
        }

        List<Lace> lacesInCart = ss.getCart();

        out.append("<html><body><h2>All Laces in cart:</h2>");

        int total = 0;

        for (Lace lace: lacesInCart) {
            out.append("<p>id: " + lace.getId() + "</p>");
            out.append("<p>Producer: " + lace.getProducer() + "</p>");
            out.append("<p>Production date: " + lace.getProductionDate() + "</p>");
            out.append("<p>Width: " + lace.getWidth() + "</p>");
            out.append("<p>Price: " + lace.getPrice() + "</p>");

            total += lace.getPrice();
        }

        out.append("Total: $" + total);
        out.append("<br><a href='all-laces'>Go back to shop</a><br>");
        out.append("<a href='buy'>Buy</a><br>");
        out.append("</body></html>");
        out.close();

    }
}
