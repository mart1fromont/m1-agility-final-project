package com.adaptionsoft.games.goodTrivia.place;

import com.adaptionsoft.games.goodTrivia.enums.QuestionTypeEnum;

/**
 * Place class
 */
public class Place {
    private final QuestionTypeEnum questionType;

    private final int position;

    public Place(QuestionTypeEnum questionType, int position) {
        this.questionType = questionType;
        this.position = position;
    }

    public QuestionTypeEnum getQuestionType() {
        return questionType;
    }

    public int getPosition() {
        return position;
    }
}
