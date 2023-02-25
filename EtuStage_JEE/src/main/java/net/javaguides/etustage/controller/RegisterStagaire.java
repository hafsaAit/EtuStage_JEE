package net.javaguides.etustage.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ProcessBuilder.Redirect;
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
import net.javaguides.etustage.model.stagaire;

@MultipartConfig
@WebServlet("/RegisterStagaire")
public class RegisterStagaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private registre registre;
	private userOperations operations;

	public RegisterStagaire() {
		this.registre = new registre();
		this.operations = new userOperations();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean i = false;

		String prenom = request.getParameter("FirstnameSignUpStg");
		String nom = request.getParameter("LastnameSignUpStg");
		String password = request.getParameter("passSignUpStg");
		String repassword = request.getParameter("RepassSignUpStg");
		String email = request.getParameter("emailSignUpStg");
		String gsm = request.getParameter("mobileSignUpStg");
		Part file = request.getPart("myfile");
		String imageFileName = file.getSubmittedFileName();

		String uploadPath = "C:/Users/moude/eclipse-workspace/EtuStage_JEE/EtuStage_JEE/src/main/webapp/store/stagaire/"
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
			i = operations.checkUserEmail(email, "stagaire");
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (password.equals(repassword) && i == false) {
			stagaire stagaire = new stagaire(nom, prenom, password, email, gsm, imageFileName);
			try {
				registre.insertOnStagaireTable(stagaire);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}

	}

}
