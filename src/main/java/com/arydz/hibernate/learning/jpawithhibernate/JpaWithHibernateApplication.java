package com.arydz.hibernate.learning.jpawithhibernate;

import com.arydz.hibernate.learning.jpawithhibernate.entity.Person;
import com.arydz.hibernate.learning.jpawithhibernate.jdbc.PersonJdbcDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootApplication
public class JpaWithHibernateApplication implements CommandLineRunner {

	@Autowired
	private PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(JpaWithHibernateApplication.class, args);
	}

	// When application context is ready, then this method is invoked
	@Override
	public void run(String... args) throws Exception {
		List<Person> personList = dao.findAll();
		log.info("All users -> {}", personList);
		Person person = dao.findById(10001);
		log.info("Users id 10001 -> {}", person);
		int affectedRows = dao.deleteById(10002);
		log.info("Delete user id 10002 -> {}", affectedRows);
		Person newPerson = new Person(10004, "Edgard", "England", new Date());
		int insert = dao.insert(newPerson);
		log.info("Insert person 10004 {}", insert);
		Person updatePerson = new Person(10003, "Adolf", "Germany", new Date());
		int update = dao.update(updatePerson);
		log.info("Update person 10003 {}", update);
	}
}
