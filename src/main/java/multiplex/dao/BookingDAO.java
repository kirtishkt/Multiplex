package multiplex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class BookingDAO {


	private static String  URL = "jdbc:mysql://localhost:3306/data";
	private static String DRIVER ="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static String PASS="kt";
	Connection conn;
	
	private static String booking= "insert into BOOKINGS values(default,?,?,?,?,?,?)";
	private static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL, USER, PASS);
	}
	public void addBooking(String showid, int userId, Date date, String date2, String seattype, String seatcount) {
		// TODO Auto-generated method stub
		
		try {
			conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(booking);
			statement.setString(1, showid);
			statement.setInt(2, userId);
			statement.setDate(3, new java.sql.Date(date.getTime()));
			statement.setString(4, date2);
			statement.setString(5, seattype);
			statement.setString(6, seatcount);
			statement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
