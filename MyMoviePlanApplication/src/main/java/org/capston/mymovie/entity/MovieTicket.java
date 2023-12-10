package org.capston.mymovie.entity;

import java.util.ArrayList;
import java.util.List;

import org.capston.mymovie.Dto.MovieTicketDto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class MovieTicket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticket_id")
	private Long id;
	private int total_Ticket;
	private Double price;

	public MovieTicket() {
	}

	public MovieTicket(int total_Ticket, Double price, Movie movie, List<User> user, List<Cart> cart) {
		super();
		this.total_Ticket = total_Ticket;
		this.price = price;
		this.movie = movie;
		this.user = user;
		//this.cart = cart;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "movie_id")
	@JsonIgnore
	private Movie movie;

	@ManyToMany(mappedBy = "movieTickets", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<User> user = new ArrayList<>();

	@ManyToMany(mappedBy = "movieTickets", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Cart> cart = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTotal_Ticket() {
		return total_Ticket;
	}

	public void setTotal_Ticket(int total_Ticket) {
		this.total_Ticket = total_Ticket;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	public void add(MovieTicket movieTicket) {

	}

	public void remove(MovieTicket movieTicket) {

	}

	public void addCart(Cart cart) {
		cart.add(cart);
	}

//	public void addUser(User user) {
//		user.add(user);
//
//	}

	public static MovieTicket from(MovieTicketDto movieTicketDto) {
		MovieTicket movieTicket = new MovieTicket();
		movieTicket.setId(movieTicketDto.getId());
		movieTicket.setTotal_Ticket(movieTicketDto.getTotal_Ticket());
		movieTicket.setPrice(movieTicketDto.getPrice());
		movieTicket.setMovie(movieTicketDto.getMovie());
		return movieTicket;
	}

	
}
