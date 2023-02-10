package com.adaptionsoft.games.goodTrivia.game;

import com.adaptionsoft.games.IGame;
import com.adaptionsoft.games.goodTrivia.board.Board;
import com.adaptionsoft.games.goodTrivia.player.Player;
import com.adaptionsoft.games.goodTrivia.enums.QuestionTypeEnum;
import com.adaptionsoft.games.goodTrivia.question.impl.PopQuestion;
import com.adaptionsoft.games.goodTrivia.question.impl.RockQuestion;
import com.adaptionsoft.games.goodTrivia.question.impl.ScienceQuestion;
import com.adaptionsoft.games.goodTrivia.question.impl.SportsQuestion;

import java.util.LinkedList;

/**
 * New implementation for OldAndUglyGame class
 */
public abstract class AbstractGame implements IGame {
    // Constants
    public static final int WIN_SCORE_CONDITION = 6;

    // Attributes
    private final LinkedList<Player> players = new LinkedList<>();
    private final Board board;
    private Player currentPlayer;
    private boolean isGettingOutOfPenaltyBox; // RM : It's not a bug, it's a feature

    /**
     * Constructor
     */
    public AbstractGame() {
        this.board = new Board();

        for (int i = 0; i < 50; ++i) {
            this.board.addQuestion(new PopQuestion("Pop Question " + i));
            this.board.addQuestion(new ScienceQuestion("Science Question " + i));
            this.board.addQuestion(new SportsQuestion("Sports Question " + i));
            this.board.addQuestion(new RockQuestion("Rock Question " + i));
        }

        for (int i = 0; i < 3; ++i) {
            this.board.addPlace(QuestionTypeEnum.POP);
            this.board.addPlace(QuestionTypeEnum.SCIENCE);
            this.board.addPlace(QuestionTypeEnum.SPORTS);
            this.board.addPlace(QuestionTypeEnum.ROCK);
        }
    }

    /**
     * Add a player
     * @param playerName The player name
     */
    public void addPlayer(final String playerName) {
        this.players.add(new Player(playerName));
        if (null == this.currentPlayer) {
            this.currentPlayer = this.players.getFirst();
        }

        this.addLog(playerName + " was added");
        this.addLog("They are player number " + players.size());
    }

    /**
     * Play a turn
     *
     * @param roll The roll value
     */
    public void roll(final int roll) {
        this.addLog(currentPlayer.getName() + " is the current player");
        this.addLog("They have rolled a " + roll);

        // If the player has a penalty, he must roll an odd number
        if (this.currentPlayer.hasPenalty()) {
            if (roll % 2 != 0) {
                this.addLog(currentPlayer.getName() + " is getting out of the penalty box");
                isGettingOutOfPenaltyBox = true;
            } else {
                // Otherwise, he cannot play
                this.addLog(currentPlayer.getName() + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
                return;
            }
        }

        // If the player can play :
        // - He moves on the board according to the roll
        this.currentPlayer.setCurrentPlace(this.currentPlayer.getCurrentPlace() + roll);
        if (this.currentPlayer.getCurrentPlace() > this.board.getNumberOfPlaces() - 1) {
            this.currentPlayer.setCurrentPlace(this.currentPlayer.getCurrentPlace() - this.board.getNumberOfPlaces());
        }

        // - We ask a corresponding question
        this.addLog(currentPlayer.getName()
                + "'s new location is "
                + currentPlayer.getCurrentPlace());
        this.addLog("The category is " + currentCategory().getName());
        this.board.askQuestion(currentCategory());
    }

    /**
     * Gets the current category question for the current player
     *
     * @return The current category question
     */
    private QuestionTypeEnum currentCategory() {
        return this.board.getPlace(this.currentPlayer.getCurrentPlace()).getQuestionType();
    }

    /**
     * Gets the next player of the game
     *
     * @return The next player
     */
    private Player getNextPlayer() {
        // If there is no current player, then the first player is the current player
        if (null == this.currentPlayer) {
            return this.players.getFirst();
        } else {
            int index = this.players.indexOf(this.currentPlayer);
            if (index == this.players.size() - 1) {
                return this.players.getFirst();
            } else {
                return this.players.get(index + 1);
            }
        }
    }

    /**
     * Handles a correct answer for the current player
     *
     * @return True if the game is finished, false otherwise
     */
    public boolean correctAnswer() {
        if (!this.currentPlayer.hasPenalty() || isGettingOutOfPenaltyBox) {
            this.addLog("Answer was correct!!!!");
            this.currentPlayer.increaseScore();
            this.addLog(currentPlayer.getName()
                    + " now has "
                    + this.currentPlayer.getScore()
                    + " Gold Coins.");

            boolean winner = hasCurrentPlayerWin();
            this.currentPlayer = getNextPlayer();

            return winner;
        } else {
            this.currentPlayer = getNextPlayer();
            return true;
        }
    }

    /**
     * Handles the wrong answer
     */
    public void wrongAnswer() {
        this.addLog("Question was incorrectly answered");
        this.addLog(currentPlayer.getName() + " was sent to the penalty box");
        this.currentPlayer.setPenalty(true);

        this.currentPlayer = getNextPlayer();
    }

    /**
     * Checks if the current player has won
     *
     * @return True if the current player has won, false otherwise
     */
    private boolean hasCurrentPlayerWin() {
        return this.currentPlayer.getScore() != WIN_SCORE_CONDITION;
    }

    /**
     * Add a log
     * @param log The log to add
     */
    protected abstract void addLog(final String log);
}
