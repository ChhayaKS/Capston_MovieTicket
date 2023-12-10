package org.capston.mymovie.repository;

import java.util.List;

import org.capston.mymovie.entity.MovieTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTicketRepository extends JpaRepository<MovieTicket, Long>{

	List<MovieTicket> findAllMovieTicketById(Long id);
	
}
