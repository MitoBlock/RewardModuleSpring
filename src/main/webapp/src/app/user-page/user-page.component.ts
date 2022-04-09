import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RewardToken } from '../models/reward-token';
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
  rewardTokens: RewardToken[] = [];
  accountId = -1;
  id = -1;

  constructor(
    private userService: UserService,
    private router: Router,
    private route: ActivatedRoute,
  ) {}

  handleMainSubmit(info: any) {
    this.router.navigate(['/user', this.id, 'offers']);
  }

  learnedTacos() {
    const tokenId = 1;
    const rewardToken: RewardToken = {
      // id: tokenId,
      // dateTime: '',
      activityName: 'Learn to make tacos',
      activityCreator: 'Sukhdev Banwait',
      publicAddress: this.accountAddress,
      result: {
        score: 10,
        message: 'Well done!',
      },
      reward: {
        type: 'Discount',
        value: 5,
        targetPartner: 'Little Chef',
        // expiryDate : set in spring to be in 5 days
      },
    } 
    this.userService.addToken(rewardToken, this.accountId ).subscribe((account) => {
      console.log( { account } );
      this.rewardTokens = account.rewardTokens;
      console.log({ rtokens: this.rewardTokens });
    });
  }

  ngOnInit() {
    console.log({ tokens: this.rewardTokens });
    this.id = this.route.snapshot.params['id'];
    this.userService.getUser(this.id).subscribe((user: User) => {
      this.name = user.name;
      this.accountAddress = user.account?.publicAddress ?? '';
      this.accountId = user.account?.id ?? -1;
      this.rewardTokens = user.account?.rewardTokens ?? [];
      console.log({ newUserGetted: user });
      // this.router.navigate([`/${newUser.id}`]);
    });
  }
}
