import { Component,Inject,OnInit } from '@angular/core';
import { CartService } from '../services/cart.service';
import { Cart } from '../shared/Cart';
import { Movie } from '../shared/Movie';
import { MovieService } from '../services/movie.service';
import { User } from '../shared/User';
import { UserService } from '../services/user.service';
import { MovieTicket } from '../shared/MovieTicket';
import { MovieticketService } from '../services/movieticket.service';
import { Router,ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.css']
})
export class CartPageComponent implements OnInit{

  movies:Movie[]=[]
  ticket:MovieTicket[]=[]

  u_id:any
  movieTicket_Id:any
  movieId:any
  user:User={
    id: 0,
    fullname: '',
    email: '',
    password: ''
  }
  grandTotal:any
  unit:any
  carts: any;


  ngOnInit(): void {
    this.u_id=this.route.snapshot.paramMap.get('uid')
    this.getCart()
  }


constructor(private cartService:CartService,private movieService:MovieService,private movieTicketService:MovieticketService,private userService:UserService,private route:ActivatedRoute,private router:Router){}

findTotalPrice()
{
  this.grandTotal=0;
  this.cartService.getCart(this.u_id).subscribe((carts)=>
  {
   for(let cart of this.carts)
   {
    this.grandTotal+=cart.price
   }
  })
}

getCart()
{
this.userService.getUserById(this.u_id).subscribe((data)=>
  {
    this.user=data
    console.log(data)
    this.cartService.getCart(data.id).subscribe(res=>
      {
        this.carts=res
        console.log(res)
        // this.movieTicketService.getTicketById(this.movieTicket_Id).subscribe(les=>
        //   {
        //     this.ticket=les
        //     console.log(les)
        //     this.movieService.getMovieById(this.movieId).subscribe(mo=>
        //       {
        //         this.movies=mo
        //         console.log(mo)
        //       })
        //   })
      })
  })
}


decreseQuantity(cart:any,id:any)
  {
    cart.unit-=1;
    cart.price=cart.unit*cart.movieticket.price;
    this.updateCart(cart,id);
   
  }
  

  increseQuantity(cart:any, id:any)
  {
    cart.unit+=1;
    cart.price=cart.unit*cart.movieticket.price;
    this.updateCart(cart,id);
  }

  updateCart(cart:any,cartId:any)
  {
    this.cartService.updateCart(cart,cartId).subscribe(cart=>
      {
        console.log(cart)
        this.getCart();
      })

  }
 
  deleteCart(id:any)
  {
    this.cartService.deleteCart(id).subscribe(res=>
      {
        alert("Item Deleted")
      })
  }

}
