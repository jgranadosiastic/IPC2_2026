import { Component } from '@angular/core';

@Component({
  imports: [],
  selector: 'app-counter',
  templateUrl: './counter.component.html',
})
export class CounterComponent {
    protected count : number = 0;

    protected increaseCount() : void {
        this.count++;
    }
}