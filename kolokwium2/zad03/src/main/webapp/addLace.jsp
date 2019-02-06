<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Lace</title>
  </head>
  <body>
  <jsp:useBean id="lace" class="com.example.servletdemo.domain.Lace" scope="session" />

  <jsp:setProperty name="lace" property="name" param="name" />
  <jsp:setProperty name="lace" property="price" param="price" />


  <jsp:useBean id="storage" class="com.example.servletdemo.service.StorageService" scope="application" />

  <%
    String myCheckBoxValue = request.getParameter("isColorful");

    boolean isColorful;
    String state;
    if (myCheckBoxValue == null) {
      isColorful = false;
      state = "No";
    }
    else {
      isColorful = true;
      state = "Yes";
    }

    String myCheckBoxValue1 = request.getParameter("isPlain");

    boolean isPlain;
    String state1;
    if (myCheckBoxValue1 == null) {
      isPlain = false;
      state1 = "No";
    }
    else {
      isPlain = true;
      state1 = "Yes";
    }    

    String myCheckBoxValue2 = request.getParameter("isUsed");    
    
    boolean isUsed;
    String state2;
    if (myCheckBoxValue2 == null) {
      isUsed = false;
      state2 = "No";
    }
    else {
      isUsed = true;
      state2 = "Yes";
    }        
    
    DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
    Date date = format.parse(request.getParameter("productionDate"));
    lace.setProductionDate(date);
    lace.setColorful(isColorful);
    lace.setPlain(isPlain);
    lace.setUsed(isUsed);
    storage.add(lace);

  %>

    <h2>Lace added:</h2>

    <p>Name: ${lace.name} </p>
    <p>Is colorful:
      <%
        out.println(state);
      %>
    </p>
    <p>Is plain:
      <%
        out.println(state1);
      %>
    </p>
    <p>Is used:
      <%
        out.println(state2);
      %>
    </p>
    <p>Price: ${lace.price} </p>
    <p>Production Date:
    <%
      out.println(request.getParameter("productionDate"));
    %>
    </p>
    <p>
      <a href="index.jsp">Go back</a>
    </p>
  </body>
</html>