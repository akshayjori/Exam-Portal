window.onload = function() {
	setDateValues();
};

function setDateValues(){
	document.getElementById("startDate").value= "2001-01-01";
	var d= new Date();
	//alert(d.getFullYear()+"-"+d.getMonth()+"-"+d.getDate());
	document.getElementById("endDate").value= d.getFullYear()+"-"+d.getMonth()+1+"-"+d.getDate();
}

function generate(){
	let data=document.getElementById('table');
	var fp=XLSX.utils.table_to_book(data,{sheet:'sheet1'});
	XLSX.write(fp,{
		bookType:'xlsx',
		type:'base64'
	});
	XLSX.writeFile(fp, 'report.xlsx');
}
