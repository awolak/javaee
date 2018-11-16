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
<form action="sign-survey">
    <label for="user_name">User Name:</label>
    <input type="text" name="user_name" id="user_name" required="required" value="${sess_news.name}"><br>

    <label for="date_from">Date from:</label>
    <input type="text" name="date_from" id="date_from" required="required" value="${sess_news.from}"><br>

    <label for="date_to">Date to:</label>
    <input type="text" name="date_to" id="date_to" required="required" value="${sess_news.to}"><br>

    <br><label>Frequency:</label><br>
    <input type="radio" name="frequency" value="every 10 days">Every 10 days<br>
    <input type="radio" name="frequency" value="every 20 days">Every 10 days<br>
    <input type="radio" name="frequency" value="every 60 days">Every 60 days<br>
    <input type="radio" name="frequency" value="more than 60 days">More than 60 days<br>

    <br><label >Your comments:</label><br>
    <input type="checkbox" name="comments" value="comment1">Not satisfying<br>
    <input type="checkbox" name="comments" value="comment2">Satisfying<br>
    <input type="checkbox" name="comments" value="comment3">Very satisfying<br>
    <input type="checkbox" name="comments" value="comment4">No opinion<br><br>

    <input type="submit" value="Leave your opinion!">
</form>

</body>
</html>