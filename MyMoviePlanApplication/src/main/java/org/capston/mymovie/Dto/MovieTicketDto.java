package org.capston.mymovie.Dto;

import org.capston.mymovie.entity.Movie;
import org.capston.mymovie.entity.MovieTicket;

public class MovieTicketDto {
	private Long id;
	private int total_Ticket;
	private Double price;
	private Movie movie;

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTotal_Ticket() {
		return total_Ticket;
	}

	public void setTotal_Ticket(int total_Ticket) {
		this.total_Ticket = total_Ticket;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public static MovieTicketDto from(MovieTicket movieTicket) {
		MovieTicketDto movieTicketDto = new MovieTicketDto();
		movieTicketDto.setId(movieTicket.getId());
		movieTicketDto.setTotal_Ticket(movieTicket.getTotal_Ticket());
		movieTicketDto.setPrice(movieTicket.getPrice());
		movieTicketDto.setMovie(movieTicket.getMovie());
		return movieTicketDto;
	}

}
