import { Component, OnInit, signal } from "@angular/core";
import { Event } from "../../../models/events/event";
import { EventCardComponent } from "../event-card/event-card.component";
import { EventsService } from "../../../services/events/event.service";

@Component({
  selector: 'app-events-list',
  templateUrl: './events-list.component.html',
  imports: [EventCardComponent]
})
export class EventsListComponent implements OnInit {
  events = signal<Event[]>([]);

  constructor(private eventsService: EventsService) {

  }

  ngOnInit(): void {
    this.eventsService.getAllEvents().subscribe({
      next: (eventsFromServer: Event[]) => {
        this.events.set(eventsFromServer);
      },
      error: (error: any) => {
        console.log(error);
      }
    });
  }

}