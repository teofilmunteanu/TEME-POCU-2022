const error = document.createElement("p");
error.style.textAlign = "center";
error.style.display = "none";
document.querySelector("body").appendChild(error);

const title = document.createElement("p");
title.innerHTML = "Welcome to Endava Internship 2022";
title.style.textAlign = "center";
document.querySelector("body").appendChild(title);

fetch("http://jsonplaceholder.typicode.com/users")
	.then((response) => response.json())
	.then((data) => {
		const ul = document.createElement("ul");
		document.querySelector("body").appendChild(ul);

		if (localStorage.getItem("userData") == null) {
			localStorage.setItem("userData", JSON.stringify(data));
		}

		let userData = JSON.parse(localStorage.getItem("userData"));

		Object.keys(userData).forEach(function (key) {
			const li = document.createElement("li");
			const usernameSpan = document.createElement("span");
			const emailSpan = document.createElement("span");
			const nameSpan = document.createElement("span");

			li.innerHTML += userData[key].id * 2 + " ";
			li.innerHTML += JSON.stringify(userData[key]) + " ";
			usernameSpan.innerHTML = userData[key].username;
			usernameSpan.setAttribute("id", userData[key].id);
			usernameSpan.style.textDecoration = "underline";
			li.appendChild(usernameSpan);

			nameSpan.innerHTML = "(" + userData[key].name + ") ";
			li.appendChild(nameSpan);

			emailSpan.innerHTML = userData[key].email + " ";
			li.appendChild(emailSpan);
			ul.appendChild(li);

			const detailsBtn = document.createElement("button");
			detailsBtn.innerHTML = userData[key].username + " Details";
			li.appendChild(detailsBtn);

			usernameSpan.addEventListener("click", showUserEdit);
			detailsBtn.addEventListener("click", () => goToPage2(userData[key].id));
		});

		const userDiv = document.createElement("div");
		userDiv.setAttribute("id", "userDiv");
		userDiv.style.display = "none";
		document.querySelector("body").appendChild(userDiv);

		const userDivLabel = document.createElement("label");
		userDivLabel.innerHTML = "Edit your name ";
		const br = document.createElement("br");
		userDivLabel.appendChild(br);

		const userDivInput = document.createElement("input");
		userDivInput.setAttribute("id", "userDivInput");

		const userDivBtn = document.createElement("button");
		userDivBtn.innerHTML = "Apply";
		userDivBtn.setAttribute("id", "applyBtn");
		userDivBtn.addEventListener("click", applyEdits);

		userDiv.appendChild(userDivLabel);
		userDiv.appendChild(userDivInput);
		userDiv.appendChild(userDivBtn);
	})
	.catch((err) => {
		error.innerHTML = "Ooops something went wrong, please try again!";
		error.style.display = "block";
	});

function showUserEdit(ev) {
	const userDiv = document.getElementById("userDiv");
	userDiv.style.display = "block";
	const userDivInput = document.getElementById("userDivInput");
	userDivInput.setAttribute("value", ev.currentTarget.innerHTML);

	const applyBtn = document.getElementById("applyBtn");
	const selectedId = parseInt(ev.currentTarget.id);
	applyBtn.selectedId = selectedId;
}

function applyEdits() {
	const applyBtn = document.getElementById("applyBtn");
	const userData = JSON.parse(localStorage.getItem("userData"));
	const selectedUser = userData.filter((el) => el.id === applyBtn.selectedId)[0];

	const userDivInput = document.getElementById("userDivInput");
	selectedUser.username = userDivInput.value;
	localStorage.setItem("userData", JSON.stringify(userData));
	location.reload();
}

function goToPage2(id) {
	const base_url = window.location.origin + "/Pagina2.html";
	window.location.href = base_url + "?id=" + id;
}
