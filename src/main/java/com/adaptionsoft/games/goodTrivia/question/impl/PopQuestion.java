package com.adaptionsoft.games.goodTrivia.question.impl;

import com.adaptionsoft.games.goodTrivia.question.AbstractQuestion;
import com.adaptionsoft.games.goodTrivia.enums.QuestionTypeEnum;

public class PopQuestion extends AbstractQuestion {
    public PopQuestion(final String question) {
        super(question, QuestionTypeEnum.POP);
    }
}
