package net.javaguides.etustage.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.javaguides.etustage.dao.userOperations;
import net.javaguides.etustage.model.annonce_entreprise;

@WebServlet("/AddAnnonce")
public class AddAnnonce extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userOperations operations;
	

	public AddAnnonce() {
		this.operations=new userOperations();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int id= (int) session.getAttribute("id");
		String title = request.getParameter("title");
		String domaine=request.getParameter("domaine");
		String type=request.getParameter("type");
		String duree=request.getParameter("duree");
		String description=request.getParameter("description");
		annonce_entreprise anEntp=new annonce_entreprise(title, description, duree, type, id);
		try {
			operations.AddAnnonceEntreprise(anEntp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
