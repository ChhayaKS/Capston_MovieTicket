import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { Router,ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  username:string=''
  password:string=''
  constructor(private userService:UserService,private router:Router){}
  
  ngOnInit(): void { 

  }

  userLogin()
  {
    this.userService.getAll_user().subscribe(userList=>
      {
        console.log(userList)
        userList.forEach(data=>
          {
            console.log(data);
            console.log( "username" +this.username + "password" +this.password)

            if(data.email==this.username && data.password==this.password)
            {
              alert(" Login Successful...")
              console.log("login successful")
             localStorage.setItem('token',"hgdgfjbvjh-dnjdbvjh-klkioubhawgf-uidhrbvsejuhdvjbj-jfdhh");
              this.router.navigate(['user-page',data.id]);
            }else{
              console.log("Invalid Credentials, Enter valid data")

            }
          });
      });
  }

}
