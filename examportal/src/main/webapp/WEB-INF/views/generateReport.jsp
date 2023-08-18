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

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.17.0/xlsx.full.min.js"></script>
<script src="javascript/report.js"></script>
</head>
<body>
	<a href="/adminhomepage" style="margin: 30px 0 0 30px;"><img
		id="backArrow" style="width: 30px; height: 30px;"
		src="Img/backarrow.png" alt="Back"></a>

	<div class="mainContainer text-center">
		<div class="mainContainer text-center">

			<h1 class="heading">Assessment Report</h1>
			<div class="searchResultContainer">
				<form:form method="post" modelAttribute="wrapper"
					action="/generateReport">
					<table class="table htable">
						<thead>
							<tr>
								<th>Select ExamCode: <form:select path="examCode"
										items="${examCodesList}" value="none" /></th>
								<th>Select start date: <form:input path="startDate"
										id="startDate" type="date" value="01/01/2000" required="true" /></th>
								<th>Select end date: <form:input path="endDate" type="date"
										id="endDate" required="true" /></th>
								<th><input type="submit" class="btn btn-warning"
									value="Generate Report"></th>
							</tr>
						</thead>
					</table>
					<table class="table table-striped table-borderless shadow"
						id="table">
						<tbody>
							<tr>
								<th>Examcode</th>
								<th>Count of users</th>
								<th>No.of Pass</th>
								<th>No.of Fail</th>
								<th>Highest Score</th>
							</tr>
							<c:forEach var="r" items="${wr}">
								<tr>
									<td>${r.examCode}</td>
									<td>${r.userCount}</td>
									<td>${r.noOfPass}</td>
									<td>${r.noOfFail}</td>
									<td>${r.highestScore}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<div>
						<button id="export" class="btn btn-primary" onclick="generate()">Export
							to Excel</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
