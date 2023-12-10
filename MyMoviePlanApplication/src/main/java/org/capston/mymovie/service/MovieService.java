package org.capston.mymovie.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.capston.mymovie.Exception.MovieNotFoundException;
import org.capston.mymovie.Exception.MovieTicketAlreadyAssigned;
import org.capston.mymovie.entity.Movie;
import org.capston.mymovie.entity.MovieTicket;
import org.capston.mymovie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class MovieService {
	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private MovieTicketService movieTicketService;

	public Movie addMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	public List<Movie> getAllMovie() {
		// return movieRepository.findAll();
		return StreamSupport.stream(movieRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	public Movie getByIdMovie(Long id) {
		// return movieRepository.findById(id).get();
		return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
	}

	@Transactional
	public Movie updateMovie(Movie movie, Long id) {
		Movie updateMovie = getByIdMovie(id);
		updateMovie.setMovie_name(movie.getMovie_name());
		updateMovie.setMovieImage(movie.getMovieImage());
		updateMovie.setCategory(movie.getCategory());
		updateMovie.setShow_time(movie.getShow_time());
		updateMovie.setMovieTicket(movie.getMovieTicket());
		return updateMovie;
	}

	public Movie deleteMovie(Long id) {
		Movie movie = getByIdMovie(id);
		movieRepository.delete(movie);
		return movie;
	}

	@Transactional
	public Movie addTicketToMovie(Long movieId, Long MovieTicketId) throws Exception {
		Movie movie = getByIdMovie(movieId);
		MovieTicket movieTicket = movieTicketService.getMovieTicketById(MovieTicketId);
		if (Objects.nonNull(movieTicket.getMovie())) {
			throw new MovieTicketAlreadyAssigned(MovieTicketId, movieId);
		}
		movie.addMovieTicket(movieTicket);
		movieTicket.setMovie(movie);
		return movie;
	}


}
