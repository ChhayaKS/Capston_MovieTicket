import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Admin } from '../shared/Admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
 
baseUrl:string="http://localhost:1055/login"

  constructor(private http:HttpClient) { }

  getAllAdmin()
  {
    // return this.http.get<Admin[]>(this.baseUrl+"/getAll_admin");
    return this.http.get<Admin[]>(this.baseUrl+"/getAll_admin");

  }

  addAdmin(AdminData:Admin)
  {
    return this.http.post(this.baseUrl+"/add_admin",AdminData);

  }
}
