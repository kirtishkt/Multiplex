package multiplex.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import multiplex.model.Halls;
import multiplex.model.Shows;

public class MovieDAO {


	private static String URL = "jdbc:mysql://localhost:3306/data?autoReconnect=true&useSSL=false";
	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String USER = "root";
	private static String PASS = "kt";
	Connection conn;

	private static String sql = "insert into MOVIES values(default,?)";
	private static String showmovie = "select s.showid,s.hallid,s.movieid,s.slotno,s.fromdate,s.todate from SHOWS s,MOVIES m where s.movieid = m.movieid and m.moviename = ?";
	private static String sqladdshow = "insert into SHOWS values(DEFAULT,?,?,?,?,?)";
	private static String moviesql = "";

	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL, USER, PASS);
	}

	public void addMovie(String movie)  {
		
		try {
			conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, movie);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, movie);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public ArrayList<Shows> showMovie(String movie)
	{
		ArrayList<Shows> showlist = new ArrayList<>();
		try {
			conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(showmovie);
			statement.setString(1,showmovie);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				showlist.add(new Shows(resultSet.getInt("showid"),resultSet.getInt("hallid"),
						resultSet.getInt("movieid"), resultSet.getInt("slotno"), 
						resultSet.getDate("fromdate"), resultSet.getDate("todate")));
			}
			return showlist;
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void addShow(String hallid,String movieid,String slotno,String from,String to)
	{
		try {
			conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sqladdshow);
			statement.setInt(1, Integer.parseInt(hallid));
			statement.setInt(2, Integer.parseInt(movieid));
			statement.setInt(3, Integer.parseInt(slotno));
			statement.setString(4, from);
			statement.setString(5, to);
			statement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}
	

