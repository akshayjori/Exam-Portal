
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
<link href="css/navbar.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>Update Questions Page</title>
</head>
<body>
	<a href="/searchQues?subject=${ques1.subject}"><img id="backArrow"
		src="Img/backarrow.png" alt="Back"></a>
	<div id="mainContainer">
		<center>
			<h1 class="text-light center">Update Question Details</h1>
		</center>
		<br>
		<div class="row justify-content-center align-items-center text-info">
			<form:form class="form" method="Post" modelAttribute="ques"
				action="/updateQues?questionId=${ques1.questionId}">
				<table>
					<tr>
						<td><label for="question">Question:</label></td>

						<td><form:input type="text" path="question" name="question"
								id="question" required="true" value="${ques1.question}" /></td>
					</tr>
					<tr>
						<td><label for="optionA">Option A:</label></td>
						<td><form:input type="text" path="optionA" name="optionA"
								id="optionA" required="true" value="${ques1.optionA}" /></td>
					</tr>
					<tr>
						<td><label for="optionB">Option B:</label></td>
						<td><form:input type="text" path="optionB" name="optionB"
								id="optionB" required="true" value="${ques1.optionB}" /></td>
					</tr>
					<tr>
						<td><label for="optionC">Option C:</label></td>
						<td><form:input type="text" path="optionC" name="optionC"
								id="optionC" required="true" value="${ques1.optionC}" /></td>
					</tr>
					<tr>
						<td><label for="optionD">Option D:</label></td>
						<td><form:input type="text" path="optionD" name="optionD"
								id="optionD" required="true" value="${ques1.optionD}" /></td>
					</tr>
					<tr>
						<td><label for="answer">Answer:</label></td>
						<td><form:select path="answer">
								<form:option value="${ques1.answer}" label="${ques1.answer}"
									selected="true" />
								<form:option value="A" label="A" />
								<form:option value="B" label="B" />
								<form:option value="C" label="C" />
								<form:option value="D" label="D" />
							</form:select></td>
					</tr>
					<tr>
						<td><label for="competency">Difficulty:</label></td>
						<td><form:select path="competency">
								<form:option value="${ques1.competency}"
									label="${ques1.competency}" selected="true" />
								<form:option value="LOW" label="Low" />
								<form:option value="MEDIUM" label="Medium" />
								<form:option value="HIGH" label="High" />
							</form:select></td>
					</tr>
					<tr>
						<td><label for="marks">Marks:</label></td>
						<td><form:input path="marks" type="number" name="marks"
								id="marks" required="true" max="3" min="1"
								value="${ques1.marks}" /></td>
					</tr>
					<tr>
						<td><label for="subject">Subjects:</label></td>
						<td><form:select path="subject" id="subject" name="subject"
								items="${subjectList}">
							</form:select></td>
					</tr>
					
					<form:input path="questionId" type="hidden"
						value="${ques1.questionId}" />

				</table>
				<div class="text-center">
					<button class="btn btn-dark" id="submit" type="submit">Update</button>
				</div>
				<div class="text-success" style="margin-top: 10px">
					<center>${status}</center>
				</div>
			</form:form>
		</div>

	</div>

</body>
</html>