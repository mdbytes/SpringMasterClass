package com.mdbytes.learnspringframework.examples.b.advanced.b3;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
	private SomeDependency someDependency;

	public SomeClass(SomeDependency someDependency) {
		this.someDependency = someDependency;
		System.out.println("dependencies constructed");
	}

	@PostConstruct
	public void initialize() {
		someDependency.getReady();
	}

	@PreDestroy
	public void cleanup() {
		System.out.println("Cleaning up");
	}

}

@Component
class SomeDependency {

	public void getReady() {
		System.out.println("getting ready!");
	}

}

@Configuration
@ComponentScan
public class PostConstructPreDestroyContextLauncher {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(PostConstructPreDestroyContextLauncher.class)) {

			Arrays.stream(context.getBeanDefinitionNames()).forEach(name -> System.out.println(name));

		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
