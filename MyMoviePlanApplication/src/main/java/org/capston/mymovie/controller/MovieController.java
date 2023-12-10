package org.capston.mymovie.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.capston.mymovie.Dto.MovieDto;
import org.capston.mymovie.entity.Movie;
import org.capston.mymovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
@CrossOrigin("http://localhost:4200")
public class MovieController {
	@Autowired
	private MovieService movieService;

	@PostMapping("/add_movie")
	public ResponseEntity<MovieDto> addMovie(@RequestBody MovieDto movieDto) {
		Movie movie = movieService.addMovie(Movie.from(movieDto));
		return new ResponseEntity<>(MovieDto.from(movie), HttpStatus.OK);
	}

	@GetMapping("/getByid/{id}")
	public ResponseEntity<MovieDto> getByID(@PathVariable Long id) {
		Movie movie = movieService.getByIdMovie(id);
		return new ResponseEntity<>(MovieDto.from(movie), HttpStatus.OK);

	}

	@GetMapping("/getAll_movie")
	public ResponseEntity<List<MovieDto>> getAllMovie() {
		List<Movie> movies = movieService.getAllMovie();
		List<MovieDto> movieDtos = movies.stream().map(MovieDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(movieDtos, HttpStatus.OK);
	}

	@PutMapping("/update_movie/{id}")
	public ResponseEntity<MovieDto> updateMovie(@PathVariable Long id, @RequestBody MovieDto movieDto) {
		Movie editmovie = movieService.updateMovie(Movie.from(movieDto), id);
		return new ResponseEntity<>(MovieDto.from(editmovie), HttpStatus.OK);
	}

	@DeleteMapping("/delete_movie/{id}")
	public ResponseEntity<MovieDto> deleteMovie(@PathVariable Long id) {
		Movie movie = movieService.deleteMovie(id);
		return new ResponseEntity<>(MovieDto.from(movie), HttpStatus.OK);
	}

	@PostMapping("{movieId}/movieTickets/{movieTicketId}/add")
	public ResponseEntity<MovieDto> addTicketToMovie(@PathVariable Long movieId,@PathVariable Long movieTicketId) throws Exception
	{
		Movie movie=movieService.addTicketToMovie(movieId, movieTicketId);
		return  new ResponseEntity<>(MovieDto.from(movie),HttpStatus.OK);
	}
	

	}
