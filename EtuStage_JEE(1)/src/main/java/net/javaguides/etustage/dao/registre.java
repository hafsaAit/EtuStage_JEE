package net.javaguides.etustage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.javaguides.etustage.model.entreprise;
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

	public void insertOnEntrepriseTable(entreprise entp) throws SQLException, ClassNotFoundException {
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql = "INSERT INTO entreprise(NomEntreprise,Password,Email,GSM,Ville,St_image) VALUES(?,?,?,?,?,?);";
		preparedStatement = this.connection().prepareStatement(sql);
		preparedStatement.setString(1, entp.getNomEntreprise());
		preparedStatement.setString(2, entp.getPassword());
		preparedStatement.setString(3, entp.getEmail());
		preparedStatement.setString(4, entp.getGSM());
		preparedStatement.setString(5, entp.getVille());
		preparedStatement.setString(6, entp.getSt_image());
		preparedStatement.executeUpdate();

	}

}
