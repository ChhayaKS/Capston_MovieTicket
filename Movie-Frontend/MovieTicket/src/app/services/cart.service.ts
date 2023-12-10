import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MovieTicket } from '../shared/MovieTicket';
import { MovieticketService } from './movieticket.service';
import { Movie } from '../shared/Movie';
import { MovieService } from './movie.service';
import { User } from '../shared/User';
import { UserService } from './user.service';
@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http:HttpClient) { }
  baseUrl:String="http://localhost:1055/cart"

  getCart(id:any)
  {
   return this.http.get(this.baseUrl+"/getByid/"+id);
  }
  addToCart(carts:any){
    return this.http.post(this.baseUrl+"/add_cart",carts);
  }
  addTikcetToCart(movieTicketId:any,uid:any)
  {
    return this.http.get(this.baseUrl+"/add/"+movieTicketId+"/"+uid);
  }
  updateCart(cart:any, cid:any){
    return this.http.put<any>(this.baseUrl+"/update-cart/"+cid,cart)
  }
  deleteCart(cid:any){
    return this.http.delete<any>(this.baseUrl+"/delete/"+cid)
  }

}
