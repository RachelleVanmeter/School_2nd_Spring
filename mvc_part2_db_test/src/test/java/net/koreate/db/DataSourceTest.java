package net.koreate.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class DataSourceTest {

	@Inject
	DataSource ds;

	@Test
	public void test() {
		Connection con = null;
		try {
			System.out.println(ds);
			con = ds.getConnection();
			System.out.println("database 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("연결정보");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}

}
