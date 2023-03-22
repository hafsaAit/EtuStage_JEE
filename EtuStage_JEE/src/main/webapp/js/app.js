const links = document.querySelectorAll("#links a");
const AccueilContainer = document.getElementById("Container Accueil");
const FavourisContainer = document.getElementById("Container Favouris");
const MesAnnonceContainer = document.getElementById("Container MesAnnonces");
const ProfileContainer = document.getElementById("Container Profile");
const logOutShowBtn = document.getElementById("logout");
const overlay = document.getElementById("overlay");
const logOutPopup = document.getElementById("entpLoginPopup");
const closeBtn = document.getElementById("close");

links.forEach((link) => {
	link.addEventListener("click", function(event) {
		event.preventDefault(); // prevent default link behavior

		// remove the border from all links
		links.forEach((link) => {
			link.classList.remove("border-b-2", "border-blue-500");
			AccueilContainer.classList.add("hidden");
			FavourisContainer.classList.add("hidden");
			MesAnnonceContainer.classList.add("hidden");
			ProfileContainer.classList.add("hidden");
		});

		// add the border to the clicked link
		this.classList.add("border-b-2", "border-blue-500");
		const id = this.id;
		if (id === "Accueil") {
			AccueilContainer.classList.remove("hidden");
		} else if (id == "Favouris") {
			FavourisContainer.classList.remove("hidden");
		} else if (id === "MesAnnonces") {
			MesAnnonceContainer.classList.remove("hidden");
		} else if (id === "Profile") {
			ProfileContainer.classList.remove("hidden");
		}
	});
});


logOutShowBtn.addEventListener("click", () => {
  overlay.classList.remove("hidden");
  logOutPopup.classList.remove("hidden");
});

closeBtn.addEventListener("click", () => {
  overlay.classList.add("hidden");
  logOutPopup.classList.add("hidden");
});