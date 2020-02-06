/**
 * ------------------------------------------------------------
 * Copyright (c) PUMA SE
 * This software is the proprietary information of PUMA SE
 * All Right Reserved.
 * ------------------------------------------------------------
 */
package com.arydz.hibernate.learning.jpawithhibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.util.Date;

@Getter
@Setter
// Spring Boot auto configuration knows that we use in memory DB and that JPA is in class path. It knows which entities we are defining.
// After that spring invoke something like schema update from hibernate. Therefore appropriate table is created in DB and we don't
// need schema.sql file. This file have to be deleted, commenting sql is ignored and it's causing errors!
@Entity
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "find_all_persons", query = "select p from Person p") // JPQL doesn't use DB, tables. It use entities
//There is no need to use this name mapping, because class name matches sql table
//@Table(name = "person")
public class Person {

	@Id    // Primary key
	@GeneratedValue    // this annotation populate id value - hibernate create sequence in DB which generates next int values
	private Integer id;

	// It's also unnecessary annotation in this case
//	@Column(name = "name")
	private String name;
	private String country;
	private Date birthDate;

	// Hibernate require constructor without id
	public Person(String name, String country, Date birthDate) {
		super();
		this.name = name;
		this.country = country;
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return String.format("\nPerson [id=%s, name=%s, location=%s, birthDate=%s]", id, name, country, birthDate);
	}
}
