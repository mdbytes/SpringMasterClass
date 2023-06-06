package com.mdbytes.learnspringframework.examples.a3;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBusinessClass {

	Dependency1 dependency1;

	Dependency2 dependency2;

	@Autowired
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

	public void setDependency1(Dependency1 dependency1) {
		this.dependency1 = dependency1;
	}

	public void setDependency2(Dependency2 dependency2) {
		this.dependency2 = dependency2;
	}

	@Override
	public String toString() {
		return "YourBusinessClass [dependency1=" + dependency1 + ", dependency2=" + dependency2 + "]";
	}

}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}

@Configuration
@ComponentScan
public class AppGamingConstructorInjection {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(AppGamingConstructorInjection.class)) {

			Arrays.stream(context.getBeanDefinitionNames()).forEach(name -> System.out.println(name));

			var business = context.getBean(YourBusinessClass.class);

			System.out.println(business);

		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
