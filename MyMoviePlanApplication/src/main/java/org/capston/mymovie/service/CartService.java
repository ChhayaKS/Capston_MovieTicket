package org.capston.mymovie.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.capston.mymovie.Exception.CartNotFoundException;
import org.capston.mymovie.entity.Cart;
import org.capston.mymovie.entity.MovieTicket;
import org.capston.mymovie.entity.User;
import org.capston.mymovie.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private MovieTicketService movieTicketService;
	
	@Autowired
	private UserService userService;

	public Cart addToCart(Cart cart) {
		return cartRepository.save(cart);
	}

	public Cart getCartById(Long id) {

		return cartRepository.findById(id).orElseThrow(() -> new CartNotFoundException(id));
	}
	

	public List<Cart> getAllCartByUserId(Long id) {
		return StreamSupport.stream(cartRepository.findAllByUserId(id).spliterator(), false).collect(Collectors.toList());
	}
	

	public List<Cart> getAllCarts() {
		return StreamSupport.stream(cartRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Transactional
	public Cart updateCart(Cart cart, Long id) {
		Cart updatecart = getCartById(id);
		updatecart.setMovieTickets(cart.getMovieTickets());
		return updatecart;
	}

	@Transactional
	public Cart deleteCart(Long id) {
		Cart cart = getCartById(id);
		cartRepository.delete(cart);
		return cart;
	}

//	@Transactional
//	public Cart addMovieTicketToCart(Long cartId, Long movieTicketId) {
//		Cart cart = getCartById(cartId);
//	    //User user=userService.getUserById(userId);
//		MovieTicket movieTicket = movieTicketService.getMovieTicketById(movieTicketId);
//		cart.addMovieTicket(movieTicket);
//		movieTicket.addCart(cart);
//		return cart;
//	}
	@Transactional
	public Cart addMovieTicketToCart(Long cartId, Long userId) {
		Cart cart = getCartById(cartId);
	    User user=userService.getUserById(userId);
//		MovieTicket movieTicket = movieTicketService.getMovieTicketById(movieTicketId);
		cart.setUser(user);
		user.setCart(cart);
		return cart;
	}


}
