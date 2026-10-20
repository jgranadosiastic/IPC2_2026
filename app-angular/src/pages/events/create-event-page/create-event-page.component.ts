import { Component } from "@angular/core";
import { RouterLink } from "@angular/router";
import { EventFormComponent } from "../../../components/events/event-form/event-form.component";

@Component({
  selector: 'app-create-event-page',
  imports: [EventFormComponent, RouterLink],
  templateUrl: './create-event-page.component.html',
})
export class CreateEventPageComponent {


}