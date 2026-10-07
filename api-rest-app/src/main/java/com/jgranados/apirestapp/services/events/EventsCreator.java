/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.apirestapp.services.events;


import com.jgranados.apirestapp.database.daos.events.EventsDB;
import com.jgranados.apirestapp.database.entities.events.Event;
import com.jgranados.apirestapp.dtos.events.NewEventRequest;
import com.jgranados.apirestapp.exceptions.EntityAlreadyExistsException;
import com.jgranados.apirestapp.exceptions.UserDataInvalidException;

/**
 *
 * @author jose
 */
public class EventsCreator {

    public Event createEvent(NewEventRequest newEventRequest) throws UserDataInvalidException,
            EntityAlreadyExistsException {
        EventsDB eventsDb = new EventsDB();
        
        Event event = extractEvent(newEventRequest);
        
        if (eventsDb.existsEvent(newEventRequest.getCode())) {
            throw new EntityAlreadyExistsException(
                    String.format("El evento con codigo %s ya existe", event.getCode()));
        }

        eventsDb.createEvent(event);
        
        return event;
    }

    private Event extractEvent(NewEventRequest newEventRequest) throws UserDataInvalidException {
        try {
            Event event = new Event(
                newEventRequest.getCode(),
                    newEventRequest.getName(),
                    newEventRequest.getEventType(),
                    newEventRequest.getLimit(),
                    newEventRequest.getStartDate(),
                    newEventRequest.getPrice()
            );
            
            if (!event.isValid()) {
                throw new UserDataInvalidException("Error en los datos enviados");
            }
            
            return event;
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new UserDataInvalidException("Error en los datos enviados");
        }
    }
}
