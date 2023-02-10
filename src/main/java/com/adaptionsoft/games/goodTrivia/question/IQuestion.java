package com.adaptionsoft.games.goodTrivia.question;

import com.adaptionsoft.games.goodTrivia.enums.QuestionTypeEnum;

public interface IQuestion {

    String getQuestion();

    QuestionTypeEnum getType();
}
