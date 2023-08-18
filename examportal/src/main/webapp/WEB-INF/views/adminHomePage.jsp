<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home Page</title>
<link href="css/common.css" rel="stylesheet">
<link href="css/navbar.css" rel="stylesheet">
<link href="css/adminHome.css" rel="stylesheet">
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

	<div class="topnav">
		<a class="active " href="/adminhomepage"><i class="fas fa-home"></i>
			Exam Portal</a> <a href="#about">About</a>
		<div class="float-right">
			<a href="#contact">Contact</a> <a href="/logout"><i
				class="fas fa-sign-out-alt"></i>Logout</a>
		</div>
	</div>
	<div
		class=" mainContainer row justify-content-center align-items-center">

		<table>
			<tr>

				<td><div class="leftSide">
						<i id="adminIcon" class="fas fa-book-reader"></i>
						<h1 id="welcomeMessage" class="heading">
							Hello ${verifiedUser.firstname}<br> Welcome
						</h1>
					</div></td>
				<td>
					<div class="rightSide">
						<table>
							<tr>
								<td><a href="/addexam"><button
											class="btn button shadow">
											<span>ADD EXAM DETAILS</span>
										</button></a></td>
								<td><a href="/searchExamDetails?searchWord="><button
											class="btn button shadow">
											<span>UPDATE EXAM DETAILS</span>
										</button></a></td>
							</tr>
							<tr>
								<td><a href="/addQues"><button
											class="btn button shadow">
											<span>ADD QUESTIONS</span>
										</button></a></td>
								<td><a href="/searchQues?subject=unknown"><button
											class="btn button shadow">
											<span>UPDATE QUESTIONS</span>
										</button></a></td>
							</tr>
							<tr>
								<td><a href="/showHelpRequest"><button
											class="btn button shadow">
											<span>HELP REQUESTS</span>
										</button></a></td>
								<td><a href="/generateReport"><button class="btn button shadow">
											<span>REPORT GENERATION</span>
										</button></a></td>
							</tr>
							<tr>
								<td colspan="2" class="gr"><a href="/graphicalReport"><button
											class="btn button shadow">
											<span>GRAPHICAL REPORT</span>
										</button></a></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>