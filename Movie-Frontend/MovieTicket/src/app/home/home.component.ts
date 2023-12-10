import { Component ,OnInit} from '@angular/core';
import { Movie } from '../shared/Movie';
import { MovieService } from '../services/movie.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
 movies:Movie[]=[]
 searchText:any
 id:any

 constructor(private movieService:MovieService,private router:ActivatedRoute){}

  ngOnInit(): void {
    
    this.movieService.getAllMovie().subscribe((res:any)=>
    {
      this.movies=res
    })
  }

  getData()
  {
    alert("Please Login First")
  }

}
