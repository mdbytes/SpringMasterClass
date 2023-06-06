package com.mdbytes.rest.webservices.restfulwebservices.jpa;

import com.mdbytes.rest.webservices.restfulwebservices.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RestResource
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByUsername(String username);
}
