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
<link href="css/searchexam.css" rel="stylesheet">
<link href="css/searchExamDetails.css" rel="stylesheet">
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
	<a href="adminhomepage"><img
		id="backArrow" src="Img/backarrow.png" alt="Back"></a>
	<div class="mainContainer text-center">

		<h1>Which exam are you looking for?</h1>

		<form:form action="/searchExamDetails" method="POST"
			modelAttribute="wrapper">
			<div class="searchBar shadow">
				<form:input path="searchWord" class="searchBox" id="searchbox"
					name="searchbox" placeholder="Search by key word or exam code"
					required="true" />
				<input type="submit" name="submit" id="submit"
					class="btn searchBtn center" value="Search Exam">
			</div>
			<div class="searchResultContainer">
				<c:if test="${not empty examsList}">
					<h5>Search Result:</h5>
					<table class="table table-striped table-borderless shadow">
						<tbody>
							<tr>
								<th>Exam Code</th>
								<th>Exam Name</th>
								<th>Subject</th>
								<th>Difficulty level</th>
								<th>Update</th>
								<th>Delete</th>
							</tr>
							<c:forEach var="exam" items="${examsList}">
								<tr>
									<td>${exam.examCode}</td>
									<td>${exam.examName}</td>
									<td>${exam.subject}</td>
									<td>${exam.competency}</td>
									<td><a class="btn btn-info"
										href="/updateExamDetails?examcode=${exam.examCode}">Update</a></td>
									<td><a class="btn btn-warning"
										href="/deleteExam?examcode=${exam.examCode}">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
		</form:form>
	</div>
</body>
</html>