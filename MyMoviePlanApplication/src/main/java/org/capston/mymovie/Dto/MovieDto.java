

package org.capston.mymovie.Dto;

import java.util.List;

import org.capston.mymovie.entity.Movie;
import org.capston.mymovie.entity.MovieTicket;

public class MovieDto {
	private Long id;
	private String movie_name;
	private String movieImage;
	private String category;
	private String show_time;
	private List<MovieTicket> movieTickets;

	public Long getId() {
		return id;
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

	public String getMovieImage() {
		return movieImage;
	}

	public void setMovieImage(String movieImage) {
		this.movieImage = movieImage;
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

	public List<MovieTicket> getMovieTickets() {
		return movieTickets;
	}

	public void setMovieTickets(List<MovieTicket> list) {
		this.movieTickets = list;
	}

	public static MovieDto from(Movie movie) {
		MovieDto movieDto = new MovieDto();
		movieDto.setId(movie.getId());
		movieDto.setMovie_name(movie.getMovie_name());
		movieDto.setMovieImage(movie.getMovieImage());
		movieDto.setCategory(movie.getCategory());
		movieDto.setShow_time(movie.getShow_time());
		movieDto.setMovieTickets(movie.getMovieTicket());
		return movieDto;
	}

}
