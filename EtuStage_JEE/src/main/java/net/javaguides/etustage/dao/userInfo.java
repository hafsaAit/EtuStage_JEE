package net.javaguides.etustage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.etustage.model.annonce_entreprise;
import net.javaguides.etustage.model.annonce_stagaire;
//SELECT  St_image from annonce_stagaire JOIN stagaire WHERE annonce_stagaire.Id_Stag=stagaire.Id_Stag;
public class userInfo extends Connect {

	public ArrayList<annonce_stagaire> getStagaireAnnonce() throws SQLException, ClassNotFoundException {

		ArrayList<annonce_stagaire> listOfStagaireAnnonce = new ArrayList<>();
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql = "SELECT * from annonce_stagaire JOIN stagaire WHERE annonce_stagaire.Id_Stag=stagaire.Id_Stag";
		preparedStatement = this.connection().prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			listOfStagaireAnnonce.add(new annonce_stagaire(resultSet.getInt("Id_AnnSatg"),
					resultSet.getString("Titre_Stage"), resultSet.getString("Domaine_Stage"),
					resultSet.getString("Description"), resultSet.getString("Type_stage"),
					resultSet.getNString("Duree"), resultSet.getInt("Id_Stag"),resultSet.getString("St_image")));
		}
		return listOfStagaireAnnonce;
	}

	public ArrayList<annonce_entreprise> getEntrepriseeAnnonce() throws SQLException, ClassNotFoundException {

		ArrayList<annonce_entreprise> listOfEntrepriseAnnonce = new ArrayList<>();
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM annonce_entreprise";
		preparedStatement = this.connection().prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			listOfEntrepriseAnnonce.add(new annonce_entreprise(resultSet.getInt("Id_AnnEntp"),
					resultSet.getString("Titre"), resultSet.getString("domaine"), resultSet.getString("Description_Annc"),
					resultSet.getString("Duree"), resultSet.getString("Type_Stag"), resultSet.getInt("Id_Entrp")));
		}
		return listOfEntrepriseAnnonce;
	}
}
