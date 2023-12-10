import { Component ,OnInit} from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit{
  ngOnInit(): void {
    localStorage.setItem('token',' ');
  }

  constructor(private router:Router)
  {

  }
  show()
  {
  this.router.navigate(['show-time']);
  }
  movihomu()
 {
   alert("Admin.. Do you want to Logout???")
 }

 adm()
 {
  this.router.navigate(['/admin-home']);
 }

}
