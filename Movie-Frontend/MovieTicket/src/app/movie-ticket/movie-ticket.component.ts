import { Component,Injectable,OnInit} from '@angular/core';
import { MovieTicket } from '../shared/MovieTicket';
import { MovieticketService } from '../services/movieticket.service';
import { Router } from '@angular/router';
import { Movie } from '../shared/Movie';
import { MovieService } from '../services/movie.service';
import { Inject } from '@angular/core';
import { filter, find } from 'rxjs';

@Component({
  selector: 'app-movie-ticket',
  templateUrl: './movie-ticket.component.html',
  styleUrls: ['./movie-ticket.component.css']
})
@Injectable({
  providedIn: 'root'
})

export class MovieTicketComponent implements OnInit {

allTickets:MovieTicket[]=[]

constructor(private movieTicketService:MovieticketService,private router:Router,private movieService:MovieService){}

  ngOnInit(): void {
    
    this.getAllTickets();

  }
  
 

getAllTickets(){
  this.movieTicketService.getAllTicket().subscribe(res=>
    {
      console.log(res)
      res.forEach(data=>
        {
          console.log(data);
          this.allTickets.push(data);
        })
    })
}
  // ticket_id(movie_id: any, ticket_id: any) {
  //   throw new Error('Method not implemented.');
  // }


updateTicket(id:number)
{
  this.router.navigate(['update-ticket',id])
}


  
deleteTicket(id:number){
  console.log(id)
  this.movieTicketService.deleteTicket(id).subscribe(res=>
    {
      console.log(res)

        alert("id" +id + ": Tickets Deleted ")
      
    });
}



}
