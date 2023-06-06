package com.mdbytes.learnspringframework;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mdbytes.learnspringframework.game.GameRunner;
import com.mdbytes.learnspringframework.game.MarioGame;
import com.mdbytes.learnspringframework.game.SuperContraGame;
import com.mdbytes.learnspringframework.game.Pacman;



public class AppHelloSpring {

	public static void main(String[] args) {
		
		try (var context = new AnnotationConfigApplicationContext(HelloSpringConfiguration.class)) {
			// Configure the things we want Spring to manage - @Configuration
			System.out.println(context.getBean("name"));		
			System.out.println(context.getBean("age"));
			var person = context.getBean("person");
			System.out.println(person);
			var personTwo = context.getBean("personTwo");
			System.out.println(personTwo);
			var personThree = context.getBean("personThree");
			System.out.println(personThree);
			var address = context.getBean("addressTwo");
			System.out.println(address);
			var personFour = context.getBean(Person.class);
			System.out.println(personFour);
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(name -> System.out.println(name));
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

}
