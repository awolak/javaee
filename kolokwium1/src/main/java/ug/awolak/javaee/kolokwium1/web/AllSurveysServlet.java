package ug.awolak.javaee.kolokwium1.web;

import ug.awolak.javaee.kolokwium1.domain.Survey;
import ug.awolak.javaee.kolokwium1.service.SurveyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/newsletters")
public class AllSurveysServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        SurveyService ns = (SurveyService)getServletContext().getAttribute("app_news");

        List<Survey> allSurveys = ns.getAllSurveys();

        out.append("<html><body><h2>Wszystkie newslettery:</h2>");
        out.append("<p>Tutaj zapisane są wszystkie dodane newslettery, ale w sesji jest tylko jeden</p><br>");

        for (Survey survey: allSurveys) {
                out.append("<input type='hidden' user_name='user_name' value='" + survey.getUser_name() + "'/>");
                out.append("<p>User name: " + survey.getUser_name() + "</p>");
                out.append("<p>Date from: " + survey.getDate_from() + "</p>");
                out.append("<p>Date to: " + survey.getDate_to() + "</p>");
                out.append("<p>Frequency: " + survey.getFrequency() + "</p>");
                out.append("<p>Comments: " + survey.getComments() + "</p>");
                out.append("</form>");
        }

        out.append("</body></html>");
        out.close();

    }

    @Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("app_news", new SurveyService());
    }
}