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
	<table border="0">
		<c:forEach items="${users}" var="person">
			<tr>
				<td style="padding: 5px">${person.id}</td>
				<td style="padding: 5px">${person.name}</td>
				<td>
					<table border="0">
						<c:forEach items="${person.addresses}" var="address">
							<tr th:each="address : ${person.addresses}">
								<td style="padding: 5px">${address.postalCode}</td>
								<td style="padding: 5px">${address.city}</td>
								<td style="padding: 5px">${address.street}</td>
								<td style="padding: 5px">${address.houseNo}</td>
							</tr>
						</c:forEach>
					</table>
				</td>
				<td>
					<form action="/user/update/${person.id}" method="get">
						<button>Edit</button>
					</form>
					<form action="/user/delete?id=${person.id}" method="post">
						<button>Remove</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

	<h2>Create person</h2>
	<form action="/user/createPost" object="${user}" method="post">
		<div>
			<label> Username : <input type="text" name="name" />
			</label>
		</div>
		<div>
			<label> mail : <input type="text" name="mail" />
			</label>
		</div>
		<div>
			<label> password : <input type="text" name="password" />
			</label>
		</div>
		<div>
			<input type="submit" value="Create" />
		</div>
	</form>
</body>
</html>