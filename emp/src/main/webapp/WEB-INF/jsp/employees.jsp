<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>view all Employees</title>
<style>
a {
	text-decoration: none;
}

h1 {
	font-size: 40px;
	color: Green;
	text-align: center;
	background-color: yellow;
}

.button {
	background-color: #42a1f4; /* #4CAF50 -Green */
	border: none;
	color: white;
	padding: 14px 20px;
	text-align: center;
	text-decoration: none;
	/*display: inline-block;*/
	font-size: 16px;
	font-family: Arial;
	border-bottom-left-radius: 1ex;
	border-bottom-right-radius: 1ex;
	border-top-left-radius: 1ex;
	border-top-right-radius: 1ex;
	border: 1px navy solid;
}
</style>
</head>
<body>

<h1>Employees</h1>

<div>

		
	</div>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Emp Id</th>
					<th>First name</th>
					<th>Last name</th>
					<th>DOB</th>
					<th>ssn</th>
					<th>Address</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${employeeList}" var="employee">
					<tr>
						<td><c:out value="${employee.id}"/></td>
						<td><c:out value="${employee.firstname}"/></td>
						<td><c:out value="${employee.lastname}"/></td>
						<td><c:out value="${employee.dob}"/></td>
						<td><c:out value="${employee.ssn}"/></td>
						<td><c:out value="${employee.address.addrLn1}"/>,
							<c:out value="${employee.address.addrLn2}"/> <br>
							<c:out value="${employee.address.city}"/>, 
							<c:out value="${employee.address.state}"/> -
							<c:out value="${employee.address.zip}"/></td>
						<td><a class="btn btn-warning" href="employee/${employee.id}">Update</a></td>
						<td><a class="btn btn-warning" href="employee/delete/${employee.id}">Delete</a></td>
				</tr>
			</c:forEach>

						
					
			</tbody>
		</table>
	</div>
	
	<div>
	<a href="employee" class="button">Add new employee</a>
	</div>

</body>
</html>
