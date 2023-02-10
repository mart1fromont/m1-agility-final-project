package com.adaptionsoft.games;

/**
 * Interface for OldAndUglyGame
 */
public interface IGame {
    void addPlayer(String playerName);

    void roll(int roll);

    boolean correctAnswer();

    void wrongAnswer();
}
