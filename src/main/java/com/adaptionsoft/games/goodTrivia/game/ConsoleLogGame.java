package com.adaptionsoft.games.goodTrivia.game;

/**
 * Game with a console log
 */
public class ConsoleLogGame extends AbstractGame {
    /**
     * Logs a message
     * @param message The message to log
     */
    public void addLog(final String message) {
        System.out.println(message);
    }
}
