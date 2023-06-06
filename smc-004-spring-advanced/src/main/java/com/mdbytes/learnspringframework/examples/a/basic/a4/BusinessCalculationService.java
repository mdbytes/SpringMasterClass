package com.mdbytes.learnspringframework.examples.a.basic.a4;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
interface DataService {
	int[] retrieveData();
}

@Component
class MongoDbDataService implements DataService {
	public int[] retrieveData() {
		return new int[] { 11, 22, 33, 44, 55 };
	}
}

@Component
@Primary
class MySQLDataService implements DataService {
	public int[] retrieveData() {
		return new int[] { 1, 2, 3, 4, 5 };
	}
}

@Component
class BusinessCalculator {

	DataService dataService;

	@Autowired
	public BusinessCalculator(DataService dataService) {
		this.dataService = dataService;
	}

	public int findMax() {
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}
}

@Configuration
@ComponentScan
public class BusinessCalculationService {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(BusinessCalculationService.class)) {

			var calculator = context.getBean(BusinessCalculator.class);

			System.out.println(calculator.findMax());

		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
