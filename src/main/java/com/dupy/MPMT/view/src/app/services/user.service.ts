import {Injectable} from '@angular/core';
import {HttpClient,} from '@angular/common/http';
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrl = 'http://localhost:8080/api';
  private headers: any;

  constructor(private http: HttpClient, private authservice: AuthService) {
    this.headers = {'Content-Type': 'application/json', 'Authorization': 'Bearer ' + authservice.token};
  }

  register(user: any) {
    return this.http.post<any>(`${this.apiUrl}/register`, user, {headers: this.headers});
  }

  login(credentials: any) {
    return this.http.post<any>(`${this.apiUrl}/login`, credentials, {headers: this.headers});
  }

  SignOut() {
    return this.http.post(`${this.apiUrl}/logout`, {}, {headers: this.headers});
  }

  all() {
    return this.http.get<any[]>(`${this.apiUrl}/users`, {headers: this.headers});
  }
}
