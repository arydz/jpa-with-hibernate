package com.arydz.hibernate.learning.jpawithhibernate.jdbc;

import com.arydz.hibernate.learning.jpawithhibernate.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
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

	public Person findById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM PERSON WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class));
	}

	public int deleteById(int id) {
		// To modify data, eg. removing records, we are using update method, which returns affected rows
		return jdbcTemplate.update("DELETE FROM PERSON WHERE id=?", new Object[]{id});
	}

	public int insert(Person person) {
		return jdbcTemplate.update("INSERT INTO PERSON (ID, NAME, COUNTRY, BIRTH_DATE) VALUES(?, ?, ?, ?)", //
						new Object[]{person.getId(), person.getName(), person.getCountry(), new Timestamp(person.getBirthDate().getTime())});
	}

	public int update(Person person) {
		return jdbcTemplate.update("UPDATE PERSON SET NAME=?, COUNTRY=?, BIRTH_DATE=? WHERE ID=?", //
						new Object[]{person.getName(), person.getCountry(), new Timestamp(person.getBirthDate().getTime()), person.getId()});
	}

}
