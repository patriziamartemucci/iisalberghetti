import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.sql.SQLException;
import java.util.Properties;

public class ResourceManager {
	private static String JDBC_DRIVER = "org.postgresql.Driver";

	private static String JDBC_USER = "";
	private static String JDBC_PASSWORD = "";
	private static String JDBC_PASSWORDP12 = "";
	private static String JDBC_DBADDRESS = "";
	private static String JDBC_DBPORT = "";
	private static String JDBC_DBNAME = "";


	private static Driver driver = null;

	public static synchronized Connection getConnection() throws SQLException {
	
		if (driver == null) {
			try {
				Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
				driver = (Driver) jdbcDriverClass.newInstance();
				DriverManager.registerDriver(driver);
			} catch (Exception e) {
				System.out.println("Failed to initialise JDBC driver");
				e.printStackTrace();
			}
		}
		
		readConfiguration();
		Properties props = new Properties();
		props.setProperty("user", JDBC_USER);
		props.setProperty("ssl", "true");
		props.setProperty("sslfactory", "CertAuthFactory");
		props.setProperty("sslfactoryarg", JDBC_PASSWORDP12+","+JDBC_PASSWORD);
		System.out.println("jdbc:postgresql:" + "//" + JDBC_DBADDRESS +":"+JDBC_DBPORT+ "/" + JDBC_DBNAME);
		String JDBC_URL = "jdbc:postgresql:" + "//" + JDBC_DBADDRESS +":"+JDBC_DBPORT+ "/" + JDBC_DBNAME;

		return DriverManager.getConnection(JDBC_URL, props);
	}

	public static void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public static void close(PreparedStatement stmt) {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}

	public static void setPassword(String password, String passwordP12) {
		// TODO Auto-generated method stub
		JDBC_PASSWORD = password;
		JDBC_PASSWORDP12 = passwordP12;
	}

	public static void readConfiguration() {
		try {
			Properties configFile = new Properties();
			String nomeFile="./server.properties";
			configFile.load(new FileInputStream(nomeFile));

			JDBC_DBPORT = configFile.getProperty("DB_PORT").trim();
			JDBC_DBADDRESS = configFile.getProperty("DB_IP").trim();
			JDBC_DBNAME = configFile.getProperty("DB_NAME").trim();
			JDBC_USER=configFile.getProperty("DB_USER").trim();
		
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());

		} finally {
		}
	}
}
