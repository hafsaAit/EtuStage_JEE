package net.javaguides.etustage.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.etustage.dao.userOperations;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    // Récupérer l'email à partir de la requête
    String email = request.getParameter("email");

    // Vérifier si l'email existe dans la table "stagaire"
    boolean existsStag = false;
    try {
        userOperations dao = new userOperations();
        existsStag = dao.checkUserEmail(email, "stagaire");
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }

    // Vérifier si l'email existe dans la table "entreprise"
    boolean existsEntr = false;
    try {
        userOperations dao = new userOperations();
        existsEntr = dao.checkUserEmail(email, "entreprise");
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }

    // Envoyer une réponse en fonction de si l'email existe ou non
    if (existsStag || existsEntr) {
        response.getWriter().write("true");
    } else {
        response.getWriter().write("false");
    }
}

 protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Récupérer les informations de connexion
    String Email = request.getParameter("Email");
    String Password = request.getParameter("Password");

    // Vérifier si les informations(stagaire) de connexion sont correctes
    boolean isValidUser = false;
    try {
        userOperations dao = new userOperations();
        isValidUser = dao.checkStagWithId(Email, Password);
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    

    // Si les informations de connexion sont correctes, rediriger vers la page d'accueil
    if (isValidUser) {
        response.sendRedirect("Accueil.jsp");
    } else {
        // Si les informations de connexion ne sont pas correctes, renvoyer à la page de connexion avec un message d'erreur
        request.setAttribute("errorMessage", "Email ou mot de passe incorrect");
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
    
    
    
    
    //partie entreprise 
    
    // verifier les info (entreprise)
    
    boolean isValideUser = false;
    try {
        userOperations dao = new userOperations();
        isValideUser = dao.checkEntrpWithId(Email, Password);
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    
 // Si les informations de connexion sont correctes, rediriger vers la page d'accueil
    if (isValideUser) {
        response.sendRedirect("Accueil.jsp");
    } else {
        // Si les informations de connexion ne sont pas correctes, renvoyer à la page de connexion avec un message d'erreur
        request.setAttribute("errorMessage", "Email ou mot de passe incorrect");
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
    
}
}

