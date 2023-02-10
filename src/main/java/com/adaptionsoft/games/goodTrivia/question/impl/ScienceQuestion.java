package com.adaptionsoft.games.goodTrivia.question.impl;

import com.adaptionsoft.games.goodTrivia.question.AbstractQuestion;
import com.adaptionsoft.games.goodTrivia.enums.QuestionTypeEnum;

public class ScienceQuestion extends AbstractQuestion {
    public ScienceQuestion(final String question) {
        super(question, QuestionTypeEnum.SCIENCE);
    }
}
