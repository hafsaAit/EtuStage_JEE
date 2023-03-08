package net.javaguides.etustage.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.javaguides.etustage.dao.userInfo;
import net.javaguides.etustage.model.annonce_entreprise;
import net.javaguides.etustage.model.annonce_stagaire;
import net.javaguides.etustage.model.entreprise;
import net.javaguides.etustage.model.stagaire;

@WebServlet("/AccueilServlet")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userInfo userInfo;

	public AccueilServlet() {
		this.userInfo = new userInfo();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String message = "Hello, world!";

		request.setAttribute("message", message);
		HttpSession session = request.getSession();
		int idUser = (Integer) session.getAttribute("id");
		String typeOfUser = (String) session.getAttribute("type");

		if (typeOfUser.equals("stagaire")) {
			getAnnonceEntreprise(request, response);
			getStagaireInfo(request, response, idUser);
			getMesAnnonceStagaire(request, response, idUser);
		} else {
			getAnnonceStagaire(request, response);
			getEntrepriseInfo(request, response, idUser);
			getMesAnnonceEntreprise(request, response, idUser);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("Accueil.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void getAnnonceStagaire(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<annonce_stagaire> listAnnonceStagaie = userInfo.getStagaireAnnonce();
			request.setAttribute("annonceAccueil", listAnnonceStagaie);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void getAnnonceEntreprise(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<annonce_entreprise> listAnnonceEntreprise = userInfo.getEntrepriseeAnnonce();
			request.setAttribute("annonceAccueil", listAnnonceEntreprise);
			System.out.println(listAnnonceEntreprise);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void getStagaireInfo(HttpServletRequest request, HttpServletResponse response, int idUser) {
		try {
			stagaire stagaireInfo = userInfo.getStagaireInfo(idUser);
			request.setAttribute("stagaireInfo", stagaireInfo);
			System.out.println(stagaireInfo.getEmail());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void getEntrepriseInfo(HttpServletRequest request, HttpServletResponse response, int idUser) {
		try {
			entreprise entrepriseInfo = userInfo.getEntrepriseInfo(idUser);
			request.setAttribute("entrepriseInfo", entrepriseInfo);
			System.out.println(entrepriseInfo.getEmail());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void getMesAnnonceEntreprise(HttpServletRequest request, HttpServletResponse response, int idUser) {
		try {
			ArrayList<annonce_entreprise> listAnnonceEntreprise = userInfo.getEntrepriseMesAnnonce(idUser);
			request.setAttribute("MesAnnonceEntreprise", listAnnonceEntreprise);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void getMesAnnonceStagaire(HttpServletRequest request, HttpServletResponse response, int idUser) {
		try {
			ArrayList<annonce_stagaire> listAnnonceStagaire = userInfo.getStagaireMesAnnonce(idUser);
			request.setAttribute("MesAnnonceStagaire", listAnnonceStagaire);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
