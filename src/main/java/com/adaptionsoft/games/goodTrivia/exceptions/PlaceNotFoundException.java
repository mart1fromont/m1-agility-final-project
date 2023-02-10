package com.adaptionsoft.games.goodTrivia.exceptions;

public class PlaceNotFoundException extends RuntimeException {
        public PlaceNotFoundException(int position) {
            super("Place not found at position " + position);
        }
}
