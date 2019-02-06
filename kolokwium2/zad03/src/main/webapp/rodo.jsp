<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Warunki korzystania z serwisu</title>
</head>
	<body>
	<form action="index.jsp" method="post">
		Zgoda na przetwarzanie danych osobowych <input type="checkbox" name="rodo" required/></br>
		Zgoda na przestrzeganie regulaminu <input type="checkbox" name="rodo2" required/></br>
		Czy chcesz zapisac sie na newsletter? <input type="checkbox" name="newsletter"/></br>
	<input type='submit' value='Accept'/>
	</body>
</html>