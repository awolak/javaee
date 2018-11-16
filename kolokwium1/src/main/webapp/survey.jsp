<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Survey</title>
</head>
<body>

<h1>Please take a minute to complete a survey about our Bed Store</h1>
<form action="new-survey">
  User Name :<input type="text" name="user_name" id="user_name" value="${survey.user_name}"><br>
  Date from :<input type="text" name="date_from" id="date_from" value="${survey.date_from}"><br>
  Date to :<input type="text" name="date_to" id="date_to" value="${survey.date_to}"><br>
  Frequency:<br><input type="radio" name="frequency" value="every 10 days">Every 10 days<br>
                <input type="radio" name="frequency" value="every 20 days">Every 10 days<br>
                <input type="radio" name="frequency" value="every 60 days">Every 60 days<br>
                <input type="radio" name="frequency" value="more than 60 days">More than 60 days<br>

   Your comments:<br><input type="checkbox" name="comments" value="comment1">Not satisfying<br>
                     <input type="checkbox" name="comments" value="comment2">Satisfying<br>
                     <input type="checkbox" name="comments" value="comment3">Very satisfying<br>
                     <input type="checkbox" name="comments" value="comment4">No opinion<br><br>

</form>

</body>
</html>