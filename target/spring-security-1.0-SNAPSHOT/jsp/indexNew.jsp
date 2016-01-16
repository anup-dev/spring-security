<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/style2.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="header">
		<h3 style="float:left;">Whats your Bet</h3>
		<form action="/loginUser" method="post">
		<table align="right">
				<tr>
					<td>Email</td>
					<td>Password</td>
				</tr>
				<tr>
					<td><input type="text" id="username" name="username"></td>
					<td><input type="password" id="password" name="password"></td>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<td><button id="submitForm" type="submit">Log In</button></td>
				</tr>
		</table>
		</form>
	</div>
	<div id="container">
		<div id="registration">

					<table  align="center" cellpadding="20" cellspacing="10">
						<tr>
							<td>Name</td>
                            <td><input type="text"></td>
						</tr>
						<tr>
							<td>Email</td>
                            <td><input type="text"></td>
						</tr>
						<tr>
							<td>Password</td>
                            <td><input type="password"></td>
						</tr>
						<tr>
							<td>Phone</td>
                            <td><input type="text"></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="submit" value="register" /></td>
						</tr>
					</table>

		</div>
	</div>

	<div id="footer">
		<p>copyrite &copy 2016<p>
	</div>

</body>
</html>