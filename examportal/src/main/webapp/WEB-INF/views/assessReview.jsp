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
<link href="css/assessReview.css" rel="stylesheet">
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
	<a href="/welcome?useId=${userId}" style="margin: 30px 0 0 30px;"><img
		id="backArrow" style="width: 30px; height: 30px;"
		src="Img/backarrow.png" alt="Back"></a>

	<div class="mainContainer text-center">
		<div class="mainContainer text-center">

			<h1 class="heading">My Assessments</h1>
			<div class="searchResultContainer">

				<table class="table table-striped table-borderless shadow">
					<tbody>
						<tr>
							<th>Attempt Id</th>
							<th>Exam Code</th>
							<th>Score</th>
							<th>Attempt Date</th>
							<th>Give Feedback</th>
						</tr>
						<c:if test="${empty assessWrapper}">
						<tr><td colspan="5">No pending feedbacks to provide</td></tr>
						</c:if>
						<c:forEach var="assess" items="${assessWrapper}">
							<tr>
								<td>${assess.attemptId}</td>
								<td>${assess.examCode}</td>
								<td>${assess.score}</td>
								<td>${assess.attemptDate}</td>
								<td><a href="/giveFeedback?attemptId=${assess.attemptId}"
									class="btn btn-warning">Give Feedback</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>

			<div class="searchResultContainer">

				<table class="table table-striped table-borderless shadow">
					<tbody>
						<tr>
							<th>Attempt Id</th>
							<th>Exam Code</th>
							<th>Score</th>
							<th>Attempt Date</th>
							<th>Feedback Given</th>
						</tr>
						<c:forEach var="assess" items="${givenFeedbackList}">
							<tr>
								<td>${assess.attemptId}</td>
								<td>${assess.examCode}</td>
								<td>${assess.score}</td>
								<td>${assess.attemptDate}</td>
								<td colspan="4">${assess.feedback}</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</body>
</html>
