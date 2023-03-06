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

import net.javaguides.etustage.dao.userOperations;

@WebServlet("/LoginEntreprise")
public class LoginEntreprise extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userOperations operations;

	public LoginEntreprise() {
		this.operations = new userOperations();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("emailEntp");
		String password = request.getParameter("passwordEntp");

		try {
			if (operations.checkUserLogin(email, password, "entreprise")) {
				int id = operations.getUserId(email,"entreprise"); 
				HttpSession session = request.getSession();
				session.setAttribute("userEmail", email);
				session.setAttribute("type", "entreprise");
				session.setAttribute("id", id);
				/* response.sendRedirect("Accueil.jsp"); */
				response.sendRedirect("AccueilServlet");

			} else {
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
