package jhong.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl;
		String user;
		String pass;
		Properties credentials = new Properties();
		try (FileReader in = new FileReader("credentials.properties")) {
			credentials.load(in);
			user = credentials.getProperty("username");
			pass = credentials.getProperty("password");
			jdbcUrl = credentials.getProperty("jdbcUrl");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connected to MySql!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
