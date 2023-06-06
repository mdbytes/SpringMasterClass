package com.mdbytes.learnspringframework.examples.b.advanced.b1;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class A {

}

@Component
@Lazy
class B {

	private A a;

	public B(A a) {
		System.out.println("some initialization logic");
		this.a = a;
	}

	public void doSomething() {
		System.out.println("Doing something");
	}
}

@Configuration
@ComponentScan
public class LazyInitializationContextLauncher {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(LazyInitializationContextLauncher.class)) {

			System.out.println("context initialized");

			var bObj = context.getBean(B.class);

			bObj.doSomething();

			Arrays.stream(context.getBeanDefinitionNames()).forEach(name -> System.out.println(name));

		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
