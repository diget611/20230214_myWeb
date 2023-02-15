package kh.common.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTemplate {
	
	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KH", "KH");
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(conn != null) System.out.println("DB 연결 성공");
		else System.out.println("DB 연결 실패");
		
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
