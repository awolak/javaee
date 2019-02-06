<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
    <jsp:useBean id="rodo" class="com.example.servletdemo.domain.Rodo" scope="application"/>
</head>
<%
if(request.getParameter("rodo")!=null && request.getParameter("rodo2")!=null)
{
	rodo.setRodo(true);
	rodo.setRodo2(true);
}
if(request.getParameter("newsletter")!=null)
{
	rodo.setNewsletter(true);
}
if(!rodo.isRodo() && !rodo.isRodo2())
{
	response.sendRedirect("rodo.jsp");
}
%>
    
    
    <body>
        <h2>Welcome in lace shop!</h2>
        <ul>
            <li>
                <a href='getLaceData.jsp'>Add Lace</a>
            </li>
            <li>
                <a href='buyLace.jsp'>Buy Lace</a>
            </li>
            <li>
                <a href='summary.jsp'>Summary</a>
            </li>
            <li>
                <a href='survey.jsp'>Fill survey</a>
            </li>                      
        </ul>
    </body>
</html>
