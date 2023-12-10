package org.capston.mymovie.service;

import java.util.List;

import org.capston.mymovie.Exception.UserNotFoundException;
import org.capston.mymovie.entity.MovieTicket;
import org.capston.mymovie.entity.User;
import org.capston.mymovie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MovieTicketService movieTicketService;

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	@Transactional
	public User updateUser(Long id, User user) {
		User editUser = getUserById(id);
		editUser.setFullname(user.getFullname());
		editUser.setEmail(user.getEmail());
		editUser.setPassword(user.getPassword());
		return editUser;
	}

	@Transactional
	public User deleteUser(Long id) {
		User user = getUserById(id);
		userRepository.delete(user);
		return user;
	}

	@Transactional
	public User addTicketForUser(Long userId, Long movieTicketId) {
		User user = getUserById(userId);
		MovieTicket movieTicket = movieTicketService.getMovieTicketById(movieTicketId);
		user.addmovieTikcet(movieTicket);
     movieTicket.getUser();
		return user;
	}
}
