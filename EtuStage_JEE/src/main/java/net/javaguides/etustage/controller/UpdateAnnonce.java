package net.javaguides.etustage.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.javaguides.etustage.dao.favourisOperations;
import net.javaguides.etustage.dao.userInfo;
import net.javaguides.etustage.model.annonce_entreprise;
import net.javaguides.etustage.model.annonce_stagaire;
import net.javaguides.etustage.model.entreprise;
import net.javaguides.etustage.model.stagaire;

@WebServlet("/UpdateAnnonce")
public class UpdateAnnonce extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userInfo userInfo;
	private favourisOperations favourisOperations;

	public UpdateAnnonce() {
		super();
		this.userInfo = new userInfo();
		this.favourisOperations = new favourisOperations();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		String typeOfUser = (String) session.getAttribute("type");
		int idUser = (int) session.getAttribute("id");

	

		if (typeOfUser.equals("entreprise")) {
			try {
	
				showAnnonceEntrepriseDetail(request, response, id);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
			
				showAnnonceStagaireDetail(request, response, id);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String typeOfUser = (String) session.getAttribute("type");
		int idUser = (int) session.getAttribute("id");
		int id = Integer.parseInt(request.getParameter("id"));
		
		String title = request.getParameter("title");
		String domaine = request.getParameter("domaine");
		String type = request.getParameter("type");
		String duree = request.getParameter("duree");
		String description = request.getParameter("description");
		
		if (typeOfUser.equals("entreprise")) {
			try {
				annonce_entreprise anEntp = new annonce_entreprise(id,title, domaine, description, duree, type);
				userInfo.UpdateAnnonceEntrp(anEntp);
				response.sendRedirect("/EtuStage_JEE/AccueilServlet");
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				annonce_stagaire anStg = new annonce_stagaire(id,title, domaine, description, type, duree);
				userInfo.UpdateAnnonceStag(anStg);
				response.sendRedirect("/EtuStage_JEE/AccueilServlet");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void showAnnonceStagaireDetail(HttpServletRequest request, HttpServletResponse response, int id)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		annonce_stagaire annonce_stagaire = userInfo.getAnnonceStagaireInfo(id);
		stagaire stagaire = userInfo.getStagaireInfo(annonce_stagaire.getId_Stag());

		request.setAttribute("stagaire", stagaire);
		request.setAttribute("annonce_stagaire", annonce_stagaire);

		RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateAnnonce.jsp");
		dispatcher.forward(request, response);
	}

	private void showAnnonceEntrepriseDetail(HttpServletRequest request, HttpServletResponse response, int id)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		annonce_entreprise annonce_entreprise = userInfo.getAnnonceEntrepriseInfo(id);
		entreprise entreprise = userInfo.getEntrepriseInfo(annonce_entreprise.getId_Entrp());

		request.setAttribute("entreprise", entreprise);
		request.setAttribute("annonce_entreprise", annonce_entreprise);

		RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateAnnonce.jsp");
		dispatcher.forward(request, response);
	}

}
