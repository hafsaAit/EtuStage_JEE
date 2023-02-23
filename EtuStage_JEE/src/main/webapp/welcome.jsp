<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="js/welcome.js" type="text/javascript" defer></script>
<title>EtuStage</title>
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Lato:wght@100;300;400;700;900&display=swap"
	rel="stylesheet" />
<script src="https://cdn.tailwindcss.com"></script>
<script>
	tailwind.config = {
		theme : {
			extend : {
				colors : {
					cyanBlue : "#E7F5FF",
					darkBlue : " hsla(199, 68%, 49%, 0.87)",
					grayText : "hsla(0, 18%, 61%, 0.62)",
					cyan : "hsl(180, 66%, 49%)",
					cyanLight : "hsl(180, 66%, 69%)",
					darkViolet : "hsl(257, 27%, 26%)",
					red : "hsl(0, 87%, 67%)",
					grayishViolet : "hsl(257, 7%, 63%)",
					veryDarkBlue : "hsl(255, 11%, 22%)",
					veryDarkViolet : "hsl(260, 8%, 14%) ",
				},
				fontFamily : {
					sans : [ "Lato", "sans-serif" ],
				}

			}
		}
	}
</script>
<style type="text/tailwindcss">
  .btn {
  @apply bg-darkBlue font-bold text-white text-xl hover:opacity-80 duration-150 rounded-[40px] drop-shadow-lg;
}
  </style>
</head>
<body>
	<header
		class="bg-cyanBlue flex justify-between items-center py-4 px-8 rounded-b-2xl drop-shadow-sm">
		<!-- Part 1 -->
		<div class="flex items-center space-x-2">
			<img class="h-16" src="images/LogoAccueill.png" alt="Logo" />
			<h1 class="text-darkBlue text-4xl font-extrabold">EtuStage</h1>
		</div>
		<!-- Part 2 -->

		<div class="flex items-center space-x-4">
			<button id="loginShow" class="text-xl font-bold text-grayText">
				Login</button>
			<button id="signUpShow" class="btn w-[120px] h-[50px]">Sign
				Up</button>
		</div>
	</header>

	<!-- overlay -->
	<div id="overlay"
		class="absolute hidden bg-black top-0 left-0 bottom-0 right-0 z-10 opacity-40"></div>
	<!-- Login Pop UP Entreprise -->
	<div id="entpLoginPopup"
		class="absolute hidden bg-white top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2 z-20 w-[400px] rounded-lg drop-shadow-xl">
		<div
			class="relative flex flex-col items-center px-16 pt-16 pb-6 w-full rounded-lg">
			<img id="close"
				class="absolute top-2 right-2 w-8 cursor-pointer hover:opacity-80 duration-150"
				src="images/close.png" alt="close" />
			<!-- item 1 -->
			<img class="rounded-full w-24 -translate-y-[116px]"
				src="images/LoginLogo.png" alt="LoginLogo" />
			<!-- item 2 -->
			<div class="flex justify-between items-center w-full -translate-y-20">
				<h1
					class="text-darkBlue cursor-pointer border-b-2 text-xl font-bold">
					Entreprise</h1>
				<h1 id="stgLogin"
					class="text-xl cursor-pointer text-gray-600 font-bold">
					Stagaire</h1>
			</div>
			<!-- item 3 -->
			<form class="flex flex-col space-y-6 w-full" action="" method="post">
				<input id="email" name="emailEntp"
					class="outline-none py-4 rounded-xl bg-cyanBlue px-4" type="text"
					placeholder="Email Entreprise" required /> <input
					id="password" name="passwordEntp"
					class="outline-none py-4 rounded-xl bg-cyanBlue px-4"
					type="password" placeholder="Password" required />
				<button type="submit" class="btn px-16 py-4 self-center">
					Login</button>
			</form>
		</div>
	</div>

	<!-- Login Pop UP Stagaire -->
	<div id="stgLoginPopup"
		class="absolute hidden bg-white top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2 z-20 w-[400px] rounded-lg drop-shadow-xl">
		<div
			class="relative flex flex-col items-center px-16 pt-16 pb-6 w-full rounded-lg">
			<img id="closeTwo"
				class="absolute top-2 right-2 w-8 cursor-pointer hover:opacity-80 duration-150"
				src="images/close.png" alt="close" />
			<!-- item 1 -->
			<img class="rounded-full w-24 -translate-y-[116px]"
				src="images/LoginLogo.png" alt="LoginLogo" />
			<!-- item 2 -->
			<div class="flex justify-between items-center w-full -translate-y-20">
				<h1 id="entpLogin" class="text-xl cursor-pointer font-bold" href="#">
					Entreprise</h1>
				<h1
					class="text-darkBlue cursor-pointer border-b-2 text-xl font-bold"
					href="#">Stagaire</h1>
			</div>
			<!-- item 3 -->
			<form class="flex flex-col space-y-6 w-full" action="" method="post">
				<input id="email" name="emailStg"
					class="outline-none py-4 rounded-xl bg-cyanBlue px-4" type="text"
					placeholder="Email Stagaire" required /> <input
					id="password" name="passwordStg"
					class="outline-none py-4 rounded-xl bg-cyanBlue px-4"
					type="password" placeholder="Password" required />
				<button type="submit" class="btn px-16 py-4 self-center">
					Login</button>
			</form>
		</div>
	</div>

	<!-- SignUp Pop UP Entreprise -->
	<div id="entpSignUpPopup"
		class="absolute hidden bg-white top-1/2 left-1/2 -translate-x-1/2 -translate-y-[46%] z-20 rounded-lg drop-shadow-xl">
		<div
			class="relative flex flex-col items-center px-16 pt-16 pb-6 w-full rounded-lg">
			<img id="closeThree"
				class="absolute top-2 right-2 w-8 cursor-pointer hover:opacity-80 duration-150"
				src="images/close.png" alt="close" />
			<!-- item 1 -->
			<img class="rounded-full w-24 -translate-y-[116px]"
				src="images/LoginLogo.png" alt="LoginLogo" />
			<!-- item 2 -->
			<div
				class="flex justify-between items-center space-x-20 -translate-y-20">
				<h1
					class="text-darkBlue cursor-pointer border-b-2 text-xl font-bold">
					Entreprise</h1>
				<h1 id="stgSignUp"
					class="text-xl cursor-pointer text-gray-600 font-bold">
					Stagaire</h1>
			</div>
			<!-- item 3 -->
			<form id="entpSignUpForm"
				class="flex flex-col items-center space-y-6 w-[700px]" action=""
				method="post">
				<div class="grid gap-6 w-full grid-cols-2">
					<input id="nameSignUpEntp" name="nameSignUpEntp"
						class="outline-none py-4 rounded-xl bg-cyanBlue px-4" type="text"
						placeholder="Name Entreprise" required /> <input
						id="emailSignUpEntp" name="emailSignUpEntp"
						class="outline-none py-4 rounded-xl bg-cyanBlue px-4" type="email"
						placeholder="Email" required /> <input
						id="mobileSignUpEntp" name="mobileSignUpEntp"
						class="outline-none py-4 rounded-xl bg-cyanBlue px-4" type="tel"
						placeholder="Mobile" required /> <input
						id="passSignUpEntp" name="passSignUpEntp"
						class="outline-none py-4 rounded-xl bg-cyanBlue px-4"
						type="password" placeholder="Password" required /> <input
						id="villeSignUpEntp" name="villeSignUpEntp"
						class="outline-none py-4 rounded-xl bg-cyanBlue px-4" type="text"
						placeholder="Ville" required /> <input
						id="RepassSignUpEntp" name="RepassSignUpEntp"
						class="outline-none py-4 rounded-xl bg-cyanBlue px-4"
						type="password" placeholder="Confirm Password" required />
				</div>
				<label
					class="bg-red text-white font-bold rounded-[40px] text-center cursor-pointer p-2 px-6 drop-shadow-lg hover:opacity-80 duration-150"
					for="myfile">Charge Photo</label> <input
					class="hidden" type="file" id="myfile" name="myfile" />
				<button id="entpBtnSubmit" type="submit"
					class="btn px-16 py-4 self-center">Login</button>
			</form>
		</div>
	</div>

	<!-- SignUp Pop UP Stagaire -->

	<div id="stgSignUpPopup"
		class="absolute hidden bg-white top-1/2 left-1/2 -translate-x-1/2 -translate-y-[46%] z-20 rounded-lg drop-shadow-xl">
		<div
			class="relative flex flex-col items-center px-16 pt-16 pb-6 w-full rounded-lg">
			<img id="closeFour"
				class="absolute top-2 right-2 w-8 cursor-pointer hover:opacity-80 duration-150"
				src="images/close.png" alt="close" />
			<!-- item 1 -->
			<img class="rounded-full w-24 -translate-y-[116px]"
				src="images/LoginLogo.png" alt="LoginLogo" />
			<!-- item 2 -->
			<div
				class="flex justify-between items-center space-x-20 -translate-y-20">
				<h1 id="entpSignUp"
					class="text-gray-600 cursor-pointer text-xl font-bold">
					Entreprise</h1>
				<h1
					class="text-xl border-b-2 text-darkBlue cursor-pointer font-bold">
					Stagaire</h1>
			</div>
			<!-- item 3 -->
			<form class="flex flex-col items-center space-y-6 w-[700px]"
				action="" method="post">
				<div class="grid gap-6 w-full grid-cols-2">
					<input id="FirstnameSignUpStg" name="FirstnameSignUpStg"
						class="outline-none py-4 rounded-xl bg-cyanBlue px-4" type="text"
						placeholder="First Name" required /> <input
						id="LastnameSignUpStg" name="LastnameSignUpStg"
						class="outline-none py-4 rounded-xl bg-cyanBlue px-4" type="text"
						placeholder="Last Name" required /> <input
						id="emailSignUpStg" name="emailSignUpStg"
						class="outline-none py-4 rounded-xl bg-cyanBlue px-4" type="email"
						placeholder="Email" required /> <input
						id="mobileSignUpStg" name="mobileSignUpStg"
						class="outline-none py-4 rounded-xl bg-cyanBlue px-4" type="tel"
						placeholder="Mobile" required /> <input
						id="passSignUpStg" name="passSignUpStg"
						class="outline-none rounded-xl bg-cyanBlue px-4" type="password"
						placeholder="Password" required /> <input
						id="RepassSignUpStg" name="RepassSignUpStg"
						class="outline-none py-4 rounded-xl bg-cyanBlue px-4"
						type="password" placeholder="Confirm Password" required />
				</div>
				<label
					class="bg-red text-white font-bold rounded-[40px] text-center cursor-pointer p-2 px-6 drop-shadow-lg hover:opacity-80 duration-150"
					for="myfile">Charge Photo</label> <input
					class="hidden" type="file" id="myfile" name="myfile" />
				<button type="submit" class="btn px-16 py-4 self-center">
					Login</button>
			</form>
		</div>
	</div>

	<section class="container mx-auto px-8 mt-16">
		<div class="flex space-x-24 items-center justify-between">
			<!-- Part 1  -->
			<div
				class="flex flex-col space-y-8 items-start justify-start text-left">
				<h1 class="text-5xl font-extrabold max-w-md leading-[60px]">
					Welcome To EtuStage Website</h1>
				<p class="text-2xl text-grayText opacity-80 max-w-xl pb-6">
					EtudStage est une application web de recherche de stages. Les
					objectifs principaux de cette application sont d'une part, la mise
					en relation entre les candidats et les recruteurs via la
					publication d'offres de stages et demende de stages.</p>
				<button class="btn px-10 py-4">Download</button>
			</div>
			<!-- Part 2  -->
			<div>
				<img src="images/pic1.png" alt="pic1" />
			</div>
		</div>
	</section>


</body>
</html>