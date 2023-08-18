<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>AssesmentReport Home Page</title>
<link href="css/common.css" rel="stylesheet">
<link href="css/userticket.css" rel="stylesheet">
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
	<a href="/adminhomepage" style="margin: 30px 0 0 30px;"><img
		id="backArrow" style="width: 30px; height: 30px;"
		src="Img/backarrow.png" alt="Back"></a>
	<h1 class="heading">Pending Help Requests</h1>
	<div id="table-content">
		<form:form action="showHelpRequest" method="post"
			modelAttribute="ticket">
			<table class="content-table">
				<thead>
					<tr>
						<th>User ID</th>
						<th>Ticket ID</th>
						<th>Date Of Ticket</th>
						<th>Issue Related To</th>
						<th>Description</th>
						<th>Status</th>
						<th>Admin Responce</th>
						<th>Solve Issue</th>
					</tr>
				</thead>
				<tbody class="tabledata">
					<c:forEach items="${showallticket}" var="ticket">
						<tr>
							<td>${ticket.userId}</td>
							<td>${ticket.ticketId}</td>
							<td>${ticket.ticketDate}</td>
							<td>${ticket.typeofissue}</td>
							<td>${ticket.description}</td>
							<td>${ticket.status}</td>
							<td>${ticket.adminResponce}</td>
							<td><a href="/solveTicket?ticketId=${ticket.ticketId}"
								class="btn button shadow"> <span>Resolve Ticket</span>
							</a></td>
						</tr>
					</c:forEach>
			</table>
		</form:form>
	</div>
</body>

</html>