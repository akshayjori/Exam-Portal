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
<link href="css/userHelp.css" rel="stylesheet">
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
	<a href="/welcome?userId=${userId}"><img id="backArrow"
		style="width: 30px; height: 30px;" src="Img/backarrow.png" alt="Back"></a>
	<h1 class="heading">Raise Ticket</h1>

	<form:form action="userIssue?userId=${userId}" method="post"
		modelAttribute="ticket" class="table1">
		<table align="center" class="tabledata">
			<tr>
				<th>Select Issue Related To:</th>
			</tr>
			<tr>
				<td><form:select path="typeofissue" class="selectIssue">
						<form:option value="Internet Connectivity"
							label="Internet Connectivity" />
						<form:option value="The Platform" label="The Platform" />
						<form:option value="Assesment" label="Assesment" />
						<form:option value="Report Generation" label="Report Generation" />
						<form:option value="Other" label="Other" />
					</form:select></td>
			</tr>
			<tr>
			<tr>
				<th>Describe Your Issue:</th>
			</tr>
			<tr>
				<td><form:textarea path="description" name="description"
						id="description" rows="8" required="true" placeholder="Write your issue here"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Raise New Ticket"
					class="btn button shadow"></td>

			</tr>
		</table>
	</form:form>
	<table class="content-table shadow">
		<thead>
			<tr>
				<th>Ticket ID</th>
				<th>Date Of Ticket</th>
				<th>Issue Related To</th>
				<th>Description</th>
				<th>Status</th>
				<th>Admin Responce</th>
			</tr>
		</thead>
		<tbody class="tabledata">
			<c:forEach items="${ticketList}" var="ticket">
				<tr>
					<td>${ticket.ticketId}</td>
					<td>${ticket.ticketDate}</td>
					<td>${ticket.typeofissue}</td>
					<td>${ticket.description}</td>
					<td>${ticket.status}</td>
					<td>${ticket.adminResponce}</td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>