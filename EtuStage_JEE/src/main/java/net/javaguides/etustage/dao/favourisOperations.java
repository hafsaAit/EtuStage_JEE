package net.javaguides.etustage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



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
	
	public void deleteAnnonceStag(int id_Stag) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="DELETE FROM  favouris_stagaire WHERE  favouris_stagaire.Id_stag = id_fav ;";
        preparedStatement = this.connection().prepareStatement(sql);
		preparedStatement.setInt(1, id_Stag);
		

		resultSet = preparedStatement.executeQuery();
		
		
	}
	
	public void deleteAnnonceEntrp(int id_Entrp) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="DELETE FROM  favouris_entreprise WHERE  favouris_entreprise.Id_Entrp = id_Entrp;";
        preparedStatement = this.connection().prepareStatement(sql);
		preparedStatement.setInt(1, id_Entrp);

		resultSet = preparedStatement.executeQuery();
		
		
	}
	
}
