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
<title>Give Feedback</title>
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
	<a href="/adminhomepage" style="margin: 30px 0 0 30px;"><img
		id="backArrow" style="width: 30px; height: 30px;"
		src="Img/backarrow.png" alt="Back"></a>
	<div class="mainContainer text-center">

		<h1 class="heading">Give your Feedback Here</h1>
		<div class="searchResultContainer">
			<form:form method="post"
				action="/giveFeedback?attemptId=${attemptId}"
				modelAttribute="feedback">
				<form:textarea path="feedback" rows="5" cols="50"
					placeholder="No Feedback" />
				<br>
				<input type="submit" name="submit" id="submit"
					class="btn btn-warning center" value="Submit">
				<br>
				<div class="text-light" style="margin-top: 10px">
					<center>${status}</center>
				</div>


			</form:form>
		</div>

	</div>



</body>
</html>
