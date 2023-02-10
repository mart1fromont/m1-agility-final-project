package com.adaptionsoft.games.goodTrivia.exceptions;

import com.adaptionsoft.games.goodTrivia.enums.QuestionTypeEnum;

public class NoMoreQuestionInCategoryException extends RuntimeException {
    public NoMoreQuestionInCategoryException(final QuestionTypeEnum category) {
        super("No more question in category: " + category);
    }
}
