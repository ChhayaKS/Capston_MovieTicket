import { Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Movie } from '../shared/Movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService{
  [x: string]: any;
  baseUrl:string="http://localhost:1055/movie"

  constructor( private http:HttpClient) { }
  
  getAllMovie()
  {
    return this.http.get<Movie[]>(this.baseUrl+"/getAll_movie");
  }

  addMovie(movieData:Movie)
  {
    console.log("movieService"+movieData);
    return this.http.post(this.baseUrl+"/add_movie",movieData);
  }

getMovieById(id:any)
{
  return this.http.get<any>(this.baseUrl+"/getByid/"+id);
}

  updateMovie(movie:Movie,id:number)
  {
     return this.http.put(this.baseUrl+"/update_movie/"+id,movie)
  }
  deleteMovie(id:number)
  {
    return this.http.delete(this.baseUrl+"/delete_movie/"+id);
  }

  addTicketToMovie(movieId:number,movieTicketId:number)
  {
    return this.http.post(this.baseUrl+"/{movieId}/movieTickets/{movieTicketId}/add",+ movieId + movieTicketId);
  }

}
