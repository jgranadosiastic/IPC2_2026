import { ActivatedRoute, RouterLink } from "@angular/router";
import { EventFormComponent } from "../../../components/events/event-form/event-form.component";
import { Component, OnInit, signal } from "@angular/core";
import { EventsService } from "../../../services/events/event.service";
import { Event } from "../../../models/events/event";

@Component({
    selector: 'app-create-event-page',
    imports: [EventFormComponent, RouterLink],
    templateUrl: './update-event-page.component.html',
})
export class UpdateEventPageComponent implements OnInit {
    eventCode!: string
    eventToUpdate = signal<Event | undefined>(undefined);
    exists = signal<boolean>(false);

    constructor(private router: ActivatedRoute, private eventsService: EventsService) {

    }

    ngOnInit(): void {
        this.eventCode = this.router.snapshot.params['code'];
        this.eventsService.getEventByCode(this.eventCode).subscribe({
            next: (eventToUpdate) => {
                this.eventToUpdate.set(eventToUpdate);
                this.exists.set(true);
            },
            error: (error: any) => {
                console.log(error);
            }
        });
    }


}