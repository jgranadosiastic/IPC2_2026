package com.jgranados.apirestapp.resources;

import com.jgranados.apirestapp.backend.Libro;
import jakarta.data.repository.Delete;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("libros")
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
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarLibro(@PathParam("id") Long id) {
        // invocar al servicio o logica de negocio para eliminar
        // en base al valor de id
        System.out.println("Se limina el libro con id: " + id);
        return Response.accepted().build();
    }
}
