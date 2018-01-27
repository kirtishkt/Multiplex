package multiplex.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MultiplexUtil {
	
	private static String  URL = "jdbc:mysql://localhost:3306/data";
	private static String DRIVER ="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static String PASS="kt";

	private static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL, USER, PASS);
	}
}
