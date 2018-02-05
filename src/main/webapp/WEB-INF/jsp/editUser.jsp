<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
<title>NAI</title>
</head>
<body>
	<h2>Edit person</h2>
	<div style="width: 50%">
		<form action="/user/update/${user.id}" object="${user}" method="post">
			<div>
				<label> Username : </label> <input type="text" name="name"
					value="${user.name}" />
			</div>
			<div>
				<label> Mail : </label> <input type="text" name="mail"
					value="${user.mail}" />
			</div>
			<div>
				<input type="submit" value="Edit" />
			</div>
		</form>

		<form action="/user/address/${user.id}" object="${address}" method="post">
			<div>
				<label> postalCode : </label> <input type="text" name="postalCode" />
			</div>
			<div>
				<label> city : </label> <input type="text" name="city" />
			</div>
			<div>
				<label> street : </label> <input type="text" name="street" />
			</div>
			<div>
				<label> houseNo : </label> <input type="text" name="houseNo" />
			</div>
			<div>
				<input type="submit" value="Add address" />
			</div>
		</form>
	</div>
</body>
</html>