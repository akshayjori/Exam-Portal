<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="css/graphicalReport.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" src="javascript/graphicalReport.js"></script>
</head>
<body>
<body>
	<a href="/adminhomepage" style="margin: 30px 0 0 30px;" class="backArrow"><i
		class="fas fa-chevron-circle-left" style="color: black; font-size: 40px;"></i></a>
	<div class="mainContainer justify-content-center">
		<div id="piechart-3d" class="ml-auto"></div>
	</div>
	<c:forEach items="${attemptsMap}" var="attempt">
		<input type="hidden" type="number" id="${attempt.key}"
			value="${attempt.value}">
	</c:forEach>
	<table class="javaTable table mx-auto shadow">
		<tr class="h">
			<th>Exam Name</th>
			<th>Knowledge Required</th>
		</tr>
		<tr class="l1">
			<td>Java Level 1</td>
			<td>Basic knowledge of java is needed. e.g. loops, oops
				concepts, datatypes, etc.</td>
		</tr>
		<tr class="l2">
			<td>Java Level 2</td>
			<td>In addition to the knowledge required upto level 1, you
				should also be familiar with java collection, java STL</td>
		</tr>
		<tr class="l3">
			<td>Java Level 3</td>
			<td>You should be proficient in all the java core concepts and
				advanced java concepts</td>
		</tr>
	</table>

	<table class="cppTable table mx-auto shadow">
		<tr class="h">
			<th>Exam Name</th>
			<th>Knowledge Required</th>
		</tr>
		<tr class="c1">
			<td>C++ Level 1</td>
			<td>Basic knowledge of C++ is needed. e.g. loops, oops concepts,
				datatypes, etc.</td>
		</tr>
		<tr class="c2">
			<td>C++ Level 2</td>
			<td>In addition to the knowledge required upto level 1, you
				should also be familiar with C++ collection, C++ STL</td>
		</tr>
		<tr class="c3">
			<td>C++ Level 3</td>
			<td>You should be proficient in all the C++ core concepts and
				advanced C++ concepts</td>
		</tr>
	</table>

	<table class="sqlTable table mx-auto shadow">
		<tr class="h">
			<th>Exam Name</th>
			<th>Knowledge Required</th>
		</tr>
		<tr class="s1">
			<td>SQL Level 1</td>
			<td>Basic knowledge is needed to write simple queries.</td>
		</tr>
		<tr class="s3">
			<td>SQL Level 3</td>
			<td>You should have the knowledge of SQL procedure, views,
				cursors and triggers</td>
		</tr>
	</table>
</body>
</html>