import { Component,OnInit } from '@angular/core';
import { Movie } from '../shared/Movie';
import { Router } from '@angular/router';
import { MovieService } from '../services/movie.service';

@Component({
  selector: 'app-create-movie',
  templateUrl: './create-movie.component.html',
  styleUrls: ['./create-movie.component.css']
})
export class CreateMovieComponent implements OnInit {
  ngOnInit(): void {}

  movie:Movie={
    id: 0,
    movie_name: '',
    movieImage: '',
    category: '',
    show_time: '',
    movieTicket: []
  }

  constructor (private movieService:MovieService,private router:Router)
  {}

  movieRegistration(data:any)
  {
    this.movie=data
    this.movieService.addMovie(this.movie).subscribe(res=>
      {
        if(res!=null)
        {
          alert("Movie Added Successfully")
        }else{
          alert("Registration Failed.......")
        }
      })

  }

}
