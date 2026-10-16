import { Component } from "@angular/core";
import { EventsListComponent } from "../../components/events/events-list/events-list.component";

@Component({
  selector: 'app-events-page',
  templateUrl: './events-page.component.html',
  imports: [EventsListComponent]
})
export class EventsPageComponent {

}