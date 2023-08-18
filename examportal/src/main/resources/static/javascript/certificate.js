window.onload = function() {
	generatepdf();
};

function generatepdf() {

	var element = document.getElementById('certificate');
	var opt = {
		margin: 1,
		filename: 'certificate.pdf',
		image: { type: 'jpeg', quality: 0.98 },
		html2canvas: { scale: 2 },
		jsPDF: { unit: 'in', format: 'letter', orientation: 'landscape' }
	};

	html2pdf().set(opt).from(element).save();
}