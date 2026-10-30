/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.apirestapp.resources.security;

import com.jgranados.apirestapp.database.entities.users.RoleEnum;
import com.jgranados.apirestapp.database.entities.users.UserEntity;
import com.jgranados.apirestapp.dtos.ErrorResponse;
import com.jgranados.apirestapp.dtos.security.LoginRequest;
import com.jgranados.apirestapp.dtos.security.LoginResponse;
import com.jgranados.apirestapp.services.security.JwtTokenService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Base64;
import java.util.Optional;
import java.util.Set;
import javax.management.relation.Role;

/**
 *
 * @author jose
 */
@Path("auth")
public class AuthResource {

    // Simulación para obtener usuarios desde la base de datos.
    // el password se codifica con base 64
    private static final java.util.Map<String, UserEntity> USERS = java.util.Map.of(
        "admin", new UserEntity("admin", Base64.getEncoder().encodeToString("admin123".getBytes()), Set.of(RoleEnum.ADMIN, RoleEnum.USER)),
        "user",  new UserEntity("user",  Base64.getEncoder().encodeToString("user123".getBytes()),  Set.of(RoleEnum.USER))
    );

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginRequest request) {
        JwtTokenService tokenService = new JwtTokenService();
        Optional<UserEntity> userOpt = getUser(request);
        if (userOpt.isEmpty()) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(new ErrorResponse("Credenciales inválidas"))
                    .build();
        }
        String token = tokenService.generate(userOpt.get());
        return Response.ok(new LoginResponse(token)).build();
    }
    
    // esto va en otra clase
    private Optional<UserEntity> getUser(LoginRequest request) {
        UserEntity user = USERS.get(request.getUsername());
        // se codifica el password enviado en el request
        String requestedPasswordEncode = Base64.getEncoder().encodeToString(request.getPassword().getBytes());
        if (user == null || !user.getPasswordHash().equals(requestedPasswordEncode)) {
            return Optional.empty();
        }
        
        return Optional.of(user);
    }
}
