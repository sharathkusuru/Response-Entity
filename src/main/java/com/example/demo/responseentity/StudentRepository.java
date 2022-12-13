package com.example.demo.responseentity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


@Repository
public class StudentRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired(required = false)
	private SimpleJdbcInsert simpleJdbcInsert;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private NamedParameterJdbcTemplate namedparameterjdbcTemplate;


	@PostConstruct
	private void postConstruct() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("students").withSchemaName("public")
				.usingGeneratedKeyColumns("id");
	}

	public List<Student> getAllStudents() {

		return namedparameterjdbcTemplate.query("select * from students", new StudentRowMapper());
	}

	public Student saveStudent(Student student) {
		SqlParameterSource insert = new BeanPropertySqlParameterSource(student);
		student.setId((int) simpleJdbcInsert.executeAndReturnKey(insert));
		return student;
		
	}

	public Student deleteStudent(int id, Student std) {
		
		 jdbcTemplate.update("delete from students where id=?",id);
		 return std;
	}

	public List<Student> getStudentByid(int id) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		return namedparameterjdbcTemplate.query("select * from students where id=:id", map, new StudentRowMapper());
	}
		
	



}
