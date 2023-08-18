
var startMinutes = 1.5;
let time = startMinutes * 60;
var notified = false;

setInterval(startTimer, 1000);

window.onload = function() {
	startTimer();
};

function startTimer() {

	var minutes = Math.floor(time / 60);
	let seconds = time % 60;

	seconds = seconds < 10 ? '0' + seconds : seconds;

	document.getElementById("timer").innerHTML = minutes + ":" + seconds;

	if (minutes < 0) {
		document.getElementById("submit").click();
	}
	else if (!notified && minutes < 1) {
		swal({
			title: "Only one minute remaining !!",
			icon: "warning",
			dangerMode: true,
		});
		document.querySelector("body").style.cssText = "background:linear-gradient(to bottom right, #fc7703, #69001f);";
		document.getElementById("timer").style.color = "white";
		notified = true;
	}

	time--;
}