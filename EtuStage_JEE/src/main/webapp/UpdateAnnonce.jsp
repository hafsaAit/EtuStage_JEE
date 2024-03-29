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
	<section class="container mx-auto mt-10">
		<h1 class="font-lateef font-medium text-center text-5xl">Update
			Annonce</h1>

		<form action="UpdateAnnonce" method="post">

			<c:if test="${sessionScope.type=='entreprise'}">

				<c:set var="entreprise" value="${requestScope.entreprise}" />
				<c:set var="annonceEntreprise"
					value="${requestScope.annonce_entreprise}" />

				<div class="flex flex-col space-y-10 px-36">
					<input type="hidden" name="id"
						value="<c:out value='${annonce_entreprise.getId_AnnEntrp()}'/>" />
					<!-- part 1 -->
					<div class="flex justify-between mt-16 items-center">
						<input required placeholder="Titre de Stage"
							class="outline-none py-4 rounded-xl bg-cyanBlue pl-4 pr-8"
							type="text" name="title" value="${annonceEntreprise.getTitre()}" />
						<input required placeholder="Domaine de Stage"
							class="outline-none py-4 rounded-xl bg-cyanBlue pl-4 pr-8"
							type="text" name="domaine"
							value="${annonceEntreprise.getDomaine()}" />
					</div>
					<!-- part 2 -->

					<div class="flex justify-between mt-16 items-center">
						<input required placeholder="Type de Stage"
							class="outline-none py-4 rounded-xl bg-cyanBlue pl-4 pr-8"
							type="text" name="type"
							value="${annonceEntreprise.getType_Stag()}" /> <input required
							placeholder="Dur�e de Stage"
							class="outline-none py-4 rounded-xl bg-cyanBlue pl-4 pr-8"
							type="text" name="duree" value="${annonceEntreprise.getDuree()}" />
					</div>
					<div class="flex justify-center px-28">
						<textarea placeholder="Description"
							class="outline-none w-full py-4 px-6 rounded-xl bg-cyanBlue"
							minlength="200" maxlength="2000" name="description" cols="30"
							rows="6">${annonceEntreprise.getDescription_Annc()}</textarea>
					</div>
				</div>
				<div class="flex justify-center mt-10">
					<button type="submit" class="btn py-4 px-8">Update</button>
				</div>

			</c:if>

			<c:if test="${sessionScope.type=='stagaire'}">
				<c:set var="stagaire" value="${requestScope.stagaire}" />
				<c:set var="annonceStagaire"
					value="${requestScope.annonce_stagaire}" />

				<div class="flex flex-col space-y-10 px-36">
				
				<input type="hidden" name="id"
						value="<c:out value='${annonce_stagaire.getId_AnnSatg()}'/>" />
					<!-- part 1 -->
					<div class="flex justify-between mt-16 items-center">
						<input required placeholder="Titre de Stage"
							class="outline-none py-4 rounded-xl bg-cyanBlue pl-4 pr-8"
							type="text" name="title"
							value="${annonceStagaire.getTitre_Stage()}" /> <input required
							placeholder="Domaine de Stage"
							class="outline-none py-4 rounded-xl bg-cyanBlue pl-4 pr-8"
							type="text" name="domaine"
							value="${annonceStagaire.getDomaine_Stage()}" />
					</div>
					<!-- part 2 -->

					<div class="flex justify-between mt-16 items-center">
						<input required placeholder="Type de Stage"
							class="outline-none py-4 rounded-xl bg-cyanBlue pl-4 pr-8"
							type="text" name="type"
							value="${annonceStagaire.getType_stage()}" /> <input required
							placeholder="Dur�e de Stage"
							class="outline-none py-4 rounded-xl bg-cyanBlue pl-4 pr-8"
							type="text" name="duree" value="${annonceStagaire.getDuree()}" />
					</div>
					<div class="flex justify-center px-28">
						<textarea placeholder="Description"
							class="outline-none w-full py-4 px-6 rounded-xl bg-cyanBlue"
							minlength="200" maxlength="2000" name="description" cols="30"
							rows="6">${annonceStagaire.getDescription()}</textarea>
					</div>
				</div>
				<div class="flex justify-center mt-10">
					<button type="submit" class="btn py-4 px-8">Update</button>
				</div>

			</c:if>

		</form>
	</section>
</body>
</html>

