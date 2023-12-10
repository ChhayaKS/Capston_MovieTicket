package org.capston.mymovie.Exception;

import java.text.MessageFormat;

public class MovieTicketNotFoundException  extends RuntimeException{
	public MovieTicketNotFoundException(Long id) {
		super(MessageFormat.format("Could Not found the Movie Ticket with this id", id));
	}

}
