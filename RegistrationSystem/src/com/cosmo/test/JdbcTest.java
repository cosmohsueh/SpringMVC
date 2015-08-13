package com.cosmo.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTest {
	
	public static void main(String[] args) throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
		DataSource dataSource = (DataSource) context.getBean("dataSource");
		
		Connection conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from PATRON");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.print(rs.getLong("PATRON_ID"));
			System.out.print(rs.getString("USERNAME"));
			System.out.print(rs.getLong("INSTITUTION_ID"));
			System.out.print(rs.getString("PASSWORD"));
			System.out.print(rs.getString("USER_NAME"));
			System.out.println();
		}
		((ConfigurableApplicationContext)context).close();
	}

}
