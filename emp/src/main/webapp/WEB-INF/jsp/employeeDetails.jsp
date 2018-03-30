<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Employee details</title>
<style>
.button {
	background-color: #42a1f4; /* #4CAF50 -Green */
	border: none;
	color: white;
	padding: 10px 15px;
	text-align: center;
	text-decoration: none;
	/*display: inline-block;*/
	font-size: 16px;
	font-family: Arial;
}
</style>
</head>
<body>
	<form:form action="employee" method="post" modelAttribute="employee">
		
		<h1 style='color: blue'>Employee Details:</h1>

		<form:hidden path="id" />

		
				<h3>
					First Name:<form:input path="firstname"/><br>
				</h3>
				<h3>
					Last Name:<form:input path="lastname"/> <br>
				</h3>

				<h3>
					Data of birth:<form:input path="dob"/></br>
				</h3>
				<h3>
					
					SSN:<form:input path="ssn" /></br>
				</h3>
				
				<h2>Address</h2>
				<h3>
					Line 1:<form:input path="address.addrLn1"/><br>
				</h3>
				<h3>
					Line 2:<form:input path="address.addrLn2"/> <br>
				</h3>

				<h3>
					city:<form:input path="address.city"/></br>
				</h3>
				<h3>
					
					state:<form:input path="address.state" /></br>
				</h3>
				<h3>
					
					zip:<form:input path="address.zip" /></br>
				</h3>

				<input type="submit" value="Save" class='button' />
				
				<input type="reset" value="clear" class='button' /> 
				<a href="../employees" class="button">back</a>

	</form:form>	

</body>
</html>