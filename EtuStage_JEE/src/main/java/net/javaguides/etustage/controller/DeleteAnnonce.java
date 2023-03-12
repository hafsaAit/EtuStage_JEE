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

import net.javaguides.etustage.dao.userInfo;

/**
 * Servlet implementation class DeleteAnnonce
 */
@WebServlet("/DeleteAnnonce")
public class DeleteAnnonce extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userInfo userInfo;

	public DeleteAnnonce() {
		super();
		this.userInfo = new userInfo();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idAnnonce = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		String typeOfUser = (String) session.getAttribute("type");
		if (typeOfUser.equals("entreprise")) {

			try {
				deleteAnnonceEntrp(request, response, idAnnonce);
			} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			try {
				deleteAnnonceStag(request, response, idAnnonce);
			} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	protected void deleteAnnonceEntrp(HttpServletRequest request, HttpServletResponse response, int id_AnnEntrp)
			throws ClassNotFoundException, SQLException, ServletException, IOException {
		userInfo.deleteAnnonceEntrp(id_AnnEntrp);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AccueilServlet");
		dispatcher.forward(request, response);
	}

	protected void deleteAnnonceStag(HttpServletRequest request, HttpServletResponse response, int id_AnnStag)
			throws ClassNotFoundException, SQLException, ServletException, IOException {
		userInfo.deleteAnnonceStag(id_AnnStag);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AccueilServlet");
		dispatcher.forward(request, response);
	}

}
