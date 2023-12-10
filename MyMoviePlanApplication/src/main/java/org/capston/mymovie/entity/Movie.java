package org.capston.mymovie.entity;

import java.util.ArrayList;
import java.util.List;

import org.capston.mymovie.Dto.MovieDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movie_id")
	private Long id;
	private String movie_name;
	private String movieImage;
	private String category;
	private String show_time;

	public Movie() {
	}

	public Movie( String movie_name, String movieImage, String category, String show_time,
			List<MovieTicket> movieTicket) {
		super();
		this.movie_name = movie_name;
		this.movieImage = movieImage;
		this.category = category;
		this.show_time = show_time;
		this.movieTicket = movieTicket;
	}

	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
	private List<MovieTicket> movieTicket = new ArrayList<>();

	public String getMovieImage() {
		return movieImage;
	}

	public void setMovieImage(String movieImage) {
		this.movieImage = movieImage;
	}

	public Long getId() {
		return id;
	}

	public List<MovieTicket> getMovieTicket() {
		return movieTicket;
	}

	public void setMovieTicket(List<MovieTicket> movieTicket) {
		this.movieTicket = movieTicket;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	public String getShow_time() {
		return show_time;
	}

	public void setShow_time(String show_time) {
		this.show_time = show_time;
	}

	public void addMovieTicket(MovieTicket movieTicket) {
		movieTicket.add(movieTicket);
	}

	public void removeMovieTicket(MovieTicket movieTicket) {
		movieTicket.remove(movieTicket);
	}

	public static Movie from(MovieDto movieDto) {
		Movie movie = new Movie();
		movie.setId(movieDto.getId());
		movie.setMovie_name(movieDto.getMovie_name());
		movie.setMovieImage(movieDto.getMovieImage());
		movie.setCategory(movieDto.getCategory());
		movie.setShow_time(movieDto.getShow_time());
		movie.setMovieTicket(movieDto.getMovieTickets());
		return movie;
	}

}
