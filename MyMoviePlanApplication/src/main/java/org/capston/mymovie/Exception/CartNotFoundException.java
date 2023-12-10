package org.capston.mymovie.Exception;

import java.text.MessageFormat;

public class CartNotFoundException extends RuntimeException{
	public CartNotFoundException(Long id) {
		super(MessageFormat.format("Could not find the cart with this id", id));
	}

}
