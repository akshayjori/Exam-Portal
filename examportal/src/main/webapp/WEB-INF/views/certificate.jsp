
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>EX-Certificate</title>
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
<link rel="stylesheet" href="./style.css">
<link href="css/certificate.css" rel="stylesheet">
<script src="javascript/certificate.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.10.1/html2pdf.bundle.min.js"
	integrity="sha512-GsLlZN/3F2ErC5ifS5QtgpiJtWd43JWSuIgh7mbzZ8zBps+dvLusV+eNQATqgA/HdeKFVgA5v3S/cIrLF7QnIg=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
	<!-- partial:index.partial.html -->
<body>
	<div class="container pm-certificate-container" id="certificate">
		<div class="outer-border"></div>
		<div class="inner-border"></div>

		<div class="pm-certificate-border col-xs-12">
			<div class="row pm-certificate-header">
				<div class="pm-certificate-title cursive col-xs-12 text-center">
					<h2>Certificate of Completion</h2>
				</div>
			</div>

			<div class="row pm-certificate-body" style="padding: 0px;">

				<div class="pm-certificate-block">
					<div class="col-xs-12">
						<div class="row">
							<div class="col-xs-2">
								<!-- LEAVE EMPTY -->
							</div>
							<div
								class="pm-certificate-name underline margin-0 col-xs-8 text-center">
								<span class="pm-name-text bold" id="name">${user.firstname} ${user.lastname}</span>
							</div>
							<div class="col-xs-2">
								<!-- LEAVE EMPTY -->
							</div>
						</div>
					</div>

					<div class="col-xs-12">
						<div class="row">
							<div class="col-xs-2">
								<!-- LEAVE EMPTY -->
							</div>
							<div class="pm-earned col-xs-8 text-center">
								<span class="pm-earned-text padding-0 block cursive">has
									earned score of</span> <span class="pm-credits-text block bold sans" id="score">${exQuestion.score}<span style="font-size: 15px;">/100</span></span>
							</div>
							<div class="col-xs-2">
								<!-- LEAVE EMPTY -->
							</div>
							<div class="col-xs-12"></div>
						</div>
					</div>

					<div class="col-xs-12">
						<div class="row">
							<div class="col-xs-2">
								<!-- LEAVE EMPTY -->
							</div>
							<div class="pm-course-title col-xs-8 text-center">
								<span class="pm-earned-text block cursive">in the Cognizant Exam Portal Assessment entitled</span>
							</div>
							<div class="col-xs-2">
								<!-- LEAVE EMPTY -->
							</div>
						</div>
					</div>

					<div class="col-xs-12">
						<div class="row">
							<div class="col-xs-2">
								<!-- LEAVE EMPTY -->
							</div>
							<div class="pm-course-title underline col-xs-8 text-center">
								<span class="pm-credits-text block bold sans">${exam.examName}</span>
							</div>
							<div class="col-xs-2">
								<!-- LEAVE EMPTY -->
							</div>
						</div>
					</div>
				</div>

				<div class="col-xs-12">
					<div class="row">
						<div class="pm-certificate-footer">
							<div class="col-xs-4 pm-certified col-xs-4 text-center">
								<span class="pm-credits-text block sans">Authorized by</span><span class="pm-empty-space block underline">
								<img src="Img/ajSign.png" class="mySign"></span>
								<span class="bold block">Akshay A. Jori<br>Training and Certification Head</span>
							</div>
							<div class="col-xs-4">
								<!-- LEAVE EMPTY -->
							</div>
							<div class="col-xs-4 pm-certified col-xs-4 text-center">
								<span class="pm-credits-text block sans">Date Completed</span> <span
									class="pm-empty-space block underline" style="font-size: 20px;">${attDate}</span> <span
									class="bold block">DOB: ${user.dateOfBirth}</span> <span class="bold block">Certificate Id #${exam.examCode}-${user.userId}-${exQuestion.attemptId}</span>
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>
	</div>

</body>
</body>
</html>
