<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Create New Account</h1>
	<form action="saveReg" method="post">
		<pre>
		first name<input type="text" name="firstName"/>
		last name<input type="text" name="lastName"/>
		email<input type="text" name="email"/>
		password<input type="password" name="password"/>
		<input type="submit" value="save"/>
		</pre>
	</form>
</body>
</html>