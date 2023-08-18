google.charts.load("current", {
	packages: ["corechart"]
});
google.charts.setOnLoadCallback(drawChart);
function drawChart() {
	var Java_count = parseInt(document.getElementById("Java").value);
	var Cpp_count = parseInt(document.getElementById("C++").value);
	var SQL_count = parseInt(document.getElementById("SQL").value);

	var data = google.visualization.arrayToDataTable([
		['Exam Topic', 'No of User Attempts'], ['Java', Java_count], ['C++', Cpp_count],
		['SQL', SQL_count]
		]);

	var options = {
		title: 'Exam attempts so far !!',
		is3D: true,
	};

	var chart = new google.visualization.PieChart(document
		.getElementById('piechart-3d'));
	chart.draw(data, options);
}