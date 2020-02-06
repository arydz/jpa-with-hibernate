/**
 * ------------------------------------------------------------
 * Copyright (c) PUMA SE
 * This software is the proprietary information of PUMA SE
 * All Right Reserved.
 * ------------------------------------------------------------
 */
package com.arydz.hibernate.learning.jpawithhibernate.jpa;

import com.arydz.hibernate.learning.jpawithhibernate.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

// Repository
// Transaction

@Repository
@Transactional
public class PersonJpaRepository {

	// connect to database
	// All operation we are perform are stored in Persistence context
	@PersistenceContext
	EntityManager entityManager; // It's manages an entities. It's interface to Persistence Context, all operation are going troughs entity manager

	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}

	// Merge method, checks if person has id value null or set. If it's null then it adds new one, in other case it's updating existing person
	public Person update(Person person) {
		return entityManager.merge(person);
	}

	// We don't need two methods, because they are the same. We leave them only for this example
	public Person insert(Person person) {
		return entityManager.merge(person);
	}

	public void deleteById(int id) {
		Person personById = findById(id);
		entityManager.remove(personById);
	}

	// Find all method is only one not implemented in JPA. We need to use here JPQL to write own query
	public List<Person> findAll() {
		// This query is defined in entity
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}
}
