import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CounterComponent } from '../components/counter/counter.component';

@Component({
  imports: [RouterOutlet, CounterComponent],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('app-angular');
}
