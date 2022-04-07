import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service'
import { User } from '../models/user'

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {
	
	addUserName: string = ''

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }
  
  onUserAdd(data: any) {
		let user: any = new User(data.name);
		
		this.userService.addUser(user).subscribe(
			(newUser: any) => {
				this.addUserName = '';
				
				this.userService.onUserAdded.emit(newUser);
			}
		)
	}

}
