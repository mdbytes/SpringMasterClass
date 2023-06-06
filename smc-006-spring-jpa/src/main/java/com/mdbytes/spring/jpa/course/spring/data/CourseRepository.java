package com.mdbytes.spring.jpa.course.spring.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdbytes.spring.jpa.course.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	List<Course> findByAuthor(String author);
}
