package net.javaguides.etustage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.etustage.model.annonce_entreprise;
import net.javaguides.etustage.model.annonce_stagaire;
import net.javaguides.etustage.model.entreprise;
import net.javaguides.etustage.model.stagaire;

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
					resultSet.getNString("Duree"), resultSet.getInt("Id_Stag"), resultSet.getString("St_image")));
		}
		return listOfStagaireAnnonce;
	}

	public ArrayList<annonce_entreprise> getEntrepriseeAnnonce() throws SQLException, ClassNotFoundException {

		ArrayList<annonce_entreprise> listOfEntrepriseAnnonce = new ArrayList<>();
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM annonce_entreprise JOIN entreprise WHERE annonce_entreprise.Id_Entrp=entreprise.Id_Entrp";
		preparedStatement = this.connection().prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			listOfEntrepriseAnnonce.add(new annonce_entreprise(resultSet.getInt("Id_AnnEntp"),
					resultSet.getString("Titre"), resultSet.getString("domaine"),
					resultSet.getString("Description_Annc"), resultSet.getString("Duree"),
					resultSet.getString("Type_Stag"), resultSet.getInt("Id_Entrp"), resultSet.getString("St_image")));
		}
		return listOfEntrepriseAnnonce;
	}

	public stagaire getStagaireInfo(int id) throws SQLException, ClassNotFoundException {

		stagaire stagaireInfo = new stagaire();
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM stagaire where Id_Stag=?";
		preparedStatement = this.connection().prepareStatement(sql);
		preparedStatement.setInt(1, id);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			stagaireInfo = new stagaire(resultSet.getInt("Id_Stag"), resultSet.getString("Nom"),
					resultSet.getString("Prenom"), resultSet.getString("Password"), resultSet.getString("Email"),
					resultSet.getString("GSM"), resultSet.getString("St_image"));
		}
		return stagaireInfo;
	}

	public entreprise getEntrepriseInfo(int id) throws SQLException, ClassNotFoundException {

		entreprise entrepriseInfo = new entreprise();
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM entreprise where Id_Entrp=?";
		preparedStatement = this.connection().prepareStatement(sql);
		preparedStatement.setInt(1, id);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			entrepriseInfo = new entreprise(resultSet.getInt("Id_Entrp"), resultSet.getString("NomEntreprise"),
					resultSet.getString("Email"), resultSet.getString("Password"), resultSet.getString("GSM"),
					resultSet.getString("Ville"), resultSet.getString("St_image"));
		}
		return entrepriseInfo;
	}

	public ArrayList<annonce_entreprise> getEntrepriseMesAnnonce(int id) throws SQLException, ClassNotFoundException {

		ArrayList<annonce_entreprise> listOfEntrepriseAnnonce = new ArrayList<>();
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM annonce_entreprise JOIN entreprise WHERE  annonce_entreprise.Id_Entrp=? AND annonce_entreprise.Id_Entrp=entreprise.Id_Entrp";
		preparedStatement = this.connection().prepareStatement(sql);
		preparedStatement.setInt(1, id);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			listOfEntrepriseAnnonce.add(new annonce_entreprise(resultSet.getInt("Id_AnnEntp"),
					resultSet.getString("Titre"), resultSet.getString("domaine"),
					resultSet.getString("Description_Annc"), resultSet.getString("Duree"),
					resultSet.getString("Type_Stag"), resultSet.getInt("Id_Entrp"), resultSet.getString("St_image")));
		}
		return listOfEntrepriseAnnonce;
	}

	public ArrayList<annonce_stagaire> getStagaireMesAnnonce(int id) throws SQLException, ClassNotFoundException {

		ArrayList<annonce_stagaire> listOfStagaireAnnonce = new ArrayList<>();
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM annonce_stagaire JOIN stagaire WHERE  annonce_stagaire.Id_Stag=? AND annonce_stagaire.Id_Stag=stagaire.Id_Stag";
		preparedStatement = this.connection().prepareStatement(sql);
		preparedStatement.setInt(1, id);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			listOfStagaireAnnonce.add(new annonce_stagaire(resultSet.getInt("Id_AnnSatg"),
					resultSet.getString("Titre_Stage"), resultSet.getString("Domaine_Stage"),
					resultSet.getString("Description"), resultSet.getString("Type_stage"),
					resultSet.getNString("Duree"), resultSet.getInt("Id_Stag"), resultSet.getString("St_image")));
		}
		return listOfStagaireAnnonce;
	}

	
	public annonce_stagaire getAnnonceStagaireInfo(int id) throws SQLException, ClassNotFoundException {

		annonce_stagaire stg = new annonce_stagaire();
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM annonce_stagaire where Id_AnnSatg=?";
		preparedStatement = this.connection().prepareStatement(sql);
		preparedStatement.setInt(1, id);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			stg = new annonce_stagaire(resultSet.getInt("Id_AnnSatg"), resultSet.getString("Titre_Stage"),
					resultSet.getString("Domaine_Stage"), resultSet.getString("Description"),
					resultSet.getString("Type_stage"), resultSet.getString("Duree"), resultSet.getInt("Id_Stag"));
		}
		return stg;
	}

	public annonce_entreprise getAnnonceEntrepriseInfo(int id) throws SQLException, ClassNotFoundException {

		annonce_entreprise entp = new annonce_entreprise();
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM annonce_entreprise where Id_AnnEntp=?";
		preparedStatement = this.connection().prepareStatement(sql);
		preparedStatement.setInt(1, id);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			entp = new annonce_entreprise(resultSet.getInt("Id_AnnEntp"), resultSet.getString("Titre"),
					resultSet.getString("domaine"), resultSet.getString("Description_Annc"),
					resultSet.getString("Duree"), resultSet.getString("Type_Stag"), resultSet.getInt("Id_Entrp"));
		}
		return entp;
	}
}
