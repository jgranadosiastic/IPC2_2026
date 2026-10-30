import { Component } from "@angular/core";
import { EventsListComponent } from "../../../components/events/events-list/events-list.component";
import { RouterLink } from "@angular/router";
import { AuthService } from "../../../services/security/auth.service";

@Component({
  selector: 'app-events-page',
  templateUrl: './events-page.component.html',
  imports: [EventsListComponent, RouterLink]
})
export class EventsPageComponent {

  constructor(public readonly auth: AuthService) {
    
  }
  
}