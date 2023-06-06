package com.mdbytes.learnspringframework.examples.b.advanced.b2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class Normal {

}

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class Prototype {

}

@Configuration
@ComponentScan
public class BeanScopesContextLauncher {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(BeanScopesContextLauncher.class)) {
			System.out.println(context.getBean(Normal.class));
			System.out.println(context.getBean(Normal.class));
			System.out.println(context.getBean(Normal.class));
			System.out.println(context.getBean(Normal.class));
			System.out.println(context.getBean(Prototype.class));
			System.out.println(context.getBean(Prototype.class));
			System.out.println(context.getBean(Prototype.class));
			System.out.println(context.getBean(Prototype.class));

		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
