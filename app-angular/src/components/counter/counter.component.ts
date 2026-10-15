import { Component } from '@angular/core';

@Component({
    imports: [],
    selector: 'app-counter',
    templateUrl: './counter.component.html',
})
export class CounterComponent {
    protected count: number = 0;
    protected fontStyle: string;

    constructor() {
        this.fontStyle = '';
    }

    protected increaseCount(): void {
        this.count++;
    }

    protected changeStyle(style: string): string {
        this.fontStyle = style;

        return this.fontStyle;
    }
}