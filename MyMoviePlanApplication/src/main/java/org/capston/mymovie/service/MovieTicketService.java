package org.capston.mymovie.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.capston.mymovie.Exception.MovieTicketNotFoundException;
import org.capston.mymovie.entity.MovieTicket;
import org.capston.mymovie.repository.MovieTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class MovieTicketService {

	@Autowired
	private MovieTicketRepository movieTicketRepository;

	public MovieTicket addMovieTicket(MovieTicket movieTicket) {
		return movieTicketRepository.save(movieTicket);
	}

	public MovieTicket getMovieTicketById(Long id) {
		// return movieTicketRepository.findById(id).get();
		return movieTicketRepository.findById(id).orElseThrow(() -> new MovieTicketNotFoundException(id));
	}
	public List<MovieTicket> getAllMovieTicketById(Long id)
	{
		return movieTicketRepository.findAllMovieTicketById(id);

	}
	
	public List<MovieTicket> getAllMovieTicket() {
		// return movieTicketRepository.findAll();
		return StreamSupport.stream(movieTicketRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Transactional
	public MovieTicket upadteMovieTicket(MovieTicket movieTicket, Long id) {
		MovieTicket mv = getMovieTicketById(id);
		mv.setTotal_Ticket(movieTicket.getTotal_Ticket());
		mv.setPrice(movieTicket.getPrice());
		mv.setMovie(movieTicket.getMovie());
		return mv;
	}

	
	public MovieTicket deleteMovieTicket(Long id) {
		MovieTicket movieTicket = getMovieTicketById(id);
		movieTicketRepository.delete(movieTicket);
		return movieTicket;
	}

}
