package com.mdbytes.task.app.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@GetMapping("/hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! What are you learning today?";
	}

	@GetMapping("/hi-there")
	public String hi() {
		return "hi";
	}
}
