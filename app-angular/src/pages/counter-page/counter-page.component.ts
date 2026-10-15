import { Component } from "@angular/core";
import { CounterComponent } from "../../components/counter/counter.component";

@Component({
    selector: 'app-counter-page',
  templateUrl: './counter-page.component.html',
  imports: [CounterComponent],
})
export class CounterPageComponent {

}