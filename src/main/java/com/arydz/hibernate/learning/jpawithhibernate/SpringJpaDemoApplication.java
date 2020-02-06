package com.arydz.hibernate.learning.jpawithhibernate;

import com.arydz.hibernate.learning.jpawithhibernate.entity.Person;
import com.arydz.hibernate.learning.jpawithhibernate.jpa.PersonJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootApplication
public class SpringJpaDemoApplication implements CommandLineRunner {

	@Autowired
	private PersonJpaRepository personJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}

	// When application context is ready, then this method is invoked
	@Override
	public void run(String... args) throws Exception {
		Person person = personJpaRepository.findById(10001);
		log.info("User id 10001 {}", person);
		personJpaRepository.deleteById(10002);
		// Event if we pass here id value, hibernate would ignore it and generate it's own value
		Person newPerson = new Person("Edgard", "England", new Date());
		log.info("Insert person {}", personJpaRepository.insert(newPerson));
		Person updatePerson = new Person(10003, "Adolf", "Germany", new Date());
		log.info("Update person 10003 {}", personJpaRepository.update(updatePerson));
		List<Person> personList = personJpaRepository.findAll();
		log.info("All persons {}", personList);
	}
}
