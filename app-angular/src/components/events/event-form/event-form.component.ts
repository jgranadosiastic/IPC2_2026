import { Component, Input, OnInit, signal } from "@angular/core";
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
    operationDone = signal<boolean>(false);

    @Input()
    isEditMode: boolean = false;
    @Input()
    eventToUpdate!: Event;

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
                eventType: [null, Validators.required],
                startDate: [null, Validators.required],
                price: [null, [Validators.required, Validators.min(1)]],
            }
        );

        this.reset();
    }

    submit(): void {
        console.log('se hizo submit');
        if (this.newEventForm.valid) {

            if (this.isEditMode) {
                this.updateEvent();
            } else {
                this.saveNewEvent();
            }
        }
    }

    private saveNewEvent(): void {
        this.newEvent = this.newEventForm.value as Event;
        this.eventsService.createNewEvent(this.newEvent).subscribe({
            next: () => {
                this.reset();
                this.operationDone.set(true);
            },
            error: (error: any) => {
                console.log(error);
            }
        });
        console.log(this.newEvent);
    }

    private updateEvent(): void {
        this.eventToUpdate = this.newEventForm.value as Event;
        const { code, ...eventToUpdateRequest } = this.eventToUpdate;
        this.eventsService.updateEvent(code, eventToUpdateRequest).subscribe({
            next: () => {
                this.reset();
                this.operationDone.set(true);
            },
            error: (error: any) => {
                console.log(error);
            }
        });
    }

    reset(): void {
        if (this.isEditMode) {
            this.resetOnEdit();
            console.log('reset edit');
        } else {
            this.resetOnCreate();
        }
        this.operationDone.set(false);
    }

    private resetOnCreate(): void {
        this.newEventForm.reset({
            eventType: EventTypeEnum.CHARLA,
            startDate: new Date().toISOString().substring(0, 10)
        });
    }

    private resetOnEdit(): void {
        this.newEventForm.reset(this.eventToUpdate);
    }
}