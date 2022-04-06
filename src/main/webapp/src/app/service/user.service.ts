import { HttpClient } from "@angular/common/http";
import { EventEmitter, Injectable } from "@angular/core";
import { User } from "../models/user";

@Injectable()
export class UserService {
	constructor(private http: HttpClient){}
	
	addUser(user : User){
		return this.http.post('/api/user', user);
	}
	
	onUserAdded = new EventEmitter<User>();
}