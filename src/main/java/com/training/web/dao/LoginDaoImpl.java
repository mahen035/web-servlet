package com.training.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.web.model.User;

public class LoginDaoImpl implements LoginDao{

	@Override
	public List<User> getUsers() {
		
		 List<User> userList = new ArrayList<>();
		 Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 
	        //Scanner sc = new Scanner(System.in);
	        String url = "jdbc:mysql://localhost:3306/infinite";
	        String user = "root";
	        String pass = "pass123";
	        con = DriverManager.getConnection(url,user,pass);
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("select * from user1");
	        while(rs.next()) {
	          	userList.add(new User(rs.getString(1), rs.getString(2)));
	        	
	        }
	       
		 }  
	        catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return userList;
	}

}
