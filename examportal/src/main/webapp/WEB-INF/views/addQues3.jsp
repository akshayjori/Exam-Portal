
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="css/common.css" rel="stylesheet">
<link href="css/addQues.css" rel="stylesheet">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>Add Questions Page</title>
</head>
<body>
	<div class="topnav">
		<a class="active " href="#home"><i class="fas fa-home"></i> Exam
			Portal</a> <a href="#about">About</a>
		<div class="float-right">
			<a href="#contact">Contact</a> <a href="#logout">Logout</a>
		</div>
	</div>
	<a href="/adminhomepage"><img id="backArrow"
		src="Img/backarrow.png" alt="Back"></a>
	<div id="mainContainer">
		<center>
			<h1 class="text-light center">Add Question Details</h1>
		</center>
		<br>
		<div class="row justify-content-center align-items-center text-info">
			<form:form class="form" action="/addQues" method="post"
				modelAttribute="question">
				<table>
					<tr>
						<td><label for="question">Question:</label></td>

						<td colspan="3"><form:input type="text" path="question"
								name="question" id="question" required="true"
								placeholder="What is your question?" /></td>
					</tr>
					<tr>
						<td><form:input type="text" path="optionA" name="optionA"
								id="optionA" required="true" placeholder="Option A" /></td>
						<td><form:input type="text" path="optionB" name="optionB"
								id="optionB" required="true" placeholder="Option B" /></td>
						<td><form:input type="text" path="optionC" name="optionC"
								id="optionC" required="true" placeholder="Option C" /></td>
						<td><form:input type="text" path="optionD" name="optionD"
								id="optionD" required="true" placeholder="Option D" /></td>
					</tr>

					<tr>
						<td><label for="answer">Answer:</label></td>
						<td><form:select path="answer">
								<form:option value="A" label="A" />
								<form:option value="B" label="B" />
								<form:option value="C" label="C" />
								<form:option value="D" label="D" />
							</form:select></td>
						<td><label for="competency">Difficulty level:</label></td>
						<td><form:select path="competency">
								<form:option value="LOW" label="Low" />
								<form:option value="MEDIUM" label="Medium" />
								<form:option value="HIGH" label="High" />
							</form:select></td>
					</tr>
					<tr>
						<td><label for="marks">Marks:</label></td>
						<td><form:input type="number" path="marks" name="marks"
								id="marks" required="true" max="3" min="1" value="1" /></td>
						<td><label for="subject">Subjects:</label></td>
						<td><form:select path="subject" id="subject" name="subject"
								items="${subjectList}" /></td>
					</tr>

				</table>
				<div class="text-center">
					<button class="btn btn-dark" id="submit" type="submit">Add
						Exam Details</button>
				</div>
				<div class="text-success" style="margin-top: 10px">
					<center>${status}</center>
				</div>
			</form:form>
		</div>

	</div>

</body>
</html>