import { Component,OnInit } from '@angular/core';
import { Movie } from '../shared/Movie';
import { MovieService } from '../services/movie.service';
import { ActivatedRoute,Route,Router } from '@angular/router';
import { MovieticketService } from '../services/movieticket.service';
import { UserService } from '../services/user.service';
import { User } from '../shared/User';
import { MovieTicket } from '../shared/MovieTicket';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit  {
  movies:Movie[]=[]
  ticket:MovieTicket[]=[]
  u_id:any
  movieTicket_Id:any
  cartId:any

 
  constructor(private movieService:MovieService,private route:ActivatedRoute,private movieTicketService:MovieticketService,private userService:UserService,private router:Router,private cartService:CartService){
  }
 
   ngOnInit(): void {
     this.u_id=this.route.snapshot.paramMap.get('id')
     this.movieService.getAllMovie().subscribe(res=>
     {
      console.log(res)
       this.movies=res
     })
  
   }
 
  //  getTicket(movieTicketId:number)
  //  {

  //   this.movieTicketId=this.route.snapshot.paramMap.get('id')
  //   this.movieTicketService.getTicketById(movieTicketId).subscribe(pic=>
  //    {
  //      console.log(pic)
  //      this.ticket=pic
  //    })
  //  }


   addCartData(cart:any)
   {
    this.cartId=cart
    this.cartService.addTikcetToCart(this.u_id,this.cartId).subscribe(res=>
      {
        console.log(res)
        alert("Movie Suceessfully added to cart")
      })
   }


  //  addTicketToCart(cart:any)
  //  {
  //       this.cartId=this.cartService.getCart(this.cartId)
  //       this.u_id=this.userService.getUserById(this.u_id)
  //       this.cartService.addTikcetToCart(this.cartId,this.u_id).subscribe(res=>
  //         {
  //           console.log(res)
  //           alert("TicketAddedTocart...")
  //         })
  //  } 

  

   getCartData()
   {
    this.router.navigate(['cart',this.u_id,]);
   }
 

}
