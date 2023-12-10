import { Movie } from "./Movie"

export interface MovieTicket
{
    id:number
    total_Ticket:number
    price:number
    movie:Movie[]
}