import { Routes } from '@angular/router';
import { CounterPageComponent } from '../pages/counter-page/counter-page.component';
import { EventsPageComponent } from '../pages/events/events-page/events-page.component';
import { CreateEventPageComponent } from '../pages/events/create-event-page/create-event-page.component';

export const routes: Routes = [
    {
        path: '',
        component: CounterPageComponent
    },
    {
        path: 'events-page',
        component: EventsPageComponent
    },
    {
        path: 'events/new',
        component: CreateEventPageComponent
    }
];
