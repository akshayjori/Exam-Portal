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
<link href="css/searchQues.css" rel="stylesheet">
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
</head>
<body>
	<a href="/adminhomepage"><img id="backArrow"
		src="Img/backarrow.png" alt="Back"></a>
	<div class="mainContainer row">
		<div class="searchBar shadow text-light">
			Select Subject: <select id="subject" name="subject">
				<c:forEach var="subject" items="${subjectList}">
					<option>${subject}</option>
				</c:forEach>
			</select> <a href="javascript:;" class="btn searchbtn btn-primary"
				onclick="this.href='searchQues?subject=' + document.getElementById('subject').value">See
				Questions</a>
			<h5 class="float-right">${status}</h5>
		</div>

		<c:if test="${not empty quesList}"></c:if>
		<!-- if else in jsp -->

		<div class="questionTable table table-striped shadow">
			<h5 class="text-center text-light">Search Results:</h5>
			<table>
				<tr></tr>
				<tr class="text-center text-dark">
					<th>Subject</th>
					<th>Question</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>

				<c:forEach var="q" items="${quesList}">
					<tr>
						<td>${q.subject}</td>
						<td>${q.question}</td>

						<td><a class="btn btn-info"
							href="/updateQues?questionId=${q.questionId}">Update</a></td>
						<td><a class="btn btn-warning"
							href="/deleteQues?questionId=${q.questionId}">Delete</a></td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>
</body>
</html>