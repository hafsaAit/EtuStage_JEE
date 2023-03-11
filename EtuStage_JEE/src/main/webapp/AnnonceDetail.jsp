<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

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
<body>

	<c:if test="${sessionScope.type=='entreprise'}">
		<c:set var="stagaire" value="${requestScope.stagaire}" />
		<c:set var="annonceStagaire" value="${requestScope.annonce_stagaire}" />
		<div class="flex flex-col">
			<!-- bg -->
			<div class="relative">
				<img src="images/picture-test-2 1.png" />
				<a href="/EtuStage_JEE/AccueilServlet">
					<img
						class="z-20 absolute bottom-44 left-8 cursor-pointer hover:opacity-80 duration-150 "
						src="images/close.png">

				</a>


				<c:if test="${requestScope.isFavourite==true}">
					<a href="deleteFavouris?id=${annonceStagaire.getId_AnnSatg()}">
						<img id="active"
						class="absolute top-1/2 right-12 translate-y-20 z-20 cursor-pointer"
						src="images/favouris-active.png" />
					</a>

				</c:if>


				<c:if test="${requestScope.isFavourite==false}">
					<a href="addFavouris?id=${annonceStagaire.getId_AnnSatg()}"><img
						id="passive"
						class="absolute top-1/2 right-12 translate-y-20 z-20 cursor-pointer"
						src="images/favouris.png" /> </a>

				</c:if>

			</div>
			<div class="flex flex-col items-center space-y-4 -translate-y-40">
				<img class="w-[250px] h-[250px] rounded-full cursor-pointer"
					src="store/stagaire/${stagaire.getSt_image()}" />
				<h1 class="text-3xl font-extrabold">${annonceStagaire.getTitre_Stage()}</h1>
				<h1 class="text-2xl font-bold text-grayText">${annonceStagaire.getDomaine_Stage()}</h1>
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
						<h1 class="text-darkBlue font-semibold text-2xl">Type :</h1>
						<!-- info -->
						<h1 class="text-grayText text-xl">${annonceStagaire.getType_stage()}</h1>
					</div>
					<!-- item 2 -->
					<div class="flex items-center space-x-2">
						<!-- Dot -->
						<div class="w-[15px] h-[15px] rounded-full bg-darkBlue"></div>
						<!-- Field -->
						<h1 class="text-darkBlue font-semibold text-2xl">Durée :</h1>
						<!-- info -->
						<h1 class="text-grayText text-xl">${annonceStagaire.getDuree()}</h1>
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
						<h1 class="text-grayText text-xl">${stagaire.getEmail()}</h1>
					</div>
					<!-- item 2 -->
					<div class="flex items-center space-x-2">
						<!-- Dot -->
						<div class="w-[15px] h-[15px] rounded-full bg-darkBlue"></div>
						<!-- Field -->
						<h1 class="text-darkBlue font-semibold text-2xl">Mobile :</h1>
						<!-- info -->
						<h1 class="text-grayText text-xl">+${stagaire.getGSM()}</h1>
					</div>
				</div>
			</div>
			<div class="">
				<div
					class="container mx-auto px-12 font-lateef text-3xl mt-10 pb-10">
					${annonceStagaire.getDescription()}</div>
			</div>
		</div>
	</c:if>

	<c:if test="${sessionScope.type=='stagaire'}">
		<c:set var="entreprise" value="${requestScope.entreprise}" />
		<c:set var="annonceEntreprise"
			value="${requestScope.annonce_entreprise}" />
		<div class="flex flex-col">
			<!-- bg -->
			<div class="relative">

				<img src="images/picture-test-2 1.png" />

				<a href="/EtuStage_JEE/AccueilServlet">
					<img
						class="z-20 absolute bottom-44 left-8 cursor-pointer hover:opacity-80 duration-150 "
						src="images/close.png">
				</a>


				<c:if test="${requestScope.isFavourite==true}">

					<img id="active"
						class="absolute top-1/2 right-12 translate-y-20 z-20 cursor-pointer"
						src="images/favouris-active.png" />
				</c:if>
				<c:if test="${requestScope.isFavourite==false}">
					<a href="addFavouris?id=${annonceEntreprise.getId_AnnEntrp()}">
						<img id="passive"
						class="absolute top-1/2 right-12 translate-y-20 z-20 cursor-pointer"
						src="images/favouris.png" />
					</a>

				</c:if>

			</div>
			<div class="flex flex-col items-center space-y-4 -translate-y-40">
				<img class="w-[250px] h-[250px] rounded-full cursor-pointer"
					src="store/entreprise/${entreprise.getSt_image()}" />
				<h1 class="text-3xl font-extrabold">${annonceEntreprise.getTitre()}</h1>
				<h1 class="text-2xl font-bold text-grayText">${annonceEntreprise.getDomaine()}</h1>
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
						<h1 class="text-darkBlue font-semibold text-2xl">Type :</h1>
						<!-- info -->
						<h1 class="text-grayText text-xl">${annonceEntreprise.getType_Stag()}</h1>
					</div>
					<!-- item 2 -->
					<div class="flex items-center space-x-2">
						<!-- Dot -->
						<div class="w-[15px] h-[15px] rounded-full bg-darkBlue"></div>
						<!-- Field -->
						<h1 class="text-darkBlue font-semibold text-2xl">Durée :</h1>
						<!-- info -->
						<h1 class="text-grayText text-xl">${annonceEntreprise.getDuree()}</h1>
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
						<h1 class="text-grayText text-xl">${entreprise.getEmail()}</h1>
					</div>
					<!-- item 2 -->
					<div class="flex items-center space-x-2">
						<!-- Dot -->
						<div class="w-[15px] h-[15px] rounded-full bg-darkBlue"></div>
						<!-- Field -->
						<h1 class="text-darkBlue font-semibold text-2xl">Mobile :</h1>
						<!-- info -->
						<h1 class="text-grayText text-xl">+${entreprise.getGSM()}</h1>
					</div>
				</div>
			</div>
			<div class="">
				<div
					class="container mx-auto px-12 font-lateef text-3xl mt-10 pb-10">
					${annonceEntreprise.getDescription_Annc()}</div>
			</div>
		</div>
	</c:if>
</body>
</html>