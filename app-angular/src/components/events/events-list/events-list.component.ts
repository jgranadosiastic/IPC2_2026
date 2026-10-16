import { Component } from "@angular/core";
import { Event } from "../../../models/events/event";
import { EventTypeEnum } from "../../../models/events/event-type-enum";
import { NgFor } from "@angular/common";
import { EventCardComponent } from "../event-card/event-card.component";

@Component({
  selector: 'app-events-list',
  templateUrl: './events-list.component.html',
  imports: [NgFor, EventCardComponent]
})
export class EventsListComponent {
  protected events: Event[];

  constructor() {
    this.events = [
      {
        code: 'evt-001',
        name: 'evt 1',
        eventType: EventTypeEnum.CHARLA,
        limit: 150,
      },
      {
        code: 'evt-002',
        name: 'evt 2',
        eventType: EventTypeEnum.CONGRESO,
        limit: 75,
      }, {
        code: 'evt-003',
        name: 'evt 3',
        eventType: EventTypeEnum.TALLER,
        limit: 25,
      }
    ];
  }
}