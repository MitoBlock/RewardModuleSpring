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
  accountId = -1;
  id = -1

  constructor(
    private userService: UserService,
    private router: Router,
    private route: ActivatedRoute,
  ) {}

  handleMainSubmit(info : any) {
    this.router.navigate(['/user', this.id, 'offers']);
  }

  learnedTacos() {
    const tokenId = 1
    this.userService.addToken(this.accountId, tokenId).subscribe((account) => {
      this.rewardTokens = account.rewardTokens.map(rt => rt.publicAddress) ?? [];
      console.log({ rtoks : this.rewardTokens})
    } );
  }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.userService.getUser(this.id).subscribe((user: User) => {
      this.name = user.name;
      this.accountAddress = user.account?.publicAddress ?? '';
      this.accountId = user.account?.id ?? -1;
      this.rewardTokens = user.account?.rewardTokens?.map(rt => rt.publicAddress) ?? [];
      console.log({ newUserGetted: user });
      // this.router.navigate([`/${newUser.id}`]);
    });
  }
}
