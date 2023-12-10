package org.capston.mymovie.entity;

import java.util.ArrayList;
import java.util.List;

import org.capston.mymovie.Dto.UserDto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String fullname;
	private String email;
	private String password;

	public User() {
		// TODO Auto-generated constructor stub
	}

	@ManyToMany
	@JsonIgnore
	@JoinTable(name="user_movieTicket",joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="ticket_id"))
	private List<MovieTicket> movieTickets = new ArrayList<>();

	public List<MovieTicket> getMovieTickets() {
		return movieTickets;
	}

	public void setMovieTickets(List<MovieTicket> movieTickets) {
		this.movieTickets = movieTickets;
	}

	@OneToOne(mappedBy ="user", cascade = CascadeType.ALL)
	@JsonIgnore
	private Cart cart;
	
	
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public User(Long id, String fullname, String email, String password) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static User from(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setFullname(userDto.getFullname());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setMovieTickets(userDto.getMovieTickets());
		return user;
	}

	public void addmovieTikcet(MovieTicket movieTicket) {
		movieTickets.add(movieTicket);
	}

	


}
