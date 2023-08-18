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
<title>Generate Report</title>
<link href="css/generateReport.css" rel="stylesheet">
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
	<a href="/welcome?userId=${userId}" style="margin: 30px 0 0 30px;"><img
		id="backArrow" style="width: 30px; height: 30px;"
		src="Img/backarrow.png" alt="Back"></a>

	<div class="mainContainer text-center">
		<div class="mainContainer text-center">

			<h1 class="heading">Completed Assessments</h1>
			<div class="searchResultContainer">

				<table class="table table-striped table-borderless shadow">
					<tbody>
						<tr>
							<th>Attempt Id</th>
							<th>Exam Name</th>
							<th>Exam Code</th>
							<th>Score</th>
							<th>Attempt Date</th>
							<th>Get Your Certificate</th>
						</tr>
						<c:forEach var="assess" items="${assessWrapper}">
							<tr>
								<td>${assess.attemptId}</td>
								<td>${assess.examName}</td>
								<td>${assess.examCode}</td>
								<td>${assess.score}</td>
								<td>${assess.attemptDate}</td>
								<td><a class="btn btn-warning"
									href="certificate?userId=${userId}&attemptId=${assess.attemptId}"
									target="_blank">Download Certificate</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</body>
</html>
