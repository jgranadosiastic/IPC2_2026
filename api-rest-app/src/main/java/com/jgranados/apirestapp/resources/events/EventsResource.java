/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.apirestapp.resources.events;

import com.jgranados.apirestapp.database.entities.events.Event;
import com.jgranados.apirestapp.dtos.events.EventResponse;
import com.jgranados.apirestapp.dtos.events.NewEventRequest;
import com.jgranados.apirestapp.dtos.events.UpdateEventRequest;
import com.jgranados.apirestapp.exceptions.EntityAlreadyExistsException;
import com.jgranados.apirestapp.exceptions.EntityNotFoundException;
import com.jgranados.apirestapp.exceptions.UserDataInvalidException;
import com.jgranados.apirestapp.services.events.EventsCreator;
import com.jgranados.apirestapp.services.events.EventsCrudService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.util.List;

/**
 *
 * @author jose
 */
@Path("events")
public class EventsResource {

    @Context
    UriInfo uriInfo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEvent(NewEventRequest eventRequest) {
        EventsCreator eventsCreator = new EventsCreator();

        try {

            eventsCreator.createEvent(eventRequest);

            return Response.status(Response.Status.CREATED).build();
        } catch (UserDataInvalidException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (EntityAlreadyExistsException e) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEvents() {
        EventsCrudService eventCrudService = new EventsCrudService();
        List<EventResponse> events = eventCrudService.getAllEvents()
                .stream()
                .map(EventResponse::new)
                .toList();

        return Response.ok(events).build();
    }

    @GET
    @Path("{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEventByCode(@PathParam("code") String code) {
        EventsCrudService eventCrudService = new EventsCrudService();
        try {
            Event existingEvent = eventCrudService.getEventByCode(code);

            return Response.ok(new EventResponse(existingEvent)).build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("{code}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEvent(@PathParam("code") String code,
            UpdateEventRequest eventRequest) {
        EventsCrudService eventCrudService = new EventsCrudService();

        try {

            Event eventUpdated = eventCrudService.updateEvent(code, eventRequest);

            return Response.ok(new EventResponse(eventUpdated)).build();
        } catch (UserDataInvalidException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("{code}")
    public Response deleteEvent(@PathParam("code") String code) {
        EventsCrudService eventCrudService = new EventsCrudService();

        try {

            eventCrudService.deleteEventByCode(code);

            return Response.ok().build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
