package com.adaptionsoft.games.goodTrivia.question.impl;

import com.adaptionsoft.games.goodTrivia.question.AbstractQuestion;
import com.adaptionsoft.games.goodTrivia.enums.QuestionTypeEnum;

public class RockQuestion extends AbstractQuestion {
    public RockQuestion(final String question) {
        super(question, QuestionTypeEnum.ROCK);
    }
}
