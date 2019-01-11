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

@WebServlet(urlPatterns = "/buy")
public class BuyServlet extends HttpServlet {
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

        List<Bed> bedsInCart = ss.getCart();

        out.append("<html><body><h2>Thank you for your purchase</h2>");

        for (Bed bed: bedsInCart) {
            removeBedQuantity(bed);
        }

        session.removeAttribute("session_cart");

        out.append("<a href='zad03'>Go back to menu</a><br>");
        out.append("</body></html>");
        out.close();

    }

    @Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("storage_service", new StorageService());
    }

    private void removeBedQuantity(Bed boughtBed){
        StorageService appStorage = (StorageService) getServletContext().getAttribute("storage_service");
        List<Bed> allBeds = appStorage.getAllBeds();

        for(Bed bed: allBeds) {
            if(boughtBed == bed) {
                int quantity = bed.getQuantity();
                quantity--;
                bed.setQuantity(quantity);
            }
        }
    }
}
