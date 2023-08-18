<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Exam</title>
<link href="css/takeexam.css" rel="stylesheet">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="javascript/takeexam.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body onload="javascript:startTimer()">
	<div class="mainContainer text-center">

		<table class="headingTable text-center">
			<tr>
				<td style="width: 33%"></td>
				<td style="width: 33%"><h1>${examCode}-EXAM</h1>
					<h5>Total Questions: ${questionsList.size()}</h5></td>
				<td style="width: 33%;"><div class="timer h1 float-right"
						id="timer">10:00</div></td>
			</tr>
		</table>



		<form:form action="/showresult" modelAttribute="wrapper" method="POST" id="form1">
			<div class="questionsBox">

				<c:forEach var="que" varStatus="q" items="${questionsList}">
					<div class="Q">
						<table class="table Qtable text-left table-borderless">
							<tr>
								<th colspan="2">Q${q.index+1}) ${que.question}</th>
							</tr>
							<tr>
								<td><form:radiobutton
										path="examAttemptQuestions[${q.index}].response" value="A"
										class="rbtn" /> A. ${que.optionA}</td>
								<td><form:radiobutton
										path="examAttemptQuestions[${q.index}].response" value="B"
										class="rbtn" /> B. ${que.optionB}</td>
							</tr>
							<tr>
								<td><form:radiobutton
										path="examAttemptQuestions[${q.index}].response" value="C"
										class="rbtn" /> C. ${que.optionC}</td>
								<td><form:radiobutton
										path="examAttemptQuestions[${q.index}].response" value="D"
										class="rbtn" /> D. ${que.optionD}</td>
							</tr>


							<form:input type="hidden"
								path="examAttemptQuestions[${q.index}].examCode"
								value="${examCode}" />
							<form:input type="hidden"
								path="examAttemptQuestions[${q.index}].userId" value="${userId}" />
							<form:input type="hidden"
								path="examAttemptQuestions[${q.index}].questionId"
								value="${que.questionId}" />
							<form:input type="hidden"
								path="examAttemptQuestions[${q.index}].answer"
								value="${que.answer}" />
							<form:input type="hidden"
								path="examAttemptQuestions[${q.index}].marks"
								value="${que.marks}" />

						</table>
					</div>
					<br>
				</c:forEach>
			</div>
			<input class="btn" id="submit" type="submit" value="Submit Test" />
		</form:form>
	</div>
</body>
</html>