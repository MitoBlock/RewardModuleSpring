import { HttpClient } from "@angular/common/http";
import { EventEmitter, Injectable } from "@angular/core";
import { User } from "../models/user";

@Injectable()
export class UserService {
	
	onUserAdded = new EventEmitter<User>();
	
	constructor(private http: HttpClient){}
	
	addUser(user : User){
		return this.http.post('/api/user', user);
	}
	
	
}