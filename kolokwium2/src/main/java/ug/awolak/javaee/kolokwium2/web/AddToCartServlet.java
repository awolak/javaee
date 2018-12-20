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

@WebServlet(urlPatterns = "/add-to-cart")
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();

        StorageService ss = null;

        if (session.getAttribute("session_cart") == null) {
            ss = new StorageService();
        } else {
            ss = (StorageService) session.getAttribute("session_cart");
        }

        int id = Integer.parseInt(request.getParameter("id"));

        ss.addToCart(getLace(id));

        session.setAttribute("session_cart", ss);

        List<Lace> lacesInCart = ss.getCart();

        out.append("<html><body><h2>All Laces in cart:</h2>");

        for (Lace lace: lacesInCart) {
            out.append("<p>id: " + lace.getId() + "</p>");
            out.append("<p>Producer: " + lace.getProducer() + "</p>");
            out.append("<p>Production date: " + lace.getProductionDate() + "</p>");
            out.append("<p>Width: " + lace.getWidth() + "</p>");
            out.append("<p>Price: " + lace.getPrice() + "</p>");
        }

        out.append("<a href='all-laces'>Go back to shop</a><br>");
        out.append("<a href='cart'>Go to checkout</a>");
        out.append("</body></html>");
        out.close();

    }

    @Override
    public void init() throws ServletException {

        getServletContext().setAttribute("storage_service", new StorageService());
    }

    private Lace getLace(int id){
        StorageService appStorage = (StorageService) getServletContext().getAttribute("storage_service");
        List<Lace> allLaces = appStorage.getAllLaces();
        Lace laceToCart = null;

        for(Lace lace: allLaces) {
            if(lace.getId() == id) {
                laceToCart = lace;
            }
        }

        return laceToCart;
    }
}
