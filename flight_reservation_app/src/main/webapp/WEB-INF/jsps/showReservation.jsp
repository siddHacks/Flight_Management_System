<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
	<h1>Flights Details</h1>
	Flight Number: ${flight.flightNumber}<br>
	Operating Airline: ${flight.operatingAirlines}<br>
	Departure City: ${flight.departureCity}<br>
	Arrival City: ${flight.arrivalCity}<br>
	Departure Date: ${flight.dateOfDeparture}
	
	<h1>Enter Passenger Details</h1>
	<form action="confirmReservation" method="post">
		<pre>
		first name<input type="text" name="firstName">
		last name<input type="text" name="lastName">
		middle name<input type="text" name="middleName">
		email<input type="text" name="email">
		phone<input type="text" name="phone">
		<input type="hidden" name="flightId" value="${flight.id}" >
		<h2>Enter Payment Details</h2>
		Name On The Card<input type="text" name="cardName">
		Card Number<input type="text" name="cardNumber">
		Cvv<input type="text" name="cvv">
		Expiry Date<input type="text" name="expiryDate">
		<input type="submit" value="complete reservation">
		</pre>
	</form>	

</body>
</html>