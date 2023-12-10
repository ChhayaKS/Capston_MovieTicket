import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from '../shared/Movie';
import { MovieService } from '../services/movie.service';

@Component({
  selector: 'app-movie-home',
  templateUrl: './movie-home.component.html',
  styleUrls: ['./movie-home.component.css']
})
export class MovieHomeComponent implements OnInit {
movieList: Movie[]=[]

constructor(private movieService:MovieService,private router:Router){}


  ngOnInit(): void {
    this.getMovieTable();
  }

  getMovieTable()
  {
    this.movieService.getAllMovie().subscribe(res=>
      {
        console.log(res);
        res.forEach(data=>
          {
            console.log(data);
            this.movieList.push(data);
          })
      })
  }

  updateMovie(id:number)
  {
    this.router.navigate(['update-movie',id])
  }

  deleteMovie(id:number)
  {
     this.movieService.deleteMovie(id).subscribe(res=>
      {
        alert("id "+id+ " : Movie Deleted.")
    
      });
 }
addTicketForMovie(movieId:any,movieTicketId:any)
{
  this.movieService.addTicketToMovie(movieId,movieTicketId).subscribe(res=>
    {
      if(res!=null)
      {
        alert("MovieTickets Added for movie")
      }
      else
      {
        alert("Registration failed..plz try again")
      }
    })
}

 movihomu()
 {
   alert("Admin.. Do you want to Logout???")
 }

 adm()
 {
  this.router.navigate(['admin-home']);
 }

}
