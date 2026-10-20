import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from "@angular/forms";
import { EventTypeEnum } from "../../../models/events/event-type-enum";
import { KeyValuePipe } from "@angular/common";
import { EventsService } from "../../../services/events/event.service";
import { Event } from "../../../models/events/event";

@Component({
    selector: 'app-event-form',
    imports: [FormsModule, ReactiveFormsModule, KeyValuePipe],
    templateUrl: './event-form.component.html',
})
export class EventFormComponent implements OnInit {

    newEventForm!: FormGroup;
    newEvent!: Event;
    eventTypeEnums = EventTypeEnum;
    operationDone: boolean = false;

    constructor(private formBuilder: FormBuilder,
        private eventsService: EventsService
    ) {

    }

    ngOnInit(): void {
        this.newEventForm = this.formBuilder.group(
            {
                code: [null, [Validators.required, Validators.maxLength(10)]],
                name: [null, [Validators.required, Validators.maxLength(100)]],
                limit: [null, Validators.required],
                eventType: [EventTypeEnum.CHARLA, Validators.required],
                startDate: [new Date().toISOString().substring(0, 10), Validators.required],
                price: [null, [Validators.required, Validators.min(1)]],
            }
        )
    }

    submit(): void {
        console.log('se hizo submit');
        if (this.newEventForm.valid) {
            console.log(this.newEventForm.value);
            this.newEvent = this.newEventForm.value as Event;
            this.eventsService.createNewEvent(this.newEvent).subscribe({
                next: () => {
                    this.reset();
                this.operationDone = true;
                },
                error: (error: any) => {
                    console.log(error);
                }
            });
        }
    }

    reset(): void {
        this.newEventForm.reset({
            eventType: EventTypeEnum.CHARLA,
            startDate: new Date().toISOString().substring(0, 10)
        });
    }
}