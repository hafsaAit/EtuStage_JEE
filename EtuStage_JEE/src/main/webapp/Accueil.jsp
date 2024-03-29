<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="js/app.js" type="text/javascript" defer></script>
<title>EtuStage</title>
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Roboto+Mono:wght@500&display=swap"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css2?family=Lato:wght@100;300;400;700;900&display=swap"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css2?family=Lateef&display=swap"
	rel="stylesheet" />
<script src="https://cdn.tailwindcss.com"></script>
<script>
	tailwind.config = {
		theme : {
			extend : {
				colors : {
					cyanBlue : "#E7F5FF",
					cyangreen : "#CEFFD9",
					darkBlue : " hsla(199, 68%, 49%, 0.87)",
					grayText : "hsla(0, 18%, 61%, 0.62)",
					cyan : "hsl(180, 66%, 49%)",
					softGreen : " hsla(205, 100%, 95%, 1)",
					softRed : "hsla(0, 99%, 71%, 0.17)",
					cyanLight : "hsl(180, 66%, 69%)",
					darkViolet : "hsl(257, 27%, 26%)",
					red : "hsl(0, 87%, 67%)",
					grayishViolet : "hsl(257, 7%, 63%)",
					veryDarkBlue : "hsl(255, 11%, 22%)",
					veryDarkViolet : "hsl(260, 8%, 14%) ",
				},
				fontFamily : {
					sans : [ "Lato", "sans-serif" ],
					robuto : [ "Roboto Mono", "monospace" ],
					lateef : [ "Lateef", "serif" ],
				},

			}
		}
	}
</script>
<style type="text/tailwindcss">
 .btn {
  @apply bg-darkBlue font-bold text-white text-xl hover:opacity-80 duration-150 rounded-[40px] drop-shadow-lg;
}

::-webkit-scrollbar {
  display: none;
}

  </style>
</head>
<body class="overflow-hidden">
	<div id="overlay"
		class="absolute hidden bg-black top-0 left-0 bottom-0 right-0 z-10 opacity-40"></div>
	<div id="entpLoginPopup"
		class="absolute hidden bg-white top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2 z-20 w-[400px] rounded-lg drop-shadow-xl">
		<div
			class="relative flex flex-col items-center px-16 pt-16 pb-6 w-full rounded-lg">
			<img id="close"
				class="absolute top-2 right-2 w-8 cursor-pointer hover:opacity-80 duration-150"
				src="images/close.png" alt="close" />
			<h1 class="text-4xl font-bold opacity-80">Want to logout?</h1>
			<a href="welcome.jsp"><button type="submit" class="btn mt-10 px-16 py-4 self-center">Logout</button></a>
		</div>
	</div>
	<header
		class="bg-cyanBlue flex justify-between items-center py-4 px-8 rounded-b-2xl drop-shadow-sm">
		<!-- Part 1 -->
		<div class="flex items-center space-x-2">
			<img class="h-16 cursor-pointer" id="logout"
				src="images/LogoAccueill.png" alt="Logo" />
		</div>

		<!-- Part 2 -->
		<div id="links" class="flex items-center space-x-20 font-robuto">
			<a id="Accueil" class="text-xl border-b-2 border-blue-500 opacity-80"
				href="#">Accueil</a> <a id="Favouris" class="text-xl opacity-80"
				href="#">Favouris</a> <a id="MesAnnonces" class="text-xl opacity-80"
				href="#">MesAnnonces</a> <a id="Profile" class="text-xl opacity-80"
				href="#">Profile</a>
		</div>
		<!-- Part 3 -->

		<div class="flex items-center space-x-4">
			<a href="AjouterAnnonce.jsp"><button id="signUpShow"
					class="btn w-[150px] h-[60px]">Ajouter</button></a>
		</div>
	</header>
	<!-- Profile  -->
	<div id="Container Profile" class="hidden flex flex-col">
		<!-- bg -->
		<img src="images/picture-test-2 1.png" />
		<c:if test="${sessionScope.type=='entreprise'}">
			<c:set var="entrepriseInfo" value="${requestScope.entrepriseInfo}" />

			<div class="flex justify-center -translate-y-40">
				<img class="w-[250px] h-[250px] rounded-full cursor-pointer"
					src="store/entreprise/${entrepriseInfo.getSt_image()}" />
			</div>
			<div
				class="container px-10 mx-auto flex justify-between -translate-y-20">
				<!-- Part 1 -->
				<div class="flex flex-col space-y-6 items-start">
					<!-- item 1 -->
					<div class="flex items-center space-x-2">
						<!-- Dot -->
						<div class="w-[15px] h-[15px] rounded-full bg-darkBlue"></div>
						<!-- Field -->
						<h1 class="text-darkBlue font-semibold text-2xl">Nom
							Entreprise :</h1>
						<!-- info -->
						<h1 class="text-grayText text-xl">${entrepriseInfo.getNomEntreprise()}</h1>
					</div>
					<!-- item 2 -->
					<div class="flex items-center space-x-2">
						<!-- Dot -->
						<div class="w-[15px] h-[15px] rounded-full bg-darkBlue"></div>
						<!-- Field -->
						<h1 class="text-darkBlue font-semibold text-2xl">Ville :</h1>
						<!-- info -->
						<h1 class="text-grayText text-xl">${entrepriseInfo.getVille()}</h1>
					</div>
				</div>
				<!-- Part 2 -->
				<div class="flex flex-col space-y-6 items-start">
					<!-- item 1 -->
					<div class="flex items-center space-x-2">
						<!-- Dot -->
						<div class="w-[15px] h-[15px] rounded-full bg-darkBlue"></div>
						<!-- Field -->
						<h1 class="text-darkBlue font-semibold text-2xl">Email :</h1>
						<!-- info -->
						<h1 class="text-grayText text-xl">${entrepriseInfo.getEmail()}</h1>
					</div>
					<!-- item 2 -->
					<div class="flex items-center space-x-2">
						<!-- Dot -->
						<div class="w-[15px] h-[15px] rounded-full bg-darkBlue"></div>
						<!-- Field -->
						<h1 class="text-darkBlue font-semibold text-2xl">Mobile :</h1>
						<!-- info -->
						<h1 class="text-grayText text-xl">+${entrepriseInfo.getGSM()}</h1>
					</div>
				</div>
			</div>

		</c:if>





		<c:if test="${sessionScope.type=='stagaire'}">
			<c:set var="stagaireInfo" value="${requestScope.stagaireInfo}" />

			<div class="flex justify-center -translate-y-40">
				<img class="w-[250px] h-[250px] rounded-full cursor-pointer"
					src="store/stagaire/${stagaireInfo.getSt_image()}" />
			</div>
			<div
				class="container px-10 mx-auto flex justify-between -translate-y-20">
				<!-- Part 1 -->
				<div class="flex flex-col space-y-6 items-start">
					<!-- item 1 -->
					<div class="flex items-center space-x-2">
						<!-- Dot -->
						<div class="w-[15px] h-[15px] rounded-full bg-darkBlue"></div>
						<!-- Field -->
						<h1 class="text-darkBlue font-semibold text-2xl">Nom :</h1>
						<!-- info -->
						<h1 class="text-grayText text-xl">${stagaireInfo.getNom()}</h1>
					</div>
					<!-- item 2 -->
					<div class="flex items-center space-x-2">
						<!-- Dot -->
						<div class="w-[15px] h-[15px] rounded-full bg-darkBlue"></div>
						<!-- Field -->
						<h1 class="text-darkBlue font-semibold text-2xl">Prenom :</h1>
						<!-- info -->
						<h1 class="text-grayText text-xl">${stagaireInfo.getPrenom()}</h1>
					</div>
				</div>
				<!-- Part 2 -->
				<div class="flex flex-col space-y-6 items-start">
					<!-- item 1 -->
					<div class="flex items-center space-x-2">
						<!-- Dot -->
						<div class="w-[15px] h-[15px] rounded-full bg-darkBlue"></div>
						<!-- Field -->
						<h1 class="text-darkBlue font-semibold text-2xl">Email :</h1>
						<!-- info -->
						<h1 class="text-grayText text-xl">${stagaireInfo.getEmail()}</h1>
					</div>
					<!-- item 2 -->
					<div class="flex items-center space-x-2">
						<!-- Dot -->
						<div class="w-[15px] h-[15px] rounded-full bg-darkBlue"></div>
						<!-- Field -->
						<h1 class="text-darkBlue font-semibold text-2xl">Mobile :</h1>
						<!-- info -->
						<h1 class="text-grayText text-xl">+${stagaireInfo.getGSM()}</h1>
					</div>
				</div>
			</div>

		</c:if>
	</div>
	<section id="appContainer" class="container mx-auto px-32 mt-20">


		<!-- Accueil Cards -->
		<div
			class="flex flex-col space-y-10 overflow-y-scroll shadow-lg px-6 rounded-lg py-6 h-[500px]"
			id="Container Accueil">

			<c:if test="${sessionScope.type=='entreprise'}">
				<c:forEach items="${annonceAccueil}" var="annonce">

					<!-- Card -->
					<a href="showAnnonce?id=${annonce.getId_AnnSatg()}"
						class="flex space-x-6 rounded-lg drop-shadow-sm p-4 bg-cyangreen">
						<!-- picture --> <img class="w-[194px] h-[175px] rounded-xl"
						src="store/stagaire/${annonce.getUserImage()}" /> <!-- informations -->
						<div class="flex flex-col items-start space-y-6">
							<!-- title -->
							<div class="flex flex-col space-y-2">
								<h1 class="font-bold text-xl">${annonce.getTitre_Stage()}</h1>
								<!-- domaine -->
								<h2 class="text-lg text-grayText font-bold">${annonce.getDomaine_Stage()}</h2>
							</div>
							<!-- description -->
							<p class="text-grayText text-lg opacity-80 font-lateef">
								${annonce.getFirst50Chars()} .......</p>
						</div> <!-- date -->
						<h1 class="text-grayText font-bold">1/02/2023</h1>
					</a>
				</c:forEach>


			</c:if>

			<c:if test="${sessionScope.type=='stagaire'}">
				<c:forEach items="${annonceAccueil}" var="annonce">

					<!-- Card -->
					<a href="showAnnonce?id=${annonce.getId_AnnEntrp()}"
						class="flex space-x-6 rounded-lg drop-shadow-sm p-4 bg-cyangreen">
						<!-- picture --> <img class="w-[194px] h-[175px] rounded-xl"
						src="store/entreprise/${annonce.getSt_image()}" /> <!-- informations -->
						<div class="flex flex-col items-start space-y-6">
							<!-- title -->
							<div class="flex flex-col space-y-2">
								<h1 class="font-bold text-xl">${annonce.getTitre()}</h1>
								<!-- domaine -->
								<h2 class="text-lg text-grayText font-bold">${annonce.getDomaine()}</h2>
							</div>
							<!-- description -->
							<p class="text-grayText text-lg opacity-80 font-lateef">
								${annonce.getFirst50Chars()} .......</p>
						</div> <!-- date -->
						<h1 class="text-grayText font-bold">1/02/2023</h1>
					</a>
				</c:forEach>


			</c:if>

		</div>

		<!-- Favouris Cards -->
		<div
			class="hidden flex flex-col space-y-10 overflow-y-scroll shadow-lg px-6 rounded-lg py-6 h-[500px]"
			id="Container Favouris">

			<c:if test="${sessionScope.type=='entreprise'}">
				<c:forEach items="${listofFavEntreprise}" var="annonce">

					<!-- Card -->
					<a href="showAnnonce?id=${annonce.getId_AnnSatg()}"
						class="flex space-x-6 rounded-lg drop-shadow-sm p-4 bg-softRed">
						<!-- picture --> <img class="w-[194px] h-[175px] rounded-xl"
						src="store/stagaire/${annonce.getUserImage()}" /> <!-- informations -->
						<div class="flex flex-col items-start space-y-6">
							<!-- title -->
							<div class="flex flex-col space-y-2">
								<h1 class="font-bold text-xl">${annonce.getTitre_Stage()}</h1>
								<!-- domaine -->
								<h2 class="text-lg text-grayText font-bold">${annonce.getDomaine_Stage()}</h2>
							</div>
							<!-- description -->
							<p class="text-grayText text-lg opacity-80 font-lateef">
								${annonce.getFirst50Chars()} .......</p>
						</div> <!-- date -->
						<h1 class="text-grayText font-bold">1/02/2023</h1>
					</a>
				</c:forEach>


			</c:if>

			<c:if test="${sessionScope.type=='stagaire'}">
				<c:forEach items="${listofStagaire}" var="annonce">

					<!-- Card -->
					<a href="showAnnonce?id=${annonce.getId_AnnEntrp()}"
						class="flex space-x-6 rounded-lg drop-shadow-sm p-4 bg-softRed">
						<!-- picture --> <img class="w-[194px] h-[175px] rounded-xl"
						src="store/entreprise/${annonce.getSt_image()}" /> <!-- informations -->
						<div class="flex flex-col items-start space-y-6">
							<!-- title -->
							<div class="flex flex-col space-y-2">
								<h1 class="font-bold text-xl">${annonce.getTitre()}</h1>
								<!-- domaine -->
								<h2 class="text-lg text-grayText font-bold">${annonce.getDomaine()}</h2>
							</div>
							<!-- description -->
							<p class="text-grayText text-lg opacity-80 font-lateef">
								${annonce.getFirst50Chars()} .......</p>
						</div> <!-- date -->
						<h1 class="text-grayText font-bold">1/02/2023</h1>
					</a>
				</c:forEach>


			</c:if>


		</div>

		<!-- MesAnnonces Cards -->
		<div
			class="hidden flex flex-col space-y-10 overflow-y-scroll shadow-lg px-6 rounded-lg py-6 h-[500px]"
			id="Container MesAnnonces">
			<!-- Card -->
			<c:if test="${sessionScope.type=='entreprise'}">
				<c:forEach items="${MesAnnonceEntreprise}" var="MesAnnonces">
					<div class="flex bg-softGreen p-4 rounded-lg">
						<a href="#" class="flex space-x-6 drop-shadow-sm"> <!-- picture -->
							<img class="w-[194px] h-[175px] rounded-xl"
							src="store/entreprise/${MesAnnonces.getSt_image()}" /> <!-- informations -->
							<div class="flex flex-col items-start space-y-6">
								<!-- title -->
								<div class="flex flex-col space-y-2">
									<h1 class="font-bold text-xl">${MesAnnonces.getTitre()}</h1>
									<!-- domaine -->
									<h2 class="text-lg text-grayText font-bold">${MesAnnonces.getDomaine()}</h2>
								</div>
								<!-- description -->
								<p class="text-grayText text-lg opacity-80 font-lateef">
									${MesAnnonces.getFirst50Chars()} .....</p>
							</div>
						</a>
						<!-- actions -->
						<div class="flex items-end justify-between flex-col p-2">
							<!-- date -->
							<h1 class="text-grayText font-bold">1/02/2023</h1>
							<div class="flex space-x-2">
								<a href="UpdateAnnonce?id=${MesAnnonces.getId_AnnEntrp()}">
									<button
										class="bg-darkBlue text-white w-[108px] h-[44px] rounded-lg hover:opacity-80 duration-150">
										Update</button>
								</a> <a href="DeleteAnnonce?id=${MesAnnonces.getId_AnnEntrp()}">
									<button
										class=" bg-red text-white w-[108px] h-[44px] rounded-lg
									hover:opacity-80duration-150">Delete</button>
								</a>

							</div>
						</div>
					</div>

				</c:forEach>

			</c:if>


			<!-- Card -->
			<c:if test="${sessionScope.type=='stagaire'}">
				<c:forEach items="${MesAnnonceStagaire}" var="MesAnnonces">
					<div class="flex bg-softGreen p-4 rounded-lg">
						<a href="#" class="flex space-x-6 drop-shadow-sm"> <!-- picture -->
							<img class="w-[194px] h-[175px] rounded-xl"
							src="store/stagaire/${MesAnnonces.getUserImage()}" /> <!-- informations -->
							<div class="flex flex-col items-start space-y-6">
								<!-- title -->
								<div class="flex flex-col space-y-2">
									<h1 class="font-bold text-xl">${MesAnnonces.getTitre_Stage()}</h1>
									<!-- domaine -->
									<h2 class="text-lg text-grayText font-bold">${MesAnnonces.getDomaine_Stage()}</h2>
								</div>
								<!-- description -->
								<p class="text-grayText text-lg opacity-80 font-lateef">
									${MesAnnonces.getFirst50Chars()} .....</p>
							</div>
						</a>
						<!-- actions -->
						<div class="flex items-end justify-between flex-col p-2">
							<!-- date -->
							<h1 class="text-grayText font-bold">1/02/2023</h1>
							<div class="flex space-x-2">
								<a href="UpdateAnnonce?id=${MesAnnonces.getId_AnnSatg()}">
									<button
										class="bg-darkBlue text-white w-[108px] h-[44px] rounded-lg hover:opacity-80 duration-150">
										Update</button>
								</a> <a href="DeleteAnnonce?id=${MesAnnonces.getId_AnnSatg()}">
									<button
										class=" bg-red text-white w-[108px] h-[44px] rounded-lg
									hover:opacity-80duration-150">Delete</button>
								</a>
							</div>
						</div>
					</div>

				</c:forEach>

			</c:if>

		</div>
	</section>
</body>
</html>
