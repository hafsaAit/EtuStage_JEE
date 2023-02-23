package net.javaguides.etustage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	

}
