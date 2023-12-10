package org.capston.mymovie.entity;

import java.util.ArrayList;
import java.util.List;

import org.capston.mymovie.Dto.CartDto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer unit;
	private Double totalPrice;

	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "cart_MovieTicket", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "ticket_id"))
	private List<MovieTicket> movieTickets = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "user_id")
	private User user;
	
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(Long id, Integer unit, Double totalPrice,List<MovieTicket> movieTickets, User user) {
		super();
		this.id = id;
		this.unit = unit;
		this.totalPrice = totalPrice;
		this.movieTickets = movieTickets;
		this.user = user;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public List<MovieTicket> getMovieTickets() {
		return movieTickets;
	}

	public void setMovieTickets(List<MovieTicket> movieTickets) {
		this.movieTickets = movieTickets;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static Cart from(CartDto cartDto) {
		Cart cart = new Cart();
		cart.setId(cartDto.getId());
		cart.setUnit(cartDto.getUnit());
		cart.setTotalPrice(cartDto.getTotalPrice());
		cart.setMovieTickets(cartDto.getMovieTickets());
		return cart;
	}


	public void addMovieTicket(MovieTicket movieTicket) {
		movieTickets.add(movieTicket);
	}

	public void add(Cart cart) {
		// TODO Auto-generated method stub
		
	}



}
