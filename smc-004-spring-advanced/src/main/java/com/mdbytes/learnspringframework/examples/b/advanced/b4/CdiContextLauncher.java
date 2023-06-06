package com.mdbytes.learnspringframework.examples.b.advanced.b4;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Component
@Named
class BusinessService {
	private DataService dataService;

	public DataService getDataService() {
		return dataService;
	}

	@Inject
	public void setDataService(DataService dataService) {
		System.out.println("setter injected...");
		this.dataService = dataService;
	}

}

//@Component
@Named
class DataService {

}

@Configuration
@ComponentScan
public class CdiContextLauncher {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(CdiContextLauncher.class)) {

			Arrays.stream(context.getBeanDefinitionNames()).forEach(name -> System.out.println(name));

			System.out.println(context.getBean(BusinessService.class).getDataService());

		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
