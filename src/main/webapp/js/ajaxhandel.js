let searchstate = (str) => {
	let tablebody = document.getElementById("tbodyy");
	tablebody.innerHTML = "";
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			tablebody.innerHTML = this.responseText;
		}
	};

	xhttp.open("GET", "/HousePredictionWeb/searchStateByName?s=" + str, true);
	xhttp.send();

}

let fetchCities = () => {
	let stateDropDown = document.getElementById("citystatehandel");
	let tbody = document.getElementById("citytablebody");
	let stateid = stateDropDown.value;
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			tbody.innerHTML = this.responseText;
		}

	};

	xhttp.open("GET", "/HousePredictionWeb/fetchStatewisecity?stid=" + stateid, true);
	xhttp.send();
}


let changeCityForLoc = () => {
	let stateDropDown = document.getElementById("stateOption");
	let tbody = document.getElementById("cityoptions");
	let stateid = stateDropDown.value;
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {

			//console.log(this.responseText);

			tbody.innerHTML = this.responseText;
		}

	};

	xhttp.open("GET", "/HousePredictionWeb/fetchStateWiseCityForLocation?stid=" + stateid, true);
	xhttp.send();
}


let fetchLocationUsingCity = () => {
	
	let citydropdown = document.getElementById("cityoptions");
		let tbody = document.getElementById("locationtablebody");
		let cityid = citydropdown.value;
		let xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				tbody.innerHTML = this.responseText;
			}

		};

		xhttp.open("GET", "/HousePredictionWeb/fetchCityWiseLocation?ciid=" + cityid, true);
		xhttp.send();
}



let changeLocationforProperty = () => {
	let stateDropDown = document.getElementById("cityoptions");
	let tbody = document.getElementById("locationoptions");
	let cityid = stateDropDown.value;
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {

			//console.log(this.responseText);

			tbody.innerHTML = this.responseText;
		}

	};

	xhttp.open("GET", "/HousePredictionWeb/fetchLocationForPrperty?ctid=" + cityid, true);
	xhttp.send();
}


let fetchPrpertyOnLocationChange=()=>{
	let citydropdown = document.getElementById("locationoptions");
			let tbody = document.getElementById("propertytablebody");
			let locattionid = citydropdown.value;
			let xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					
					//console.log(this.responseText);
					tbody.innerHTML = this.responseText;
				}

			};

			xhttp.open("GET", "/HousePredictionWeb/fetchPropertyUsingLocation?lid=" + locattionid, true);
			xhttp.send();
}



let fetchPrpertyOnLocationChangeforuser=()=>{
	let citydropdown = document.getElementById("locationoptions");
			let tbody = document.getElementById("propertytablebody");
			let locattionid = citydropdown.value;
			let xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					
					//console.log(this.responseText);
					tbody.innerHTML = this.responseText;
				}

			};

			xhttp.open("GET", "/HousePredictionWeb/fetchproertyforsuser?lid=" + locattionid, true);
			xhttp.send();
}