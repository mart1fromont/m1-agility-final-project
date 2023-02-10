package com.adaptionsoft.games.goodTrivia.player;

/**
 * Player class
 */
public class Player {

    private final String name;

    private int currentPlace;

    private int score;

    private boolean inPenalty;


    public Player(final String name) {
        this.name = name;
        this.currentPlace = 0;
        this.score = 0;
        this.setPenalty(false);
    }

    /**
     * Increase player score
     */
    public void increaseScore() {
        this.score++;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPlace() {
        return currentPlace;
    }

    public void setCurrentPlace(int currentPlace) {
        this.currentPlace = currentPlace;
    }

    public int getScore() {
        return score;
    }

    public boolean hasPenalty() {
        return inPenalty;
    }

    public void setPenalty(final boolean penaltyState) {
        this.inPenalty = penaltyState;
    }
}
