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
import net.javaguides.etustage.dao.userInfo;
import net.javaguides.etustage.dao.userOperations;
import net.javaguides.etustage.model.annonce_entreprise;
import net.javaguides.etustage.model.annonce_stagaire;
import net.javaguides.etustage.model.entreprise;
import net.javaguides.etustage.model.stagaire;

@WebServlet("/showAnnonce")
public class ActionManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userInfo userInfo;
	private favourisOperations favourisOperations;

	public ActionManagement() {
		super();
		this.userInfo = new userInfo();
		this.favourisOperations=new favourisOperations();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
    	String typeOfUser = (String) session.getAttribute("type");
		System.out.println("---->" + id);
		
		if(typeOfUser.equals("entreprise")) {
			try {
				showAnnonceStagaireDetail(request, response, id);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				showAnnonceEntrepriseDetail(request, response, id);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	private void showAnnonceStagaireDetail(HttpServletRequest request, HttpServletResponse response,int id)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		annonce_stagaire annonce_stagaire=userInfo.getAnnonceStagaireInfo(id);
		stagaire stagaire=userInfo.getStagaireInfo(annonce_stagaire.getId_Stag());
		boolean isFavourit=favourisOperations.checkStagaireAnnonceisFavourite(id);
		
		request.setAttribute("stagaire", stagaire); 
		request.setAttribute("annonce_stagaire", annonce_stagaire);
		request.setAttribute("isFavourite", isFavourit);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AnnonceDetail.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showAnnonceEntrepriseDetail(HttpServletRequest request, HttpServletResponse response,int id)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		annonce_entreprise annonce_entreprise=userInfo.getAnnonceEntrepriseInfo(id);
		entreprise entreprise=userInfo.getEntrepriseInfo(annonce_entreprise.getId_Entrp());
		
		
		request.setAttribute("entreprise", entreprise); 
		request.setAttribute("annonce_entreprise", annonce_entreprise);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AnnonceDetail.jsp");
		dispatcher.forward(request, response);
	}
}