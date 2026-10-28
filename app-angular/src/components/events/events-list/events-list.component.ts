import { Component, EventEmitter, OnInit, Output, signal } from "@angular/core";
import { Event } from "../../../models/events/event";
import { EventCardComponent } from "../event-card/event-card.component";
import { EventsService } from "../../../services/events/event.service";
import { ConfirmationModalComponent } from "../../confirmation-modal/confirmation-modal.component";

@Component({
  selector: 'app-events-list',
  templateUrl: './events-list.component.html',
  imports: [EventCardComponent, ConfirmationModalComponent]
})
export class EventsListComponent implements OnInit {
  events = signal<Event[]>([]);
  eventToDelete = signal<Event | undefined>(undefined);
  deleted = signal<boolean>(false);

  constructor(private eventsService: EventsService) {

  }

  ngOnInit(): void {
    this.loadData();
  }

  loadData(): void {
    this.eventsService.getAllEvents().subscribe({
      next: (eventsFromServer: Event[]) => {
        this.events.set(eventsFromServer);
      },
      error: (error: any) => {
        console.log(error);
      }
    });
  }

  selectToDelete(event: Event): void {
    this.eventToDelete.set(event);
    this.deleted.set(false);
  }

  deleteEvent(): void {
    this.eventsService.deleteEvent(this.eventToDelete()!.code).subscribe({
      next: () => {
        // deleted
        this.loadData();
        this.deleted.set(true);
      },
      error: (error: any) => {
        console.log(error);
      }
    });
  }

}