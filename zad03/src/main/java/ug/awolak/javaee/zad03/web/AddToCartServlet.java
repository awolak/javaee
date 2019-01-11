package ug.awolak.javaee.zad03.web;

import ug.awolak.javaee.zad03.domain.Bed;
import ug.awolak.javaee.zad03.service.StorageService;

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

        ss.addToCart(getBed(id));

        session.setAttribute("session_cart", ss);

        List<Bed> bedsInCart = ss.getCart();

        out.append("<html><body><h2>All Beds in cart:</h2>");

        for (Bed bed: bedsInCart) {
            out.append("<p>id: " + bed.getId() + "</p>");
            out.append("<p>Producer: " + bed.getProducer() + "</p>");
            out.append("<p>Production date: " + bed.getProductionDate() + "</p>");
            out.append("<p>Width: " + bed.getWidth() + "</p>");
            out.append("<p>Price: " + bed.getPrice() + "</p>");
            out.append("<p>Is soft: " + bed.getIsSoft() + "</p><br>");
        }

        out.append("<a href='all-beds'>Go back to shop</a><br>");
        out.append("<a href='cart'>Go to checkout</a>");
        out.append("</body></html>");
        out.close();

    }

    @Override
    public void init() throws ServletException {

        getServletContext().setAttribute("storage_service", new StorageService());
    }

    private Bed getBed(int id){
        StorageService appStorage = (StorageService) getServletContext().getAttribute("storage_service");
        List<Bed> allBeds = appStorage.getAllBeds();
        Bed bedToCart = null;

        for(Bed bed: allBeds) {
            if(bed.getId() == id) {
                bedToCart = bed;
            }
        }

        return bedToCart;
    }
}
