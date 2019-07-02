package net.koreate.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:context/root/root-context.xml",
	"classpath:context/root/security/security-context.xml"
})
public class DataSourceTest {
	
	@Inject
	DataSource ds;
	
	@Inject
	PasswordEncoder encoder;
	
	//@Test
	public void testInsert() {
		System.out.println("datasource : " + ds);
		
		/*System.out.println("password encode : " + encoder.encode("member"));*/
		
		String sql = "INSERT INTO security_member(uid, upw, uname) VALUES(?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			for (int i = 0; i <= 100; i++) {
				pstmt.setString(2, encoder.encode("pw" + i));
				
				if (i < 80) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(3, "일반사용자" + i);
				} else if (i < 90) {
					pstmt.setString(1, "manager" + i);
					pstmt.setString(3, "운영자" + i);
				} else {
					pstmt.setString(1, "admin" + i);
					pstmt.setString(3, "관리자" + i);
				}
				pstmt.executeUpdate();
			}
		} catch (SQLException e) { e.printStackTrace(); }
		finally {
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) {} }
			if (conn != null) { try { conn.close(); } catch (SQLException e) {} }
		}
	}
	
	@Test
	public void testInsertAuth() {
		String sql = "INSERT INTO security_member_auth(uid, auth) VALUES(?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			for (int i = 0; i < 100; i++) {
				
				if (i < 80) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(2, "ROLE_USER");
				} else if (i < 90) {
					pstmt.setString(1, "manager" + i);
					pstmt.setString(2, "ROLE_MEMBERSHIP");
				} else {
					pstmt.setString(1, "admin" + i);
					pstmt.setString(2, "ROLE_MASTER");
				}
				pstmt.executeUpdate();
			}
		} catch (SQLException e) { e.printStackTrace(); }
		finally {
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) {} }
			if (conn != null) { try { conn.close(); } catch (SQLException e) {} }
		}
	}
	
}
