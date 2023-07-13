package com.nt.utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static Connection con = null;
	static {
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/sys?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "12345678" );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		return con;
	}
}
