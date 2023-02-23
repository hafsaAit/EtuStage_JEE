package net.javaguides.etustage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class registre extends userOperations {
	
	public registre() {
	
    }
	
	
	 public void insertOnStagaireTable(String Nom,String Prenom, String Email,
			 String Password, String GSM, String St_image) throws SQLException, ClassNotFoundException {
	        PreparedStatement preparedStatement;
	        ResultSet resultSet=null;
	        String sql="INSERT INTO stagaire(Nom,Prenom,Password,Email,GSM) VALUES(?,?,?,?);";
	        preparedStatement=this.connection().prepareStatement(sql);
	        preparedStatement.setString(1,Nom);
	        preparedStatement.setString(2,Prenom);
	        preparedStatement.setString(3,Email);
	        preparedStatement.setString(4,Password);
	        preparedStatement.setString(5,GSM);
	        preparedStatement.setString(5,St_image);
	        preparedStatement.executeUpdate();

	    }
	 
	 public void insertOnEntrepriseTable(String NomEntreprise, String Email,String Password,
			String Ville, String GSM, String St_image) throws SQLException, ClassNotFoundException {
	        PreparedStatement preparedStatement;
	        ResultSet resultSet=null;
	        String sql="INSERT INTO stagaire(Nom,Prenom,Password,Email,GSM) VALUES(?,?,?,?);";
	        preparedStatement=this.connection().prepareStatement(sql);
	        preparedStatement.setString(1,NomEntreprise);
	        preparedStatement.setString(2,Email);
	        preparedStatement.setString(3,Password);
	        preparedStatement.setString(4,Ville);
	        preparedStatement.setString(5,GSM);
	        preparedStatement.setString(5,St_image);
	        preparedStatement.executeUpdate();

	    }
	 
	 
	 
	 
	}


