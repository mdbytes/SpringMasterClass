package com.mdbytes.rest.webservices.restfulwebservices.rest;

import com.mdbytes.rest.webservices.restfulwebservices.jpa.TaskRepository;
import com.mdbytes.rest.webservices.restfulwebservices.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping("/users/{username}/tasks")
    public Task createTask(@RequestBody Task task) {
        Task newTask = taskRepository.save(task);
        return newTask;
    }


    @GetMapping("/users/{username}/tasks")
    public List<Task> retrieveTasks(@PathVariable String username) {
        List<Task> tasks = taskRepository.findByUsername(username);
        return tasks;
    }

    @GetMapping("/users/{username}/tasks/{id}")
    public Task retrieveTask(@PathVariable String username, @PathVariable int id) {
        Task task = taskRepository.findById(id).get();
        return task;
    }

    @DeleteMapping("/users/{username}/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {
        taskRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

//    @PutMapping("/tasks")
//    public Task updateTask(@RequestBody Task task) {
//        Task t = taskRepository.save(task);
//        return t;
//    }

}
