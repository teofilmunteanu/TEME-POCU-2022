const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const id = parseInt(urlParams.get("id"));
const userData = JSON.parse(localStorage.getItem("userData"));
const selectedUser = userData.filter((el) => el.id === id)[0];

const error = document.createElement("p");
error.style.textAlign = "center";
error.style.display = "none";
document.querySelector("body").appendChild(error);

const title = document.createElement("p");
title.innerHTML = selectedUser.username + ", welcome to Endava internship 2022";
title.style.textAlign = "center";
document.querySelector("body").appendChild(title);

fetch("http://jsonplaceholder.typicode.com/users/" + id)
	.then((response) => response.json())
	.then((data) => {
		const name = document.createElement("p");
		const username = document.createElement("p");
		const email = document.createElement("p");
		const street = document.createElement("p");
		const suiteAddress = document.createElement("p");
		const phone = document.createElement("p");
		const companyName = document.createElement("p");

		name.innerHTML = data.name;
		username.innerHTML = data.username;
		email.innerHTML = data.email;
		street.innerHTML = data.address.street;
		suiteAddress.innerHTML = data.address.suite;
		phone.innerHTML = data.phone;
		companyName.innerHTML = data.company.name;

		document.querySelector("body").appendChild(name);
		document.querySelector("body").appendChild(username);
		document.querySelector("body").appendChild(email);
		document.querySelector("body").appendChild(street);
		document.querySelector("body").appendChild(suiteAddress);
		document.querySelector("body").appendChild(phone);
		document.querySelector("body").appendChild(companyName);
	})
	.catch((err) => {
		error.innerHTML = "Ooops something went wrong, please try again!";
		error.style.display = "block";
	});
