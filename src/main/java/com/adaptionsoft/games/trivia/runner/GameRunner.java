
package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.goodTrivia.dice.Dice;
import com.adaptionsoft.games.uglytrivia.OldAndUglyGame;


public class GameRunner {

	private static final int DICE_FACES = 6;
	private static final int QUESTION_DICE_FACES = 9;

	private static final int QUESTION_INCORRECT_PROBABILITY = 7;

	public static void main(String[] args) {
		final Dice dice = new Dice(DICE_FACES);
		final Dice questionDice = new Dice(QUESTION_DICE_FACES);

		OldAndUglyGame aGame = new OldAndUglyGame();

		aGame.addPlayer("Chet");
		aGame.addPlayer("Pat");
		aGame.addPlayer("Sue");

		boolean notAWinner;
		do {
			aGame.roll(dice.roll());

			if (questionDice.roll() != QUESTION_INCORRECT_PROBABILITY) {
				notAWinner = aGame.correctAnswer();
			} else {
				aGame.wrongAnswer();
				notAWinner = true;
			}
		} while (notAWinner);
	}
}
