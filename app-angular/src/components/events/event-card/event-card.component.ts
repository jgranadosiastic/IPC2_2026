import { Component, Input } from "@angular/core";
import { Event } from "../../../models/events/event";
import { CurrencyPipe, DatePipe } from "@angular/common";

@Component({
    selector: 'app-event-card',
    templateUrl: './event-card.component.html',
    imports: [DatePipe, CurrencyPipe]
})
export class EventCardComponent {
    @Input({alias: "event", required: true})
    event!: Event;
}