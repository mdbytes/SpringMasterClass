package com.mdbytes.spring.boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@GetMapping("/courses")
	public List<Course> retrieveAllCourses() {
		return Arrays.asList(new Course(1, "learn aws", "dwyer"), new Course(2, "learn google cloud", "dwyer"),
				new Course(3, "learn azure", "dwyer"));

	}

}
