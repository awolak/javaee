<%@ page import="com.example.servletdemo.domain.Survey" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Surveys</title>
</head>
<body>
<jsp:useBean id="surveyStorage" class="com.example.servletdemo.service.SurveyService" scope="application" />

    <%
        for(String key: surveyStorage.getAllSurveys().keySet()) {
            Survey survey = surveyStorage.getAllSurveys().get(key);
            out.print("<input type='checkbox' name='key' value='"+ key + "'><br>");
            out.println(survey);
            out.print("<hr>");
        }
    %>


<p>
    <a href="index.jsp">Go back</a>
</p>
</body>
</html>