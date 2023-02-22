	const loginShowBtn = document.getElementById("loginShow");
	const closeBtn = document.getElementById("close");
	const closeTwoBtn = document.getElementById("closeTwo");
	const entrepriseBtn = document.getElementById("entpLogin");
	const stagaireBtn = document.getElementById("stgLogin");
	const overlay = document.getElementById("overlay");
	const loginEntpPopup = document.getElementById("entpLoginPopup");
	const loginStgPopup = document.getElementById("stgLoginPopup");

	loginShowBtn.addEventListener("click", () => {
	  overlay.classList.remove("hidden");
	  loginEntpPopup.classList.remove("hidden");
	});

	closeBtn.addEventListener("click", () => {
	  overlay.classList.add("hidden");
	  loginEntpPopup.classList.add("hidden");
	});

	closeTwoBtn.addEventListener("click", () => {
	  overlay.classList.add("hidden");

	  loginStgPopup.classList.add("hidden");
	});

	stagaireBtn.addEventListener("click", () => {
	  loginEntpPopup.classList.add("hidden");
	  loginStgPopup.classList.remove("hidden");
	});

	entrepriseBtn.addEventListener("click", () => {
	  loginEntpPopup.classList.remove("hidden");
	  loginStgPopup.classList.add("hidden");
	});