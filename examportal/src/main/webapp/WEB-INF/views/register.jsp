<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exam Portal Registration</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="css/register.css" rel="stylesheet">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="javascript/register.js"></script>
</head>

<!------ Include the above in your HEAD tag ---------->

<body>
	<div id="login">
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">

						<form:form id="login-form" modelAttribute="user" class="form" action="/register" method="post">
							<h3 class="text-center text-info">Sign up</h3>
							
							<div class="form-group ">
								<label for="firstname" class="text-info">First Name:</label>
								<form:errors path="firstname" class="text-danger"></form:errors><br>
								<form:input type="text" path="firstname" name="firstname" id="firstname"
									class="form-control" required="true" />
							</div>
							<div class="form-group">
								<label for="lastname" class="text-info">Last Name:</label>
								<form:errors path="lastname" class="text-danger"></form:errors><br>
								<form:input type="text" path="lastname" name="lastname" id="lastname"
									class="form-control" required="required" />
							</div>
							<div class="form-group">
								<label for="dateOfBirth" class="text-info">Birth Date:</label>
								<form:errors path="dateOfBirth" class="text-danger"></form:errors><br>
								<form:input type="date" path="dateOfBirth" name="dateOfBirth" id="dateOfBirth"
									class="form-control" required="required" />
							</div>
							<div class="form-group">
								<label for="gender" class="text-info">Gender:</label>
								<form:errors path="gender" class="text-danger"></form:errors><br>
								<form:select type="text" path="gender" name="gender" id="gender"
									class="form-control" required="required">
									<option value="Male">Male</option>
									<option value="Female">Female</option>
								</form:select>
							</div>
							<div class="form-group">
								<label for="contactNo" class="text-info">Contact No:</label>
								<form:errors path="contactNo" class="text-danger"></form:errors><br>
								<form:input type="text" path="contactNo" name="contactNo" id="contactNo"
									class="form-control" required="required" pattern="[7-9][0-9]{9}"/>
							</div>
							<div class="form-group">
								<label for="email" class="text-info">Email Id:</label>
								<form:errors path="email" class="text-danger"></form:errors><br>
								<form:input type="email" path="email" name="email" id="email"
									class="form-control" required="required" />
							</div>
							<div class="form-group">
								<label for="username" class="text-info">Username:</label>
								<form:errors path="username" class="text-danger"></form:errors><br>
								<form:input type="text" path="username" name="username" id="username"
									class="form-control" required="required" />
							</div>
							<div class="form-group">
								<label for="password" class="text-info">Password:</label>
								<form:errors path="password" class="text-danger"></form:errors><br>
								<form:input type="text" path="password" name="password" id="password"
									class="form-control" required="required" />
							</div>
							
							<div class="form-group">
								<input type="submit" name="submit" id="submit"
									class="btn btn-success center" value="Register">
							</div>
							<div class="text-danger"><center>${registrationStatusMessage}</center></div>
						</form:form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>