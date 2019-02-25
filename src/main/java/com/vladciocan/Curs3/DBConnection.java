package com.vladciocan.Curs3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnection {
	
	    private Connection connect = null;
	    private Statement statement = null;
	    private PreparedStatement preparedStatement = null;
	    private ResultSet resultSet = null;

	    public DBConnection() {
	    	 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory?"
	                            + "admin=admin&password=admin");
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    
	    public void selectExample(String dbTable) throws Exception {
	            statement = connect.createStatement();
	            resultSet = statement
	                    .executeQuery("select * from "+dbTable);
	            while(resultSet.next()) {
	            	String user = resultSet.getString("address1");
		            String adresa = resultSet.getString("address1");
		            System.out.println("Username : "+user+",Adress : "+adresa);
	            }
	            
	    }
	    
	    public void InsertExample(ArrayList<String> valori,String adresa,String dbTable) throws SQLException {
	    	String query="insert into "+dbTable+" values (";
	    	for(String s:valori) {
	    		query+=s+",";
	    	}
	    	String sintaxa="['###']'";
	    	query+=");";
	    	preparedStatement = connect
                    .prepareStatement("insert into "+dbTable+" values (?,?)");
            preparedStatement.setString(1, "Vlad");
            preparedStatement.setString(2, "Iasi");
            preparedStatement.executeUpdate();
            
	    }
	    
	    public void updateExample(String referinta,String adresa,String dbTable) throws SQLException {
	    	preparedStatement = connect
                    .prepareStatement("update "+dbTable+" set adresa=?,nume=?,sex=['val'] where username=?");
            preparedStatement.setString(1, adresa);
            preparedStatement.setString(2, referinta);
            preparedStatement.executeUpdate();
	    }
	    
	    public void deleteExample(String dbTable,String referinta) throws SQLException {
	    	 preparedStatement = connect
	 	            .prepareStatement("delete from "+dbTable+" where username= ? ; ");
	 	            preparedStatement.setString(1, referinta);
	 	            preparedStatement.executeUpdate();
	    }
	    

}
