package com.mdbytes.rest.webservices.restfulwebservices.task;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
	
	private static List<Task> tasks = new ArrayList<>();
	
	private static int todosCount = 0;
	
	static {
		tasks.add(new Task(++todosCount, "in28minutes","Get AWS Certified",
							LocalDate.now().plusYears(10), false ));
		tasks.add(new Task(++todosCount, "in28minutes","Learn DevOps",
				LocalDate.now().plusYears(11), false ));
		tasks.add(new Task(++todosCount, "in28minutes","Learn Full Stack Development",
				LocalDate.now().plusYears(12), false ));
	}
	
	public List<Task> findByUsername(String username){
		Predicate<? super Task> predicate =
				task -> task.getUsername().equalsIgnoreCase(username);
		return tasks.stream().filter(predicate).toList();
	}
	
	public Task addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Task task = new Task(++todosCount,username,description,targetDate,done);
		tasks.add(task);
		return task;
	}
	
	public void deleteById(int id) {
		Predicate<? super Task> predicate = task -> task.getId() == id;
		tasks.removeIf(predicate);
	}

	public Task findById(int id) {
		Predicate<? super Task> predicate = task -> task.getId() == id;
		Task task = tasks.stream().filter(predicate).findFirst().get();
		return task;
	}

	public void updateTodo(Task task) {
		deleteById(task.getId());
		tasks.add(task);
	}
}