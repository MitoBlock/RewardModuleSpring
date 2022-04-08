import { HttpClient } from "@angular/common/http";
import { EventEmitter, Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { User } from "../models/user";
import { api } from "./api";

@Injectable()
export class UserService {
	
	onUserAdded = new EventEmitter<User>();
	
	constructor(private http: HttpClient){}
	
	addUser(user : User) : Observable<User> {
		return this.http.post<User>(`${api}user`, user);
	}

	getUser(id : number) {
		return this.http.get<User>(`${api}user/${id}`);
	}
	
	
}