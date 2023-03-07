package net.javaguides.etustage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.etustage.model.favouris_entreprise;
import net.javaguides.etustage.model.favouris_stagaire;


public class favourisOperations extends Connect {
	public ArrayList<favouris_stagaire> getFavourisStagaire() throws SQLException, ClassNotFoundException {

		ArrayList<favouris_stagaire> listOfFavoriteStagaire = new ArrayList<>();
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql = "SELECT * from favouris_stagaire JOIN annonce_stagaire WHERE favouris_stagaire.Id_Stag=annonce_stagaire.Id_Stag";
		preparedStatement = this.connection().prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			listOfFavoriteStagaire.add(new favouris_stagaire(resultSet.getInt("Id_fav"),
					resultSet.getInt("Id_Stag"), resultSet.getInt("Id_AnnEntp")));
					
		}
		return listOfFavoriteStagaire;
	}

	
	public ArrayList<favouris_entreprise> getFavourisEntreprise() throws SQLException, ClassNotFoundException {

		ArrayList<favouris_entreprise> listOfFavoriteEntreprise = new ArrayList<>();
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql = "SELECT * from favouris_entreprise JOIN annonce_entreprise WHERE favouris_entreprise.Id_Entrp=annonce_entreprise.Id_Entrp";
		preparedStatement = this.connection().prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			listOfFavoriteEntreprise.add(new favouris_entreprise(resultSet.getInt("Id_fav"),
					resultSet.getInt("Id_Entrp"), resultSet.getInt("Id_AnnStag")));
					
		}
		return listOfFavoriteEntreprise;
	}
	
	
		
	
	public void deleteAnnonceStag(int id_Stag, int id_fav) throws SQLException, ClassNotFoundException {
	    PreparedStatement preparedStatement;
	    ResultSet resultSet=null;
	    String sql="DELETE FROM  favouris_stagaire WHERE  favouris_stagaire.Id_stag = ? AND favouris_stagaire.Id_fav = ?";
	    preparedStatement = this.connection().prepareStatement(sql);
	    preparedStatement.setInt(1, id_Stag);
	    preparedStatement.setInt(2, id_fav);

	    preparedStatement.executeUpdate();
	}

	
	public void deleteAnnonceEntrp(int id_Entrp, int id_fav) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="DELETE FROM  favouris_entreprise WHERE  favouris_entreprise.Id_Entrp =? and favouris_entreprise.id_fav =? ";
        preparedStatement = this.connection().prepareStatement(sql);
		preparedStatement.setInt(1, id_Entrp);
		preparedStatement.setInt(2, id_fav);

		preparedStatement.executeUpdate();
		
		
	}
	
	//récupère la liste des annonces favorites pour un utilisateur spécifique
	
	public List<Integer> getFavoris(int id_Stag) throws SQLException, ClassNotFoundException {
	    PreparedStatement preparedStatement;
	    ResultSet resultSet=null;
	    List<Integer> favoris = new ArrayList<Integer>();
	    String sql="SELECT Id_fav FROM favouris_stagaire WHERE Id_stag = ?";
	    preparedStatement = this.connection().prepareStatement(sql);
	    preparedStatement.setInt(1, id_Stag);

	    resultSet = preparedStatement.executeQuery();
	    while (resultSet.next()) {
	        favoris.add(resultSet.getInt("Id_fav"));
	    }
	    return favoris;
	}
	
	public List<Integer> getFavorisEntrp (int id_Entrp) throws SQLException, ClassNotFoundException {
	    PreparedStatement preparedStatement;
	    ResultSet resultSet=null;
	    List<Integer> favoris = new ArrayList<Integer>();
	    String sql="SELECT Id_fav FROM favouris_entreprise WHERE Id_Entrp = ?";
	    preparedStatement = this.connection().prepareStatement(sql);
	    preparedStatement.setInt(1, id_Entrp);

	    resultSet = preparedStatement.executeQuery();
	    while (resultSet.next()) {
	        favoris.add(resultSet.getInt("Id_fav"));
	    }
	    return favoris;
	}

	
}
