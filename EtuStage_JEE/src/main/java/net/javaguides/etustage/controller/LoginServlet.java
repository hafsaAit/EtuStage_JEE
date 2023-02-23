package net.javaguides.etustage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/webapp/welcome.jsp").forward(request, response);

	}



      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	      String Email = request.getParameter("Email");
	  
	      String Password = request.getParameter("Password");
	      

		
						HttpSession session = request.getSession();
						session.setAttribute("Password", Password);
						session.setAttribute("Email", Email);
						this.getServletContext().getRequestDispatcher("/AccueilServlet").forward(request, response);
						
						
					} 
}
	
