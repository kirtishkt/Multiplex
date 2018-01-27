package multiplex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import multiplex.model.Halls;

public class HallDAO {

	private static String URL = "jdbc:mysql://localhost:3306/data";
	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String USER = "root";
	private static String PASS = "kt";
	Connection conn;

	private static String hallsql = "insert into HALLS values(?,?,?)";
	private static String showhallsql = "select hallid, halldesc,totalcapacity from HALLS where hallid = ?";
	private static String sqlseat = "insert into HALLCAPACITIES values(?,?,?,?)";

	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL, USER, PASS);
	}

	public void addHall(String hallid, String desc, String capacity) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();

		PreparedStatement ps = conn.prepareStatement(hallsql);
		ps.setString(1, hallid);
		ps.setString(2, desc);
		ps.setString(3, capacity);
		ps.executeUpdate();

	}

	public Halls showHall(String hallid) throws SQLException {
		// TODO Auto-generated method stub
		
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(showhallsql);
			ps.setDouble(1, Double.parseDouble(hallid));
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next())
			{
				Halls h = new Halls(Integer.parseInt(hallid), resultSet.getString("halldesc"), resultSet.getInt("totalCapacity"));
				return h;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return null;
		
	}
	public  void addSeat(int hallid,String seatdesc,int seatcount,int seatfare)
	{
		try {
			conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sqlseat);
			statement.setInt(1,hallid);
			statement.setString(2,seatdesc);
			statement.setInt(3,seatcount);
			statement.setInt(4,seatfare);
			statement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
