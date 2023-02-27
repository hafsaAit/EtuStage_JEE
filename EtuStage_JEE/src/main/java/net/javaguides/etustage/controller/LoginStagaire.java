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


@WebServlet("/LoginStagaire")
public class LoginStagaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private userOperations operations;   
 
    public LoginStagaire() {
     this.operations=new userOperations();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("emailStg");
        String password = request.getParameter("passwordStg");
        
        try {
			if(operations.checkUserLogin(email, password, "stagaire")) {
				int id = operations.getUserId(email,"stagaire"); 
				HttpSession session = request.getSession();
				session.setAttribute("userEmail",email);
				session.setAttribute("type", "stagaire");
				session.setAttribute("id", id);
				response.sendRedirect("Accueil.jsp");
			}else {
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
	