import { Component, OnInit } from '@angular/core';
import { MovieTicket } from '../shared/MovieTicket';
import { MovieticketService } from '../services/movieticket.service';
import { Router } from '@angular/router';
import { MovieService } from '../services/movie.service';

@Component({
  selector: 'app-create-ticket',
  templateUrl: './create-ticket.component.html',
  styleUrls: ['./create-ticket.component.css']
})
export class CreateTicketComponent implements OnInit{
  
  ngOnInit(): void {
  }

  ticket:MovieTicket={
    id: 0,
    total_Ticket: 0,
    price: 0,
    movie: []
  }

  constructor(private movieTicketService:MovieticketService, private router:Router,private movieService:MovieService){}
  ticket_id: any
  movie_id:any
movieTicketRegistration(data:any)
{
  this.ticket=data
  this.movieTicketService.addTicket(this.ticket).subscribe(res=>
    {
      if(res!=null)
      {
        alert("Movie Ticket Added Successfully....")
      }else{
        alert("Movie Ticket Added Successfully....")

      }
    })
}

addTicketToMovie(movie_id:number,ticket_id:number)
{
  this.ticket_id=movie_id
  this.movieService.addTicketToMovie(movie_id,ticket_id).subscribe(res=>
    {
      alert("Ticket added for movie")
    })
}


}
