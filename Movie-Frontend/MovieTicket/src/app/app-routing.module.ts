import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { HomeComponent } from './home/home.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { MovieHomeComponent } from './movie-home/movie-home.component';
import { CreateMovieComponent } from './create-movie/create-movie.component';
import { UpdateMovieComponent } from './update-movie/update-movie.component';
import { MovieTicketComponent } from './movie-ticket/movie-ticket.component';
import { CreateTicketComponent } from './create-ticket/create-ticket.component';
import { UpdateTicketComponent } from './update-ticket/update-ticket.component';
import { AppComponent } from './app.component';
import { ShowTimeComponent } from './show-time/show-time.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { UserPageComponent } from './user-page/user-page.component';
import { CartPageComponent } from './cart-page/cart-page.component';
import { PaymentComponent } from './payment/payment.component';

const routes: Routes = [
  {path:"",component:HomeComponent},
  {path:"admin-login",component:AdminLoginComponent},
  {path:"home",component:HomeComponent},
  {path:"home/admin-login",component:AdminLoginComponent},
  {path:"admin-home",component:AdminHomeComponent},
  {path:"admin-home/movieList", component:MovieHomeComponent},
  {path:"admin-home/movieList/delete", component:MovieHomeComponent},
  {path:"admin-home/movie-home",component:MovieHomeComponent},
  {path:"admin-home/movie-home/create-movie",component:CreateMovieComponent},
  {path:"admin-home/movie-home/getAllMovie()",component:CreateMovieComponent},
  {path:"admin-home/movie-home/update-movie/:id",component:UpdateMovieComponent},
  {path:"update-movie/:id",component:UpdateMovieComponent},
  {path:"admin-home/movie-ticket",component:MovieTicketComponent},
  {path:"admin-home/movie-home/movie-ticket",component:MovieTicketComponent},
  {path:"admin-home/movie-home/movie-ticket/create-ticket",component:CreateTicketComponent},
  {path:"admin-home/movie-home/movie-ticket/update-ticket/:id",component:UpdateTicketComponent},
  {path:"update-ticket/:id",component:UpdateTicketComponent},
  {path:"show-time",component:ShowTimeComponent},
  {path:"user-login",component:UserLoginComponent},
  {path:"home/user-login",component:UserLoginComponent},
  {path:"home/user-login/user-register",component:UserRegisterComponent},
  {path:"user-login/user-page",component:UserPageComponent},
  {path:"user-login/user-register/user-page",component:UserPageComponent},
  {path:"user-page",component:UserPageComponent},
  {path:"user-page/:id",component:UserPageComponent},
  {path:"user-page/getCartData()",component:UserPageComponent},
  {path:"user-page/cart-page/:id",component:CartPageComponent},
  {path:"cart/:uid",component:CartPageComponent},
  {path:"payment/:total",component:PaymentComponent},
  {path:"user-page/cart/id",component:CartPageComponent},
  {path:"payment",component:PaymentComponent}
  


  

];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
