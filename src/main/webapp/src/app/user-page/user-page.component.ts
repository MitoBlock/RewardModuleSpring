import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../models/user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css'],
})
export class UserPageComponent implements OnInit {
  name = '';
  accountAddress = '';
  rewardTokens: string[] = [];
  id = -1

  constructor(
    private userService: UserService,
    private router: Router,
    private route: ActivatedRoute,
  ) {}

  handleMainSubmit(info : any) {
    this.router.navigate(['/user', this.id, 'offers']);
  }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.userService.getUser(this.id).subscribe((user: User) => {
      this.name = user.name;
      this.accountAddress = user.account?.publicAddress ?? '';
      console.log({ newUserGetted: user });
      // this.router.navigate([`/${newUser.id}`]);
    });
  }
}
