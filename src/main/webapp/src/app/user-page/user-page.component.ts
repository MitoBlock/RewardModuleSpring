import { Component, OnInit } from '@angular/core';
import { SelectMultipleControlValueAccessor } from '@angular/forms';
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
  showTimer = false;
  counter = 5;

  constructor(
    private userService: UserService,
    private router: Router,
    private route: ActivatedRoute,
  ) {}

  // TODO: add functionality of some kind
  handleMainSubmit(info: any) {
    this.router.navigate(['/user', this.id, 'offers']);
  }

  handleOffersClick() {
    this.router.navigate(['/user', this.id, 'offers']);
  }

  handleMakeTacos() {
    const rewardToken: RewardToken = {
      activityName: 'Challenge: Make Tacos',
      activityCreator: 'Sukhdev',
      publicAddress: this.accountAddress,
      result: {
        score: 10,
        message: 'Well done!',
      },
      reward: {
        type: 'Membership',
        value: 1,
        targetPartner: 'Jacks Restaurant',
      },
    };


    this.showTimer = true;
    let timer = setInterval(() => {
      if (this.counter <= 0) {
        clearInterval(timer);
        this.showTimer = false
          this.userService
            .addToken(rewardToken, this.accountId)
            .subscribe((account) => {
              this.rewardTokens = account.rewardTokens;
            });
      }
      this.counter--
    }, 1000);

  }

  // handle learned tacos button click
  learnedTacos() {
    const rewardToken: RewardToken = {
      activityName: 'Learn to make tacos',
      activityCreator: 'Sukhdev',
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
    };
    this.userService
      .addToken(rewardToken, this.accountId)
      .subscribe((account) => {
        console.log({ account });
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
