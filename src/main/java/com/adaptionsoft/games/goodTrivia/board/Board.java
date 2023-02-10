package com.adaptionsoft.games.goodTrivia.board;

import com.adaptionsoft.games.goodTrivia.exceptions.NoMoreQuestionInCategoryException;
import com.adaptionsoft.games.goodTrivia.exceptions.PlaceNotFoundException;
import com.adaptionsoft.games.goodTrivia.place.Place;
import com.adaptionsoft.games.goodTrivia.question.IQuestion;
import com.adaptionsoft.games.goodTrivia.enums.QuestionTypeEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board {

    private final List<Place> places = new ArrayList<>();

    private final List<IQuestion> questions = new ArrayList<>();

    /**
     * Add a place to the board
     * @param category the category of the place
     */
    public void addPlace(QuestionTypeEnum category) {
        this.places.add(new Place(category, this.places.size()));
    }

    /**
     * Add a question to the board
     * @param question the question to addPlayer
     */
    public void addQuestion(IQuestion question) {
        this.questions.add(question);
    }

    public void askQuestion(final QuestionTypeEnum category) throws NoMoreQuestionInCategoryException {
		// Get first question of the category
		Optional<IQuestion> question = this.getQuestions().stream()
				.filter(q -> q.getType().equals(category))
				.findFirst();

		// If there is a question, then remove it from the list and print it
		if (question.isPresent()) {
			this.getQuestions().remove(question.get());
			System.out.println(question.get().getQuestion());
		} else {
			throw new NoMoreQuestionInCategoryException(category);
		}
	}

    /**
     * Gets the place at the given position
     * @param position the position of the place
     * @return the place
     */
    public Place getPlace(int position) {
        Optional<Place> optPlace = this.getPlaces().stream()
                .filter(p -> p.getPosition() == position)
                .findFirst();

        if (optPlace.isEmpty()) {
            throw new PlaceNotFoundException(position);
        }
        return optPlace.get();
    }

    private List<Place> getPlaces() {
        return places;
    }

    private List<IQuestion> getQuestions() {
        return questions;
    }

    /**
     * Gets the number of places on the board
     * @return the number of places
     */
    public int getNumberOfPlaces() {
        return this.getPlaces().size();
    }
}
