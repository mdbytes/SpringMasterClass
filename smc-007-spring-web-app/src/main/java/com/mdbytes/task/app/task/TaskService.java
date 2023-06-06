package com.mdbytes.task.app.task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TaskService {

	private static List<Task> tasks = new ArrayList<Task>();

	private static int taskCount = 0;

	public TaskService() {

	}

	static {
		tasks.add(new Task(++taskCount, "martin", "learn aws", LocalDate.now().plusYears(1), false));
		tasks.add(new Task(++taskCount, "martin", "learn google cloud", LocalDate.now().plusYears(1), false));
		tasks.add(new Task(++taskCount, "martin", "learn azure", LocalDate.now().plusYears(2), false));
		tasks.add(new Task(++taskCount, "martin", "learn digital ocean", LocalDate.now().plusYears(3), false));
		tasks.add(new Task(++taskCount, "martin", "learn docker deployment", LocalDate.now().plusYears(4), false));
	}

	public List<Task> findByUserName(String username) {
		tasks.removeIf(t -> !t.getUsername().equalsIgnoreCase(username));
		return tasks;
	}

	public void addToDo(String username, String description, LocalDate targetDate, boolean done) {
		tasks.add(new Task(++taskCount, username, description, targetDate, false));
	}

	public void deleteById(int id) {
		tasks.removeIf(task -> task.getId() == id);
	}

	public Task findById(int id) {
		Task task = tasks.stream().filter(t -> t.getId() == id).findFirst().get();
		return task;
	}

	public void updateToDo(@Valid Task task) {
		deleteById(task.getId());
		tasks.add(task);
	}

}
