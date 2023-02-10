package com.adaptionsoft.games.goodTrivia.question;

import com.adaptionsoft.games.goodTrivia.enums.QuestionTypeEnum;

/**
 * Interface for questions
 */
public abstract class AbstractQuestion implements IQuestion {

    private final String question;

    private final QuestionTypeEnum type;

    public AbstractQuestion(String question, QuestionTypeEnum type) {
        this.question = question;
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public QuestionTypeEnum getType() {
        return type;
    }
}
