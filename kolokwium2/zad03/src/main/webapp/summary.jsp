<%@ page import="java.util.Iterator" %>
<%@ page import="com.example.servletdemo.domain.Lace" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>All laces</title>
</head>
<body>
<jsp:useBean id="cart" class="com.example.servletdemo.service.StorageService" scope="session" />
    <h2>Cart:</h2>
    <table style='border-collapse: collapse;'>
        <%
        double total = 0;
        Map<Long, Lace> laces = cart.getAllLaces();
        if(laces.size() > 0) {
            Iterator it = laces.values().iterator();
            Lace s;
            while (it.hasNext()) {
                s = (Lace) it.next();
                total += s.getPrice();
                out.println("<tr style='border: 1px solid black'>" +
                        "<td>" + s.showDetails() + "</td>");
                out.println("<td>");
                out.println("</tr>");
            }
        } else {
            out.println("<h2>Cart is empty</h2>");
        }
        %>
    </table>
    <a href='index.jsp'>Go back</a>
</body>
</html>