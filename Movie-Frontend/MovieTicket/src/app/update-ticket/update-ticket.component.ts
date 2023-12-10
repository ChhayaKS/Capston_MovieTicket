import { Component, OnInit } from '@angular/core';
import { MovieTicket } from '../shared/MovieTicket';
import { MovieticketService } from '../services/movieticket.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update-ticket',
  templateUrl: './update-ticket.component.html',
  styleUrls: ['./update-ticket.component.css']
})
export class UpdateTicketComponent implements OnInit{
  
  ticketUpdate:MovieTicket={
    id: 0,
    total_Ticket: 0,
    price: 0,
    movie: []
  }
  id:any

  constructor( private movieTicketService:MovieticketService,private route:ActivatedRoute){}


  ngOnInit(): void {
    this.id=this.route.snapshot.paramMap.get('id')
    this.movieTicketService.getTicketById(this.id).subscribe(res=>
      {
        console.log(res);
        this.ticketUpdate=res
      })
  }



updateTicketDetails(data:MovieTicket)
{
  this.ticketUpdate=data
  this.ticketUpdate.id=this.id
  this.movieTicketService.updateTicket(this.ticketUpdate,this.ticketUpdate.id).subscribe(res=>
    {
      alert("Ticket details updated...")
    })
}

}
