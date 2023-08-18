<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exam Report</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="css/examReport.css" rel="stylesheet">
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
	<a class="text-light homeIcon" href="/welcome"><i
		class="fas fa-home"></i></a>
	<div class="mainContainer">
		<h1>Congrats, ${user.firstname} ${user.lastname} !!</h1>
		<h3>Your score is :</h3>
		<div class="score">${score}</div>
		<h2>Questions Answered Correctly : ${correctAnswers}/10</h2>
		<h2>Questions Not Attempted : ${unAnswered}</h2>
		<br> <a class="btn btn-warning"
			href="certificate?userId=${user.userId}&attemptId=${attemptId}"
			target="_blank">Download Certificate</a>
	</div>
</body>
</html>