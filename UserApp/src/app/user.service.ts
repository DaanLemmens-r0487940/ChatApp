import { Injectable } from '@angular/core';

import { Observable, of } from 'rxjs';

import { User } from './user';

import { USERS } from './mock-users';
import {HttpClient} from "@angular/common/http";

@Injectable({ providedIn: 'root' })
export class UserService {

  private usersUrl = 'http://localhost:8080/Controller?action=GetUsers'

  

  constructor(private http: HttpClient) { }

  getUsers(): Observable<User[]> {
    //return of(USERS);
    return (this.http.get<User[]>(this.usersUrl));
  }

  getUser(userId: string): Observable<User> {
    //return of (USERS.find(user => user.id === id));
    //const url = `${this.usersUrl}/?id=${id}`;
   // const url = `${this.usersUrl}/${id}`;
    return (this.http.get<User>(this.usersUrl + `&userId=${userId}`));


  }
}
