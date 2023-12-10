package org.capston.mymovie.controller;

import java.util.List;

import org.capston.mymovie.Dto.CartDto;
import org.capston.mymovie.entity.Cart;
import org.capston.mymovie.service.CartService;
import org.capston.mymovie.service.MovieTicketService;
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
@RequestMapping("/cart")
@CrossOrigin("http://localhost:4200")
public class CartController {
	@Autowired
	private CartService cartService;
	@Autowired
	private MovieTicketService movieTicketService;
	@Autowired
	private UserService userService;

	
	@PostMapping("/add_cart")
	public ResponseEntity<CartDto> addCartDetails(CartDto cartDto)
	{
		Cart cart=cartService.addToCart(Cart.from(cartDto));
		return new ResponseEntity<>(CartDto.from(cart),HttpStatus.OK);
	}
	 
	@GetMapping("/getByid/{id}")
	public ResponseEntity<CartDto> getById(@PathVariable Long id)
	{
		Cart cart=cartService.getCartById(id);
		return new ResponseEntity<>(CartDto.from(cart),HttpStatus.OK);
	}
	
	@GetMapping("/getAll/{userId}")
	public List<Cart> getCart(@PathVariable long userId)
	{
		return cartService.getAllCartByUserId(userId);
	}
	
//	@GetMapping("/getAll_cart")
//	public ResponseEntity<List<CartDto>> getAllDetails()
//	{
//		List<Cart> carts=cartService.getAllCarts();
//		List<CartDto>cartDtos=carts.stream().map(CartDto::from).collect(Collectors.toList());
//		return new  ResponseEntity<>(cartDtos,HttpStatus.OK);
//	}
	
	@PutMapping("/update_cart/{id}")
	public ResponseEntity<CartDto> updateCart(@PathVariable Long id,@RequestBody CartDto cartDto)
	{
		Cart cart=cartService.updateCart(Cart.from(cartDto), id);
		return new ResponseEntity<>(CartDto.from(cart),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete_cart/{id}")
	public ResponseEntity<CartDto> deleteCart(@PathVariable Long id)
	{
		Cart cart=cartService.deleteCart(id);
		return new ResponseEntity<>(CartDto.from(cart),HttpStatus.OK);
	}
  
//	@GetMapping ("/add/{userId}/{movieTicketId}")
//	public ResponseEntity<CartDto> addMovieTicketToCart(@PathVariable Long cartId,@PathVariable Long movieTicketId)
//	{
//		Cart cart=cartService.addMovieTicketToCart(cartId, movieTicketId);
//		return  new ResponseEntity<>(CartDto.from(cart),HttpStatus.OK);
//	}
	
	@GetMapping ("/add/{cartId}/{userId}")
	public ResponseEntity<CartDto> addMovieTicketToCart(@PathVariable Long cartId,@PathVariable Long userId)
	{
		Cart cart=cartService.addMovieTicketToCart(cartId, userId);
		return  new ResponseEntity<>(CartDto.from(cart),HttpStatus.OK);
	}
	
	
//	@GetMapping ("/add/{movieTicketId}/{userId}")
//	public ResponseEntity<Cart> addMovieTicketToCart(@PathVariable("userId") Long userId,@PathVariable("movieTicketId") Long movieTicketId)
//	{
//	    MovieTicket movieTicket=movieTicketService.getMovieTicketById(movieTicketId);
//		User user=userService.getUserById(userId);
//		Cart cart=new Cart();
//		cart=cartService.addToCart(cart);
//		cart.setUnit(1);
//		cart.setTotalPrice(cart.getUnit()*((MovieTicket)movieTicket).getPrice());
//		//cart.setUser(user);
//		Cart addcart=cartService.addToCart(cart);
//		return  new ResponseEntity<Cart>(addcart,HttpStatus.OK);
//		
//	
//	}
	

}
