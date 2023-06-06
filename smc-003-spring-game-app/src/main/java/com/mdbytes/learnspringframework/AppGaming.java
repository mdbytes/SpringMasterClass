package com.mdbytes.learnspringframework;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mdbytes.learnspringframework.game.GameRunner;

@Configuration
@ComponentScan("com.mdbytes.learnspringframework.game")
public class AppGaming {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(AppGaming.class)) {

			var gameRunner = context.getBean(GameRunner.class);

			gameRunner.run();

		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
