package com.servlet.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.servlet.exceptions.LoginException;
import com.servlet.model.Student;

public class DaoImplementation {

	private String jdbcUrl = "jdbc:h2:D:\\\\sugam./test";
	private String jdbcUserName = "sugam";
	private String jdbcPassword = "sugam";

	public DaoImplementation() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection(jdbcUrl, jdbcUserName, jdbcPassword);
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database :" + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public Student login(String userName, String password) throws SQLException, LoginException {
		Student stud = null;
		String query = "SELECT * FROM TEST WHERE USERNAME=? AND PASSWORD = ?";
//		String specialCharacters = "/^[@]$/";
		try (Connection connection = getConnection(); 
			PreparedStatement prepare = connection.prepareStatement(query);) {
			if (userName == null || userName.length() == 0 || userName.equals(" ")) {
			throw new LoginException("fill the require details");
			} else if (password==null){
			throw new LoginException("password should contain one special characters");
			}
			prepare.setString(1, userName);
			prepare.setString(2, password);
			
			ResultSet rs = prepare.executeQuery();
			System.out.println(prepare);
			while (rs.next()) {
				stud = new Student();
				stud.setUserName(rs.getString("userName"));
				stud.setPassword(rs.getString("password"));
			}
			if(stud!=null) {
			throw new LoginException("User not found");
			}
		} catch (SQLException e) {
			System.out.println("Error while getting logged in :" + e.getMessage());
		}
		return stud;
	}

	public boolean registerUser(Student stud) {
		boolean result = false;
		String query = "INSERT INTO TEST(USERNAME,PASSWORD,ADDRESS,EMAILID,CONTACTNO) VALUES(?,?,?,?,?);";
		try (Connection connection = getConnection(); PreparedStatement prepare = connection.prepareStatement(query);) {
			
			prepare.setString(1, stud.getUserName());
			prepare.setString(2, stud.getPassword());
			prepare.setString(3, stud.getAddress());
			prepare.setString(4, stud.getEmailId());
			prepare.setString(5, stud.getContactNo());
			System.out.println(prepare);
			prepare.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error to insert the data" + e.getMessage());
		}
		return result;
	}
	public int updateUser(Student stud) {
		int rowUpdated=0;
		String query="update TEST set PASSWORD=?,ADDRESS=?,EMAILID=?,CONTACTNO=? where USERNAME=?";	
		try (Connection connection=getConnection(); 
				PreparedStatement preparedStatement=connection.prepareStatement(query);){
			
			preparedStatement.setString(1, stud.getPassword());
			preparedStatement.setString(2, stud.getAddress());
			preparedStatement.setString(3, stud.getEmailId());
			preparedStatement.setString(4, stud.getContactNo());
			preparedStatement.setString(5, stud.getUserName());
			rowUpdated=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error while updating the data "+e.getMessage());
		}
		return rowUpdated;
	}
	public int deleteUser(Student stud) {
		int rowDeleted=0;
		String query="delete from TEST where userName = ?";	
		try (Connection connection=getConnection(); 
				PreparedStatement preparedStatement=connection.prepareStatement(query);){
			preparedStatement.setString(1, stud.getUserName());
			rowDeleted=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error while updating the data "+e.getMessage());
		}
		return rowDeleted;
	}
}
