import { MovieTicket } from "./MovieTicket"

export interface Movie
{
    id:number
    movie_name:string
    movieImage:string
    category:string
    show_time:string
    movieTicket:MovieTicket[]
}