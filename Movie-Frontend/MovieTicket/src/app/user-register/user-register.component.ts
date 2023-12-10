import { Component ,OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../shared/User';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent implements OnInit{

  user:User={
    id:0,
    fullname:'',
    email:'',
    password:''
  }

  constructor(private userService:UserService,private router:Router){}
  
  ngOnInit(): void {}

  userRegistration(data:any)
  {
    alert("Thanks for register with us : " + data.fullname )
    this.user=data
    this.userService.addUser(this.user).subscribe(res=>
      {
        if(res==null)
        {
        alert("Registration failed! Try Again..")
      }else{
        alert("User Registered Successfully! Go to Login Page")
        // this.router.navigate(['user-login'])
      }
    })
  }

}
