import { Component, Input } from "@angular/core";
import { Event } from "../../../models/events/event";
import { EventTypeEnum } from "../../../models/events/event-type-enum";

@Component({
    selector: 'app-event-card',
    templateUrl: './event-card.component.html'
})
export class EventCardComponent {
    @Input({alias: "event", required: true})
    event!: Event;
}