package com.arydz.hibernate.learning.jpawithhibernate.jdbc;

import com.arydz.hibernate.learning.jpawithhibernate.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcDao {

	// It's default spring object, which execute query and retrieve data
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Person> findAll() {
		// BeanPropertyRowMapper it's default row mapper which map every row on appropriate java object
		return jdbcTemplate.query("SELECT * FROM PERSON", new BeanPropertyRowMapper<>(Person.class));
	}
}
