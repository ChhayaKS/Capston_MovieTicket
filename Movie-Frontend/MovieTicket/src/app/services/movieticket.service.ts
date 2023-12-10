import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MovieTicket } from '../shared/MovieTicket';

@Injectable({
  providedIn: 'root'
})
export class MovieticketService {

  baseUrl:string="http://localhost:1055/ticket"
  movie: any;

  constructor(private http:HttpClient) { }

 addTicket(ticket:MovieTicket)
 {
return this.http.post(this.baseUrl+"/add_ticket",ticket);
 }
  
getTicketById(id:any)
{
  return this.http.get<any>(this.baseUrl+"/get_ticket/"+id);
}
 
getAllTicket()
{
  return this.http.get<MovieTicket[]>(this.baseUrl+"/getAll_ticket");
}

updateTicket(ticket:MovieTicket,id:number)
{
 return this.http.put(this.baseUrl+"/update_ticket/"+id,ticket);
}

deleteTicket(id:number)
{
  return this.http.delete(this.baseUrl+"/delete/"+id);
}
}
