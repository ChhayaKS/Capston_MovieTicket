package org.capston.mymovie.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.capston.mymovie.Dto.UserDto;
import org.capston.mymovie.entity.Admin;
import org.capston.mymovie.entity.User;
import org.capston.mymovie.service.AdminService;
import org.capston.mymovie.service.UserService;
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
@RequestMapping("/login")
@CrossOrigin("http://localhost:4200")
public class LoginController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private UserService userService;

	// ************ADMIN Operation**************

	@PostMapping("/add_admin")
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminService.addAdmin(admin);
	}

	@GetMapping("/getAll_admin")
	public List<Admin> getAllAdmin() {
		return adminService.getAllAdmin();
	}

	// ************** User Operation ************

	@PostMapping("/add_user")
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
		User user = userService.addUser(User.from(userDto));
		return new ResponseEntity<>(UserDto.from(user), HttpStatus.OK);
	}

	@GetMapping("/getAll_user")
	public ResponseEntity<List<UserDto>> getAllUser() {
		List<User> users = userService.getAllUser();
		List<UserDto> userDtos = users.stream().map(UserDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(userDtos, HttpStatus.OK);
	}

	@GetMapping("/getuser/{id}")
	public ResponseEntity<UserDto> getUserByid(@PathVariable Long id) {
		User user = userService.getUserById(id);
		return new ResponseEntity<>(UserDto.from(user), HttpStatus.OK);
	}

	@PutMapping("/update_user/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
		User updateUser = userService.updateUser(id, User.from(userDto));
		return new ResponseEntity<>(UserDto.from(updateUser), HttpStatus.OK);

	}

	@DeleteMapping("/delete_user/{id}")
	public ResponseEntity<UserDto> deleteUser(@PathVariable Long id) {
		User user = userService.deleteUser(id);
		return new ResponseEntity<>(UserDto.from(user), HttpStatus.OK);

	}
	
	@PostMapping("/{userId}/movietickes/{movieTicketId}/add")
	public ResponseEntity<UserDto> addUserToMovieTicket(@PathVariable Long userId,@PathVariable Long movieTicketId)
	{
		User user=userService.addTicketForUser(userId, movieTicketId);
		return  new ResponseEntity<>(UserDto.from(user),HttpStatus.OK);
	}

}
