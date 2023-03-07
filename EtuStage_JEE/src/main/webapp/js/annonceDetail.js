const active = document.getElementById("active");
const passive = document.getElementById("passive");


passive.addEventListener("click", () => {
  passive.classList.add("hidden");
  active.classList.remove("hidden");
});

active.addEventListener("click", () => {
  active.classList.add("hidden");
  passive.classList.remove("hidden");
});
