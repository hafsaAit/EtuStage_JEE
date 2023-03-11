package net.javaguides.etustage.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.javaguides.etustage.dao.favourisOperations;

@WebServlet("/deleteFavouris")
public class deleteFavouris extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private favourisOperations addFavouris;

	public deleteFavouris() {
		super();
		this.addFavouris = new favourisOperations();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		String typeOfUser = (String) session.getAttribute("type");
		int idUser = (int) session.getAttribute("id");
		
		try {
			DeleteAnnonceStagaireFromFav(request, response, idUser, id);
		} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	protected void DeleteAnnonceStagaireFromFav(HttpServletRequest request, HttpServletResponse response, int id_Entrp,
			int id_AnnStag) throws ClassNotFoundException, SQLException, ServletException, IOException {

		addFavouris.deleteAnnonceEntrp(id_Entrp, id_AnnStag);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/showAnnonce?id=" + id_AnnStag);
		dispatcher.forward(request, response);
	}
	
	protected void DeleteAnnonceEntrepriseFromFav(HttpServletRequest request, HttpServletResponse response, int id_Entrp,
			int id_AnnStag) throws ClassNotFoundException, SQLException, ServletException, IOException {

		addFavouris.deleteAnnonceEntrp(id_Entrp, id_AnnStag);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/showAnnonce?id=" + id_AnnStag);
		dispatcher.forward(request, response);
	}
}
