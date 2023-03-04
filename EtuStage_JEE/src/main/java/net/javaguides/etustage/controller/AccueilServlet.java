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


@WebServlet("/AccueilServlet")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private userInfo userInfo;
   
    public AccueilServlet() {
    	this.userInfo=new userInfo();
    }

    
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String message = "Hello, world!";
    	
    	request.setAttribute("message", message);
    	HttpSession session = request.getSession();
    	String typeOfUser = (String) session.getAttribute("type");
    	
    	if(typeOfUser.equals("stagaire")) {
    		getAnnonceEntreprise(request, response);
    	}else {
    		getAnnonceStagaire(request, response);
    	}

        RequestDispatcher dispatcher = request.getRequestDispatcher("Accueil.jsp");
        dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void getAnnonceStagaire (HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<annonce_stagaire> listAnnonceStagaie=userInfo.getStagaireAnnonce();
			request.setAttribute("annonceAccueil", listAnnonceStagaie);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void getAnnonceEntreprise (HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<annonce_entreprise> listAnnonceEntreprise=userInfo.getEntrepriseeAnnonce();
			request.setAttribute("annonceAccueil", listAnnonceEntreprise);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
