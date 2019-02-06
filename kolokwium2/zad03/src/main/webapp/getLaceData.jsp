<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add lace</title>
    </head>
    <body>
    <jsp:useBean id="storage" class="com.example.servletdemo.service.StorageService" scope="application" />
    <jsp:useBean id="lace" class="com.example.servletdemo.domain.Lace" scope="session" />

        <h2>Add lace</h2>
        <form action='addLace.jsp' method='POST'>   
        
            Name: <input type='text' name='name' required value="${lace.name}" /> <br>
            
            Is colorful: <input type='checkbox' name='isColorful'
            <%
                if(lace.isColorful()) {
                    out.println("checked");
                }
            %>/><br>
            Is plain: <input type='checkbox' name='isPlain'
            <%
                if(lace.isPlain()) {
                    out.println("checked");
                }
            %>/><br>      
            Is plain: <input type='checkbox' name='isUsed'
            <%
                if(lace.isUsed()) {
                    out.println("checked");
                }
            %>/><br>         
            Price: <input type='number' name='price' step='any' required value="${lace.price}" /><br>
            
            Production Date: <input type='date' name='productionDate' required
            <%
            	SimpleDateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
                out.println("value = '" + (lace.getProductionDate())+ "'");
            %> /><br>
            
            <input type='submit' value='Add'/>
        </form>
        <a href='index.jsp'>Go back</a>
    </body>
</html>
