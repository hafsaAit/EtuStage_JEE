package net.javaguides.etustage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends userOperations{
	
	public Login() {
    }

	public boolean ChekLoginInfo(String Email,String Password, String type) throws SQLException, ClassNotFoundException {

        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="SELECT Email FROM "+ type+ " WHERE Email=? AND Password=?;";
        preparedStatement=this.connection().prepareStatement(sql);
        preparedStatement.setString(1,Email);
        preparedStatement.setString(2,Password);
        resultSet=  preparedStatement.executeQuery();

        return resultSet.next();
           
    };
    
    public int getStagaireId(String Email,String Password) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="SELECT Id_Stag FROM stagaire  WHERE Email=? AND Password=? ;";
        preparedStatement=this.connection().prepareStatement(sql);
        preparedStatement.setString(1,Email);
        preparedStatement.setString(2,Password);
        resultSet=  preparedStatement.executeQuery();
        
        if (!resultSet.next()){
            return 0;
        }
        return  resultSet.getInt(1);
    };

    public int getEntrepiseId(String Email,String Password) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement;
        ResultSet resultSet=null;
        String sql="SELECT Id_Stag FROM entreprise  WHERE Email=? AND Password=? ;";
        preparedStatement=this.connection().prepareStatement(sql);
        preparedStatement.setString(1,Email);
        preparedStatement.setString(2,Password);
        resultSet=  preparedStatement.executeQuery();
        
        if (!resultSet.next()){
            return 0;
        }
        return  resultSet.getInt(1);
    };


}
