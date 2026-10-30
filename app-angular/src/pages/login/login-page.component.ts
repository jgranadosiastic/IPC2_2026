import { Component, OnInit, signal } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/security/auth.service';

@Component({
  selector: 'app-login-page',
  imports: [],
  templateUrl: './login-page.component.html',
})
export class LoginPageComponent implements OnInit {
  alreadyLoggedIn = signal<boolean>(false);
  currentRole = signal<string[]>([]);
  currentUsername = signal<string | undefined>(undefined);


  constructor(private router: Router, private authService: AuthService) {

  }

  ngOnInit(): void {
    this.refreshUserData();
  }

  login(username: string, password: string): void {
    const loginRequest = {
      username: username,
      password: password
    };

    this.authService.login(loginRequest).subscribe({
      next: (loginResponse) => {
        this.authService.saveToken(loginResponse.token);
        this.router.navigate(['/events']);
      },
      error: (error: any) => {
        console.log(error);
      }
    });


  }

  logout(): void {
    this.authService.logout();
    this.refreshUserData();

  }

  refreshUserData(): void {
    this.alreadyLoggedIn.set(this.authService.isLoggedIn());
    this.currentRole.set(this.authService.getRoles());
    this.currentUsername.set(this.authService.getUserName());
  }
}