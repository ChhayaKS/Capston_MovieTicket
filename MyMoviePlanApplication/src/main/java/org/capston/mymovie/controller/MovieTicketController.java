package org.capston.mymovie.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.capston.mymovie.Dto.MovieTicketDto;
import org.capston.mymovie.entity.MovieTicket;
import org.capston.mymovie.service.MovieService;
import org.capston.mymovie.service.MovieTicketService;
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
@RequestMapping("/ticket")
@CrossOrigin("http://localhost:4200")
public class MovieTicketController {
	@Autowired
	private MovieTicketService movieTicketService;

	@Autowired
	private MovieService movieService;

	@PostMapping("/add_ticket")
	public ResponseEntity<MovieTicketDto> addMovieTicket(@RequestBody MovieTicketDto movieTicketDto) {
		MovieTicket movieTicket = movieTicketService.addMovieTicket(MovieTicket.from(movieTicketDto));
		return new ResponseEntity<>(MovieTicketDto.from(movieTicket), HttpStatus.OK);

	}

	@GetMapping("/get_ticket/{id}")
	public ResponseEntity<MovieTicketDto> getMovieTicketById(@PathVariable Long id) {
		MovieTicket movieTicket = movieTicketService.getMovieTicketById(id);
		movieService.getByIdMovie(id);
		return new ResponseEntity<>(MovieTicketDto.from(movieTicket), HttpStatus.OK);
	}

	@GetMapping("/getAll_ticket")
	public ResponseEntity<List<MovieTicketDto>> getAllMovieTicket() {
		List<MovieTicket> movieTickets = movieTicketService.getAllMovieTicket();
		List<MovieTicketDto> movieTicketDtos = movieTickets.stream().map(MovieTicketDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(movieTicketDtos, HttpStatus.OK);
	}

	@PutMapping("/update_ticket/{id}")
	public ResponseEntity<MovieTicketDto> UpdateMovie(@PathVariable Long id,
			@RequestBody MovieTicketDto movieTicketDto) {
		MovieTicket movieTicket = movieTicketService.upadteMovieTicket(MovieTicket.from(movieTicketDto), id);
		return new ResponseEntity<>(MovieTicketDto.from(movieTicket), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<MovieTicketDto> deleteMovie(@PathVariable Long id) {
		MovieTicket movieTicket = movieTicketService.deleteMovieTicket(id);
		return new ResponseEntity<>(MovieTicketDto.from(movieTicket), HttpStatus.OK);
	}

}
