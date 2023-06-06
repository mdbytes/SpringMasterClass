package com.mdbytes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person (String name, int age, Address address) {};
record Address (String streetAddress, String city) {};

@Configuration
public class HelloSpringConfiguration {

	@Bean
	public String name() {
		return "Ranga";
	}
	
	@Bean
	public int age() {
		return 22;
	}
	
	@Bean
	@Primary
	public Person person() {
		var person = new Person("Ravi",20, new Address("123 Main Street","New York"));
		return person;
	}
	
	@Bean
	public Person personTwo() {
		var person = new Person(name(),age(),new Address("456 Main Street","New York"));
		return person;
	}
	
	@Bean
	public Person personThree(String name, int age, Address addressTwo) {
		var person = new Person(name,age, addressTwo);
		return person;
	}
	
	
	@Bean("addressTwo")
	public Address address() {
		var address = new Address("168 16th Ave SW","Cedar Rapids");
		return address;
	}
}
