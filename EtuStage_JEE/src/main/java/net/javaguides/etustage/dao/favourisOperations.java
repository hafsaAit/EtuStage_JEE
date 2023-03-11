package net.javaguides.etustage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.javaguides.etustage.model.annonce_stagaire;
import net.javaguides.etustage.model.favouris_entreprise;
import net.javaguides.etustage.model.favouris_stagaire;

public class favourisOperations extends Connect {

	public boolean checkStagaireAnnonceisFavourite(int annonceId) throws SQLException, ClassNotFoundException {

		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql = "SELECT *  FROM favouris_entreprise  WHERE id_AnnStag=?;";
		preparedStatement = this.connection().prepareStatement(sql);
		preparedStatement.setInt(1, annonceId);
		resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}

	public boolean checkEntrepriseAnnonceisFavourite(int annonceId) throws SQLException, ClassNotFoundException {

		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql = "SELECT *  FROM favouris_stagaire  WHERE id_AnnEntrp=?;";
		preparedStatement = this.connection().prepareStatement(sql);
		preparedStatement.setInt(1, annonceId);
		resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}

	public void addAnnonceStagaireToFavouris(int id_Entrp, int id_AnnStag) throws SQLException, ClassNotFoundException {
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql = "INSERT INTO favouris_entreprise(id_Entrp,id_AnnStag) VALUES(?,?);";
		preparedStatement = this.connection().prepareStatement(sql);
		preparedStatement.setInt(1, id_Entrp);
		preparedStatement.setInt(2, id_AnnStag);
		preparedStatement.executeUpdate();

	}

	public void addAnnonceEntrepriseToFavouris(int id_Stag, int id_AnnEntrp)
			throws SQLException, ClassNotFoundException {
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql = "INSERT INTO favouris_stagaire(id_Stag,id_AnnEntrp) VALUES(?,?);";
		preparedStatement = this.connection().prepareStatement(sql);
		preparedStatement.setInt(1, id_Stag);
		preparedStatement.setInt(2, id_AnnEntrp);
		preparedStatement.executeUpdate();

	}

	public ArrayList<favouris_stagaire> getFavourisStagaire() throws SQLException, ClassNotFoundException {

		ArrayList<favouris_stagaire> listOfFavoriteStagaire = new ArrayList<>();
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql = "SELECT * from favouris_stagaire JOIN annonce_stagaire WHERE favouris_stagaire.Id_Stag=annonce_stagaire.Id_Stag";
		preparedStatement = this.connection().prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			listOfFavoriteStagaire.add(new favouris_stagaire(resultSet.getInt("Id_fav"), resultSet.getInt("Id_Stag"),
					resultSet.getInt("Id_AnnEntp")));

		}
		return listOfFavoriteStagaire;
	}

	public ArrayList<annonce_stagaire> getFavourisEntreprise(int id_Entrp) throws SQLException, ClassNotFoundException {

		ArrayList<annonce_stagaire> listOfFavoriteEntreprise = new ArrayList<>();
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql = "SELECT * from favouris_entreprise JOIN annonce_stagaire JOIN stagaire WHERE favouris_entreprise.Id_Entrp=? AND favouris_entreprise.id_AnnStag=annonce_stagaire.Id_AnnSatg AND annonce_stagaire.Id_Stag=stagaire.Id_Stag;";
		preparedStatement = this.connection().prepareStatement(sql);
		preparedStatement.setInt(1, id_Entrp);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			listOfFavoriteEntreprise.add(new annonce_stagaire(resultSet.getInt("Id_AnnSatg"),
					resultSet.getString("Titre_Stage"), resultSet.getString("Domaine_Stage"),
					resultSet.getString("Description"), resultSet.getString("Type_stage"),
					resultSet.getNString("Duree"), resultSet.getInt("Id_Stag"), resultSet.getString("St_image")));

		}
		return listOfFavoriteEntreprise;
	}

	public void deleteAnnonceStag(int id_Stag, int id_AnnEntrp) throws SQLException, ClassNotFoundException {
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql = "DELETE FROM  favouris_stagaire WHERE  favouris_stagaire.Id_Stag = ? AND favouris_stagaire.id_AnnEntrp  = ?";
		preparedStatement = this.connection().prepareStatement(sql);
		preparedStatement.setInt(1, id_Stag);
		preparedStatement.setInt(2, id_AnnEntrp);

		preparedStatement.executeUpdate();
	}

	public void deleteAnnonceEntrp(int id_Entrp, int id_AnnStag) throws SQLException, ClassNotFoundException {
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql = "DELETE FROM  favouris_entreprise WHERE  favouris_entreprise.Id_Entrp =? and favouris_entreprise.id_AnnStag  =? ";
		preparedStatement = this.connection().prepareStatement(sql);
		preparedStatement.setInt(1, id_Entrp);
		preparedStatement.setInt(2, id_AnnStag);

		preparedStatement.executeUpdate();

	}
}
