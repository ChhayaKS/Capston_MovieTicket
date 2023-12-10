package org.capston.mymovie.repository;


import org.capston.mymovie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long>{
//    Optional<Movie> findTicketForMovie(Long movieId, Long movieTicketId);
}
