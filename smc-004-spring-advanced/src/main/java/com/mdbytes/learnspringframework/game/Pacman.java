package com.mdbytes.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Pacman implements GamingConsole {

	@Override
	public void up() {
		// TODO Auto-generated method stub
		System.out.println("up");
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		System.out.println("down");
	}

	@Override
	public void left() {
		// TODO Auto-generated method stub
		System.out.println("left");

	}

	@Override
	public void right() {
		// TODO Auto-generated method stub
		System.out.println("right");
	}

}
