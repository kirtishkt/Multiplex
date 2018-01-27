package multiplex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import multiplex.model.Users;

public class UserDAO {

	private static String  URL = "jdbc:mysql://localhost:3306/data";
	private static String DRIVER ="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static String PASS="kt";
	Connection conn;
	
	private static String usersql = "select userid,username,usertype,mobileno,emailid from USERS where username = ? and userid=?" ;
	private static String adduser = "insert into USERS values(default,?,'U',?,?)";
	private static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL, USER, PASS);
	}
	public Users getUser(String username, String password)
	{

		Users user =  new Users();
		try {
			conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(usersql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next())
			{
				
					user.setUserId(resultSet.getInt("userid"));
					user.setEmailId(resultSet.getString("emailid"));
					user.setMobileNo(resultSet.getString("mobileno"));
					user.setPassword(password);
					user.setUserName(username);
					user.setUserType(resultSet.getString("usertype").charAt(0));
					
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return user;
		
	}
	public void addUser(String username, String mobile, String email) {
		// TODO Auto-generated method stub
		try {
			conn =getConnection();
			PreparedStatement statement = conn.prepareStatement(adduser);
			statement.setString(1, username);
			statement.setString(2, mobile);
			statement.setString(3, email);
			statement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
