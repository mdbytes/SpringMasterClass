package com.mdbytes.task.app.task;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TaskController {

	private TaskRepository taskRepository;

	@Autowired
	public TaskController(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@GetMapping("/list-tasks")
	public String listTasks(ModelMap model) {
		String username = getLoggedInUsername();
		List<Task> tasks = taskRepository.findByUsername(username);
		model.put("tasks", tasks);
		return "tasks";
	}

	private String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

	@GetMapping("/add-task")
	public String addTask(ModelMap model) {
		Task task = new Task(0, (String) model.get("name"), "", LocalDate.now(), false);
		model.put("task", task);
		return "task";
	}

	@PostMapping("/add-task")
	public String newTask(ModelMap model, @Valid Task task, BindingResult result) {
		if (result.hasErrors()) {
			return "task";
		}
		taskRepository.save(new Task((String) model.get("name"), task.getDescription(), task.getTargetDate(), false));
		return "redirect:list-tasks";
	}

	@GetMapping("/delete-task")
	public String deleteTask(@RequestParam int id) {
		taskRepository.deleteById(id);
		return "redirect:list-tasks";
	}

	@GetMapping("/update-task")
	public String updateTask(@RequestParam int id, ModelMap model) {
		Task task = taskRepository.findById(id).get();
		model.addAttribute("task", task);
		return "updateTask";
	}

	@PostMapping("/update-task")
	public String updateTaskDetails(ModelMap model, @Valid Task task, BindingResult result) {
		if (result.hasErrors()) {
			return "updateTask";
		}
		System.out.println(task.toString());
		taskRepository.save(task);
		return "redirect:list-tasks";
	}

}
