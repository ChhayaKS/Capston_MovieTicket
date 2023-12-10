package org.capston.mymovie.Dto;

import java.util.List;

import org.capston.mymovie.entity.Cart;
import org.capston.mymovie.entity.MovieTicket;

public class CartDto {
	private Long id;
	private Integer unit;
	private Double totalPrice;

	private List<MovieTicket> movieTickets;


	public Integer getUnit() {
		return unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<MovieTicket> getMovieTickets() {
		return movieTickets;
	}

	public void setMovieTickets(List<MovieTicket> movieTickets) {
		this.movieTickets = movieTickets;
	}

	public static CartDto from(Cart cart) {
		CartDto cartDto = new CartDto();
		cartDto.setId(cart.getId());
		cartDto.setUnit(cart.getUnit());
		cartDto.setTotalPrice(cart.getTotalPrice());
		cartDto.setMovieTickets(cart.getMovieTickets());
		return cartDto;
	}

}
