import { Injectable } from "@angular/core";
import { RestConstants } from "../../shared/rest-api/rest-constants";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Event } from "../../models/events/event";

@Injectable({
  providedIn: 'root'
})
export class EventsService {
  restConstants = new RestConstants();

  constructor(private httpClient: HttpClient) { }

  public getAllEvents(): Observable<Event[]> {
    return this.httpClient.get<Event[]>(`${this.restConstants.getApiURL()}/events`);
  }
}