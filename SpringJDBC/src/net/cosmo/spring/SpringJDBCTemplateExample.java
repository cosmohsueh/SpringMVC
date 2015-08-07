package net.cosmo.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class SpringJDBCTemplateExample {

	public static void main(String[] args) throws SQLException {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new oracle.jdbc.driver.OracleDriver());
		dataSource.setUrl("jdbc:oracle:thin:@192.168.101.170:1521:xe");
		dataSource.setUsername("ESHOP");
		dataSource.setPassword("ESHOP");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sqlInsert = "insert into PATRON (PATRON_ID, USERNAME, INSTITUTION_ID, PASSWORD, USER_NAME, EMAIL, MOBILE_PHONE, NATIONAL_ID_NUMBER, BIRTH_DATE, DATE_ADDED, STORE_ID, STORE_NAME, PACKAGE_QUANTITY)" + 
				"values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sqlInsert, 999, "aaa", 3, "aaa", "aaa", null, null, null, null, null, null, null, 5);
		
		String sqlUpdate = "update PATRON set EMAIL=? where PATRON_ID=?";
		jdbcTemplate.update(sqlUpdate, "ccc@ccc", 999);
		
		String sqlSelect = "select * from PATRON";
		List<Patron> patronList = jdbcTemplate.query(sqlSelect, new RowMapper<Patron>(){

			@Override
			public Patron mapRow(ResultSet rs, int rowNum) throws SQLException {
				Patron patron = new Patron();
				patron.setPatronId(rs.getLong("PATRON_ID"));
				patron.setUsername(rs.getString("USERNAME"));
				patron.setInstitutionId(rs.getLong("INSTITUTION_ID"));
				patron.setPassword(rs.getString("PASSWORD"));
				patron.setUserName(rs.getString("USER_NAME"));
				patron.setEmail(rs.getString("EMAIL"));
				return patron;
			}
			
		});
		
		for(Patron patron: patronList){
			System.out.println(patron.toString());
		}
		
		String sqlDelete = "delete from PATRON where PATRON_ID = ?";
		jdbcTemplate.update(sqlDelete, 999);
	}

}
