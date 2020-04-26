package DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

	public static final String DB_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String DB_NAME = "TallerMecanico";
	public static final String DB_HOST = "localhost";
	public static final String DB_PORT = "1433";

	public static final String DB_URL = "jdbc:sqlserver://" + DB_HOST + ";databaseName=" + DB_NAME
			+ ";integratedSecurity=true";

	private static DBManager instance;

	private DBManager() {
	}

	public static DBManager getInstace() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

	public Connection connect() {
		Connection c = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			c = DriverManager.getConnection(DB_URL);
			c.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		return c;
	}

	public void shutdown() throws Exception {
		Connection c = connect();
		Statement s = c.createStatement();
		s.execute("SHUTDOWN");
		c.close();
	}
}
