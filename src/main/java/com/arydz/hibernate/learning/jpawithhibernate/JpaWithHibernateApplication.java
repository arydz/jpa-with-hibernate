package com.arydz.hibernate.learning.jpawithhibernate;

import com.arydz.hibernate.learning.jpawithhibernate.entity.Person;
import com.arydz.hibernate.learning.jpawithhibernate.jdbc.PersonJdbcDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
	}
}
