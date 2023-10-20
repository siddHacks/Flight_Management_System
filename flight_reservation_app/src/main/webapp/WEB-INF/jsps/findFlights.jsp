<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Flights</title>
</head>
<body>
	<h1>Find Flights</h1>
	<form action="findFlights" method="post">
		from<input type="text" name="from"/>
		to<input type="text" name="to"/>
		departure date<input type="text" name="departureDate"/>
		<input type="submit" value="Search"/>
	</form>

</body>
</html>