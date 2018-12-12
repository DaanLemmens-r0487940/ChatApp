import { NgModule }       from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms';

import { AppComponent }         from './app.component';
import { DashboardComponent }   from './dashboard/dashboard.component';
import { UserDetailComponent }  from './user-detail/user-detail.component';
import { UsersComponent }      from './users/users.component';

import { AppRoutingModule }     from './app-routing.module';
import {HttpClientModule} from "@angular/common/http";
import {UserService} from "./user.service";

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  declarations: [
    AppComponent,
    DashboardComponent,
    UsersComponent,
    UserDetailComponent
  ],
  providers: [UserService],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
