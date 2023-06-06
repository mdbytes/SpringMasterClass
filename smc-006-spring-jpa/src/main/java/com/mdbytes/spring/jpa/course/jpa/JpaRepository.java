package com.mdbytes.spring.jpa.course.jpa;

import org.springframework.stereotype.Repository;

import com.mdbytes.spring.jpa.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class JpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void insert(Course course) {
		entityManager.merge(course);
	}

	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}

	@Transactional
	public void deleteById(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}

}
