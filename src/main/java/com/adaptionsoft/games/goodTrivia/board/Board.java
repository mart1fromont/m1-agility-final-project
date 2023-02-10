package com.adaptionsoft.games.goodTrivia.board;

import com.adaptionsoft.games.goodTrivia.exceptions.NoMoreQuestionInCategoryException;
import com.adaptionsoft.games.goodTrivia.exceptions.PlaceNotFoundException;
import com.adaptionsoft.games.goodTrivia.place.Place;
import com.adaptionsoft.games.goodTrivia.question.IQuestion;
import com.adaptionsoft.games.goodTrivia.enums.QuestionTypeEnum;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Place> places = new ArrayList<>();

    private final List<IQuestion> questions = new ArrayList<>();

    /**
     * Add a place to the board
     *
     * @param category the category of the place
     */
    public void addPlace(QuestionTypeEnum category) {
        this.places.add(new Place(category, this.places.size()));
    }

    /**
     * Add a question to the board
     *
     * @param question the question to addPlayer
     */
    public void addQuestion(IQuestion question) {
        this.questions.add(question);
    }

    /**
     * Asks a question of the given category
     *
     * @param category the category of the question
     * @return the question
     */
    public IQuestion askQuestion(final QuestionTypeEnum category) {
        // Get first question of the category
        final IQuestion question = this.questions.stream()
                .filter(q -> q.getType().equals(category))
                .findFirst()
                .orElseThrow(() -> new NoMoreQuestionInCategoryException(category));

        // If there is a question, then remove it from the list and print it
        this.questions.remove(question);
        return question;
    }

    /**
     * Gets the place at the given position
     *
     * @param position the position of the place
     * @return the place
     */
    public Place getPlace(int position) {
        return this.places.stream()
                .filter(p -> p.getPosition() == position)
                .findFirst()
                .orElseThrow(() -> new PlaceNotFoundException(position));
    }

    /**
     * Gets the number of places on the board
     *
     * @return the number of places
     */
    public int getNumberOfPlaces() {
        return this.places.size();
    }
}
