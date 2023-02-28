package net.javaguides.etustage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.javaguides.etustage.model.annonce_entreprise;
import net.javaguides.etustage.model.entreprise;
import net.javaguides.etustage.model.stagaire;

public class userOperations extends Connect  {
	
	
	public boolean checkUserEmail(String Email,String table) throws SQLException, ClassNotFoundException {

        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="SELECT Email FROM " +table+" WHERE Email=?;";
        preparedStatement=this.connection().prepareStatement(sql);
        preparedStatement.setString(1,Email);
        resultSet=  preparedStatement.executeQuery();
        return resultSet.next();
    }
	
	public boolean checkStagWithId(String Email,String table) throws SQLException, ClassNotFoundException {

        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="SELECT Email FROM " +table+" WHERE Email=? AND Id_Stag=?;";
        preparedStatement=this.connection().prepareStatement(sql);
        preparedStatement.setString(1,Email);
        preparedStatement.setInt(2, stagaire.getId_Stag());
        resultSet=  preparedStatement.executeQuery();
        return resultSet.next();
    }
	
	public boolean checkEntrpWithId(String Email,String table) throws SQLException, ClassNotFoundException {

        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="SELECT Email FROM " +table+" WHERE Email=? AND Id_Stag=?;";
        preparedStatement=this.connection().prepareStatement(sql);
        preparedStatement.setString(1,Email);
        preparedStatement.setInt(2, entreprise.getId_Entrp());
        resultSet=  preparedStatement.executeQuery();
        return resultSet.next();
    }

	
	public boolean checkUserLogin(String Email,String Password,String table) throws SQLException, ClassNotFoundException {

        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="SELECT Email FROM " +table+" WHERE Email=? AND Password=?;";
        preparedStatement=this.connection().prepareStatement(sql);
        preparedStatement.setString(1,Email);
        preparedStatement.setString(2,Password);
        resultSet=  preparedStatement.executeQuery();
        return resultSet.next();
    }
	
	public int getUserId(String Email,String table) throws SQLException, ClassNotFoundException {

        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="SELECT * FROM "+ table +" WHERE Email=?;";
        preparedStatement=this.connection().prepareStatement(sql);
        preparedStatement.setString(1,Email);
        resultSet=  preparedStatement.executeQuery();
        if (!resultSet.next()){
            return 0;
        }
        return  resultSet.getInt(1);
    }
	
	public void AddAnnonceEntreprise(annonce_entreprise anEntp) throws SQLException, ClassNotFoundException {
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql = "INSERT INTO annonce_entreprise(Titre,Description_Annc	,Duree,Type_Stag,Id_Entrp) VALUES(?,?,?,?,?);";
		preparedStatement = this.connection().prepareStatement(sql);
		preparedStatement.setString(1, anEntp.getTitre());
		preparedStatement.setString(2, anEntp.getDescription_Annc());
		preparedStatement.setString(3, anEntp.getDuree());
		preparedStatement.setString(4, anEntp.getType_Stag());
		preparedStatement.setInt(5, anEntp.getId_Entrp());
		preparedStatement.executeUpdate();

	}

}
