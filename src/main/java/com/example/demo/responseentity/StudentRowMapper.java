package com.example.demo.responseentity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student std = new Student();

		std.setId(rs.getInt("id"));
		std.setName(rs.getString("name"));
		std.setAddress(rs.getString("address"));
		return std;
	}

}
