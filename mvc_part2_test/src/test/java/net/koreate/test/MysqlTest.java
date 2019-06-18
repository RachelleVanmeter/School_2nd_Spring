package net.koreate.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class MysqlTest {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/mydata?serverTimezone=Asia/Seoul";
	String username = "java";
	String password = "java";

	@Test
	public void testConnection() {
		System.out.println("connection test");
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER 를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결 정보가 일치하지 않습니다.");
			e.printStackTrace();
		} finally {
			try { conn.close(); } catch (SQLException e) {}
		}
	}
}
