
package com.adaptionsoft.games.trivia.runner;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.OldAndUglyGame;


public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {
		OldAndUglyGame aGame = new OldAndUglyGame();
		
		aGame.addPlayer("Chet");
		aGame.addPlayer("Pat");
		aGame.addPlayer("Sue");
		
		Random rand = new Random();
	
		do {
			aGame.roll(rand.nextInt(5) + 1);
			
			if (rand.nextInt(9) != 7) {
				notAWinner = aGame.correctAnswer();
			} else {
				notAWinner = true;
			}
		} while (notAWinner);
		
	}
}
