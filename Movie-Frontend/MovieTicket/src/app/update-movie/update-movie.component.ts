import { Component,OnInit, QueryList } from '@angular/core';
import { Movie } from '../shared/Movie';
import { MovieService } from '../services/movie.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update-movie',
  templateUrl: './update-movie.component.html',
  styleUrls: ['./update-movie.component.css']
})
export class UpdateMovieComponent implements OnInit{
movieUpdate:Movie={
  id: 0,
  movie_name: '',
  movieImage: '',
  category: '',
  show_time: '',
  movieTicket: [],
}
id:any
constructor(private movieService:MovieService,private route:ActivatedRoute){}

  ngOnInit(): void {
    this.id=this.route.snapshot.paramMap.get('id')
    this.movieService.getMovieById(this.id).subscribe(res=>
      {
        this.movieUpdate=res
      })
  }
  editMovieDetails(data:Movie)
  {
    this.movieUpdate=data
    this.movieUpdate.id=this.id
    this.movieService.updateMovie(this.movieUpdate,this.movieUpdate.id).subscribe(res=>
      {
        alert("Movie Details Updated..")
      })
    }

    
 
}
