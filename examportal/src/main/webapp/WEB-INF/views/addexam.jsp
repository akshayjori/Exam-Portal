<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Add Exam Details</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="css/common.css" rel="stylesheet">
<link href="css/addexam.css" rel="stylesheet">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

<body>

	<a href="/adminhomepage"><img id="backArrow"
		src="Img/backarrow.png" alt="Back"></a>
	<div id="mainContainer">
		<center>
			<h1 class="text-light center">Add Exam Details</h1>
		</center>
		<br>
		<div class="row justify-content-center align-items-center text-info">
			<form:form class="form" action="/addexam" method="post"
				modelAttribute="exam">
				<table>
					<tr>
						<td><label for="examName">Exam Name:</label></td>

						<td><form:input type="text" path="examName" name="examName"
								id="examName" required="true" /></td>
					</tr>
					<tr>
						<td><label for="examCode">Exam Code:</label></td>
						<td><form:input type="text" path="examCode" name="examCode"
								id="examCode" pattern="[A-Za-z0-9]*" required="true" /></td>
					</tr>
					<tr>
						<td><label for="subject">Subject:</label></td>
						<td><form:select path="subject" id="subject" name="subject"
								items="${subjectList}" /></td>
					</tr>
					<tr>
						<td><label for="competency">Difficulty level:</label></td>
						<td><form:select path="competency">
								<form:option value="LOW" label="Low" />
								<form:option value="MEDIUM" label="Medium" />
								<form:option value="HIGH" label="High" />
							</form:select></td>
					</tr>

				</table>
				<div class="text-center">
					<button class="btn btn-dark" id="submit" type="submit">Add
						Exam Details</button>
				</div>
				<div class="text-danger" style="margin-top: 10px">
					<center>${status}</center>
				</div>
			</form:form>
		</div>

	</div>
</body>

</html>