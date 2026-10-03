package com.jgranados.apirestapp.resources;

import com.jgranados.apirestapp.backend.Libro;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("jakartaee11")
public class JakartaEE11Resource {
    
    // api-rest-app/api/v1/jakartaee11/get1
    @GET
    @Path("get1")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ping(){
        Libro libro = new Libro("libro1", "autorX", 21);
        return Response
                .ok(libro)
                .build();
    }
}
