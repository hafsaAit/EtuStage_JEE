package net.javaguides.etustage.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import net.javaguides.etustage.dao.registre;
import net.javaguides.etustage.dao.userOperations;
import net.javaguides.etustage.model.entreprise;
import net.javaguides.etustage.model.stagaire;

@MultipartConfig
@WebServlet("/RegisterEntreprise")
public class RegisterEntreprise extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private registre registre;
	private userOperations operations;

	public RegisterEntreprise() {
		this.registre = new registre();
		this.operations = new userOperations();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean i = false;
		String NomEntreprise = request.getParameter("nameSignUpEntp");
		String password = request.getParameter("passSignUpEntp");
		String repassword = request.getParameter("RepassSignUpEntp");
		String email = request.getParameter("emailSignUpEntp");
		String gsm = request.getParameter("mobileSignUpEntp");
		String ville = request.getParameter("villeSignUpEntp");
		Part file = request.getPart("myfile");
		String imageFileName = file.getSubmittedFileName();

		String uploadPath = "C:/Users/moude/eclipse-workspace/EtuStage_JEE/EtuStage_JEE/src/main/webapp/store/entreprise/"
				+ imageFileName;

		try {

			FileOutputStream fos = new FileOutputStream(uploadPath);
			InputStream is = file.getInputStream();

			byte[] data = new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			i = operations.checkUserEmail(email, "entreprise");
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (password.equals(repassword) && i == false) {
			entreprise entreprise=new entreprise(NomEntreprise, email, password, gsm, ville, imageFileName);
			try {
				registre.insertOnEntrepriseTable(entreprise);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}

	}

}
