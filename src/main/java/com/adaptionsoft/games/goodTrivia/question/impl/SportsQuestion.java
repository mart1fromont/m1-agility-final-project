package com.adaptionsoft.games.goodTrivia.question.impl;

import com.adaptionsoft.games.goodTrivia.question.AbstractQuestion;
import com.adaptionsoft.games.goodTrivia.enums.QuestionTypeEnum;

public class SportsQuestion extends AbstractQuestion {
    public SportsQuestion(final String question) {
        super(question, QuestionTypeEnum.SPORTS);
    }
}
