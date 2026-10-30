import { Component, EventEmitter, Input, Output } from "@angular/core";
import { Event } from "../../../models/events/event";
import { CurrencyPipe, DatePipe } from "@angular/common";
import { RouterLink } from "@angular/router";
import { AuthService } from "../../../services/security/auth.service";

@Component({
    selector: 'app-event-card',
    templateUrl: './event-card.component.html',
    imports: [DatePipe, CurrencyPipe, RouterLink]
})
export class EventCardComponent {
    @Input({ alias: "event", required: true })
    event!: Event;

    @Output()
    eventSelectedToDelete = new EventEmitter<Event>();

    constructor(public readonly authService: AuthService) {
        
    }

    deleteAction(): void {
        this.eventSelectedToDelete.emit(this.event);
    }
}