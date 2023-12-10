package org.capston.mymovie.Exception;

import java.text.MessageFormat;

public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(Long id) {
		super(MessageFormat.format("Could Not find User with this id", id));
	}

}
