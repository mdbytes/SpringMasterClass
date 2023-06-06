package com.mdbytes.spring.jpa.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mdbytes.spring.jpa.course.spring.data.CourseRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseRepository repository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Course course1 = new Course(1, "lean aws", "dwyer");
		Course course2 = new Course(2, "learn google cloud", "dwyer");
		Course course3 = new Course(3, "learn azure", "dwyer");
		Course course4 = new Course(4, "learn digitalocean", "dwyer");
		repository.save(course1);
		repository.save(course2);
		repository.save(course3);
		repository.save(course4);
		repository.deleteById(1l);
		System.out.println(repository.findById(2l));
		System.out.println(repository.findAll());
		System.out.println(repository.findByAuthor("dwyer"));
	}

}
