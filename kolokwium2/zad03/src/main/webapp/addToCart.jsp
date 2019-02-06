<%@ page import="com.example.servletdemo.domain.Lace" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
</head>
<body>

    <jsp:useBean id="storage" class="com.example.servletdemo.service.StorageService" scope="application" />
    <jsp:useBean id="cart" class="com.example.servletdemo.service.StorageService" scope="session" />

    <%
        Map<Long, Lace> laces = storage.getAllLaces();
        Lace lace = laces.get(Long.valueOf(request.getParameter("id")));
        cart.add(lace);
    %>

    <h2>Add to cart</h2>
    <p>
        <a href="summary.jsp">Summary</a><br>
        <a href="buyLace.jsp">Buy another lace</a>
    </p>

</body>
</html>