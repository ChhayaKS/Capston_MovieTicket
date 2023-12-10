package org.capston.mymovie.Exception;

import java.text.MessageFormat;

public class MovieNotFoundException extends RuntimeException{
	public MovieNotFoundException(Long id) {
    super(MessageFormat.format("Could not find the Movie with this id :",id));
	}

}
