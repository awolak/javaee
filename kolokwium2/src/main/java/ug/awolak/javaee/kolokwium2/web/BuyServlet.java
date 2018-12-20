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

        List<Lace> lacesInCart = ss.getCart();

        out.append("<html><body><h2>Thank you for purchase</h2>");

        for (Lace lace: lacesInCart) {
            removeLaceQuantity(lace);
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

    private void removeLaceQuantity(Lace boughtLace){
        StorageService appStorage = (StorageService) getServletContext().getAttribute("storage_service");
        List<Lace> allLaces = appStorage.getAllLaces();

        for(Lace lace: allLaces) {
            if(boughtLace == lace) {
                int quantity = lace.getQuantity();
                quantity--;
                lace.setQuantity(quantity);
            }
        }
    }
}
