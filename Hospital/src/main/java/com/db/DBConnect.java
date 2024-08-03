package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	private static Connection conn;

	public static Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitals?charEncoding=utf8","root","");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

}

/*
 * package com.db;
 * 
 * import java.sql.Connection; import java.sql.DriverManager;
 * 
 * public class DBConnect {
 * 
 * private static Connection conn;
 * 
 * public static Connection getConn() { try {
 * Class.forName("com.mysql.jdbc.Driver"); String
 * url="jdbc:mysql://localhost:3306/hospitals?charEncoding=utf8";
 * conn=DriverManager.getConnection(url,"root",""); System.out.println(conn);
 * 
 * 
 * } catch (Exception e) { e.printStackTrace(); }
 * 
 * return conn; }
 * 
 * }
 */

