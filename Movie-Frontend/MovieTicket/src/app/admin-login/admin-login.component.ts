import { Component,OnInit } from '@angular/core';
import { AdminService } from '../services/admin.service';
import { Router } from '@angular/router';
import { ImageLoader } from '@angular/common';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit{

  image='assets/background.jpeg';

constructor(private adminService:AdminService, private router:Router)
{}

username:string='';
password:string='';
  ngOnInit(): void {
  }

  adminLogin(){
  
      this.adminService.getAllAdmin().subscribe( adminList => 
         {
      console.log(adminList)
      adminList.forEach( data => 
        {
      console.log(data);
      console.log("username "+this.username+" password"+this.password)
      if(data.email == this.username && data.password == this.password)
      {
          alert("Admin Login Successful....")
          console.log("login success")
          localStorage.setItem('token',"hgdgfjbvjh-dnjdbvjh-klkioubhawgf")
          this.username=="admin@gmail.com" ? localStorage.setItem('userType','admin') : localStorage.setItem('userType','user')
          this.router.navigate(['admin-home']);
         }else{
            alert("Admin login Unsuccessful...  Invalid Credentials, Enter valid data")
            console.log("Invalid Credentials, Enter valid data")
        }
      }); 
    });  
}
}
