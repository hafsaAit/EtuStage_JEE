//Show

const loginShowBtn = document.getElementById("loginShow");
const signUpShowBtn = document.getElementById("signUpShow");

//close

const closeBtn = document.getElementById("close");
const closeTwoBtn = document.getElementById("closeTwo");
const closeThreeBtn = document.getElementById("closeThree");
const closeFourBtn = document.getElementById("closeFour");

//switch
const entrepriseBtn = document.getElementById("entpLogin");
const stagaireBtn = document.getElementById("stgLogin");
const stagaireBtnTwo = document.getElementById("stgSignUp");
const entrepriseBtnTwo = document.getElementById("entpSignUp");

const overlay = document.getElementById("overlay");

// Popups
const loginEntpPopup = document.getElementById("entpLoginPopup");
const loginStgPopup = document.getElementById("stgLoginPopup");
const signUpEntpPopup = document.getElementById("entpSignUpPopup");
const signUpStgPopup = document.getElementById("stgSignUpPopup");

// Controll

const entpPass = document.getElementById("passSignUpEntp");
const entpRePass = document.getElementById("RepassSignUpEntp");
// const entpForm = document.getElementById("entpSignUpForm");
const entpSubmitFrom = document.getElementById("entpBtnSubmit");

// entpSubmitFrom.addEventListener("submit", (e) => {
//   const pass1 = entpPass.value;
//   const pass2 = entpRePass.value;

//   if (pass1 !== pass2) {
//     e.preventDefault();
//     entpPass.classList.add("border-2 border-red");
//     entpRePass.classList.add("border-2 border-red");
//   } else {
//     entpPass.classList.remove("border-2 border-red");
//     entpRePass.classList.remove("border-2 border-red");
//   }
// });

loginShowBtn.addEventListener("click", () => {
  overlay.classList.remove("hidden");
  loginEntpPopup.classList.remove("hidden");
});

signUpShowBtn.addEventListener("click", () => {
  overlay.classList.remove("hidden");
  signUpEntpPopup.classList.remove("hidden");
});

/////
closeBtn.addEventListener("click", () => {
  overlay.classList.add("hidden");
  loginEntpPopup.classList.add("hidden");
});

closeTwoBtn.addEventListener("click", () => {
  overlay.classList.add("hidden");
  loginStgPopup.classList.add("hidden");
});

closeThreeBtn.addEventListener("click", () => {
  overlay.classList.add("hidden");
  signUpEntpPopup.classList.add("hidden");
});

closeFourBtn.addEventListener("click", () => {
  overlay.classList.add("hidden");
  signUpStgPopup.classList.add("hidden");
});

/////

stagaireBtn.addEventListener("click", () => {
  loginEntpPopup.classList.add("hidden");
  loginStgPopup.classList.remove("hidden");
});

entrepriseBtn.addEventListener("click", () => {
  loginEntpPopup.classList.remove("hidden");
  loginStgPopup.classList.add("hidden");
});

stagaireBtnTwo.addEventListener("click", () => {
  signUpStgPopup.classList.remove("hidden");
  signUpEntpPopup.classList.add("hidden");
});

entrepriseBtnTwo.addEventListener("click", () => {
  signUpEntpPopup.classList.remove("hidden");
  signUpStgPopup.classList.add("hidden");
});
