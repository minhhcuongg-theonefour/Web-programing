package web.group6.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import config.App;
public class JDBCConnection {

	public static Connection getJDBCConnection() {
		Connection con = null;
		try {
			Class.forName(App.dbDriver);
			con =  DriverManager.getConnection(App.dbUrl, App.dbUname, App.dbPass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return con;
	}
}
