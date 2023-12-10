package org.capston.mymovie.Dto;

import java.util.List;

import org.capston.mymovie.entity.MovieTicket;
import org.capston.mymovie.entity.User;

public class UserDto {
	private Long id;
	private String fullname;
	private String email;
	private String password;
	private List<MovieTicket> movieTickets;
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
	public List<MovieTicket> getMovieTickets() {
		return movieTickets;
	}
	public void setMovieTickets(List<MovieTicket> movieTickets) {
		this.movieTickets = movieTickets;
	}
	
	public static UserDto from(User user)
	{
		UserDto userDto=new UserDto();
		userDto.setId(user.getId());
		userDto.setFullname(user.getFullname());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setMovieTickets(user.getMovieTickets());
		return userDto;
	}

}
