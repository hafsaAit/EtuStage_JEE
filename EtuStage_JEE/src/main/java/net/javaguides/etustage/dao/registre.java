package net.javaguides.etustage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.javaguides.etustage.model.stagaire;

public class registre extends userOperations {

	public registre() {

	}

	public void insertOnStagaireTable(stagaire stg) throws SQLException, ClassNotFoundException {
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql = "INSERT INTO stagaire(Nom,Prenom,Password,Email,GSM,St_image) VALUES(?,?,?,?,?,?);";
		preparedStatement = this.connection().prepareStatement(sql);
		preparedStatement.setString(1, stg.getNom());
		preparedStatement.setString(2, stg.getPrenom());
		preparedStatement.setString(3, stg.getPassword());
		preparedStatement.setString(4, stg.getEmail());
		preparedStatement.setString(5, stg.getGSM());
		preparedStatement.setString(6, stg.getSt_image());
		preparedStatement.executeUpdate();

	}

	public void insertOnEntrepriseTable(String NomEntreprise, String Email, String Password, String Ville, String GSM,
			String St_image) throws SQLException, ClassNotFoundException {
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql = "INSERT INTO stagaire(Nom,Prenom,Password,Email,GSM) VALUES(?,?,?,?);";
		preparedStatement = this.connection().prepareStatement(sql);
		preparedStatement.setString(1, NomEntreprise);
		preparedStatement.setString(2, Email);
		preparedStatement.setString(3, Password);
		preparedStatement.setString(4, Ville);
		preparedStatement.setString(5, GSM);
		preparedStatement.setString(5, St_image);
		preparedStatement.executeUpdate();

	}

}
