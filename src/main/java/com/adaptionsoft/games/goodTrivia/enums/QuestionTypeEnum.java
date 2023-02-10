package com.adaptionsoft.games.goodTrivia.enums;

/**
 * Enum for question types
 */
public enum QuestionTypeEnum {

    POP("Pop"),
    SCIENCE("Science"),
    SPORTS("Sports"),
    ROCK("Rock");

    private final String name;

    QuestionTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
