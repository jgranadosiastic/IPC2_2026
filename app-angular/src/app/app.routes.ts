import { Routes } from '@angular/router';
import { CounterPageComponent } from '../pages/counter-page/counter-page.component';
import { EventsPageComponent } from '../pages/events/events-page/events-page.component';
import { CreateEventPageComponent } from '../pages/events/create-event-page/create-event-page.component';
import { UpdateEventPageComponent } from '../pages/events/update-event-page/update-event-page.component';
import { FilesPageComponent } from '../pages/files/files-page/files-page.component';
import { RoleGuardService } from '../services/security/role-guard.service';

export const routes: Routes = [
    {
        path: '',
        component: CounterPageComponent
    },
    {
        path: 'events',
        component: EventsPageComponent
    },
    {
        path: 'events/new',
        component: CreateEventPageComponent
    },
    {
        path: 'events/update/:code',
        component: UpdateEventPageComponent,
    },
    {
        path: 'files',
        component: FilesPageComponent,
        canActivate: [RoleGuardService],
        data: {allowedRoles:['ADMIN']}
    },
];
