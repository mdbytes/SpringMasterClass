package com.mdbytes.learnspringframework;

import com.mdbytes.learnspringframework.game.GameRunner;
import com.mdbytes.learnspringframework.game.MarioGame;
import com.mdbytes.learnspringframework.game.SuperContraGame;
import com.mdbytes.learnspringframework.game.Pacman;

public class AppGaming {

	public static void main(String[] args) {
		
		
		// 1. Object creation
		var pacman = new Pacman();
		var marioGame = new MarioGame();
		var superContraGame = new SuperContraGame();
		
		// 2. Object creation and wiring dependencies
		var gameRunner = new GameRunner(pacman);
		
		// 3. Run methods based on GameRunner
		gameRunner.run();
		
	}

}
