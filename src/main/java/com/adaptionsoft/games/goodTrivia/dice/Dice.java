package com.adaptionsoft.games.goodTrivia.dice;

/**
 * Dice class
 */
public class Dice {

    private final int faces;

    /**
     * Constructor
     * @param faces number of faces
     */
    public Dice(int faces) {
        this.faces = faces;
    }

    /**
     * Roll the dice
     * @return the result
     */
    public int roll() {
        return (int) (Math.random() * faces) + 1;
    }
}
