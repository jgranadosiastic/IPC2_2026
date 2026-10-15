import { Routes } from '@angular/router';
import { CounterPageComponent } from '../pages/counter-page/counter-page.component';
import { EventsPageComponent } from '../pages/events-page/events-page.component';

export const routes: Routes = [
    {
        path: '',
        component: CounterPageComponent
    },
    {
        path: 'events-page',
        component: EventsPageComponent
    }
];
