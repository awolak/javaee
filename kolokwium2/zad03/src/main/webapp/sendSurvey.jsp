<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Survey sent</title>
  </head>
  <body>
  <jsp:useBean id="survey" class="com.example.servletdemo.domain.Survey" scope="session" />

  <jsp:useBean id="surveyStorage" class="com.example.servletdemo.service.SurveyService" scope="application" />

  <jsp:setProperty name="survey" property="frequency" param="frequency" />

  <%
    List<String> selectedComments = new ArrayList<String>();
    for (String comment : request.getParameterValues("comments")) {
      selectedComments.add(comment);
    }
    survey.setComments(selectedComments);

    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date dateFrom = format.parse(request.getParameter("usedFrom"));
    Date dateTo = format.parse(request.getParameter("usedTo"));
    survey.setFrom(dateFrom);
    survey.setTo(dateTo);
    surveyStorage.add(session.getId(), survey);
  %>
  <h2>Survey sent</h2>

  <p>From:
      <%
      out.println(request.getParameter("usedFrom"));
    %>
  </p>

  <p>To:
    <%
      out.println(request.getParameter("usedTo"));
    %>
  </p>

  <p>Frequency: ${survey.frequency}</p>

  <p>Others: <br><%
    for(String comment: survey.getComments()) {
        out.print(comment + "<br>");
    }
  %></p>
  <p>
    <a href="index.jsp">Go back</a>
  </p>
  </body>
</html>