package com.jgranados.apirestapp;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

/**
 * Configures Jakarta RESTful Web Services for the application.
 *
 * @author Juneau
 */
@ApplicationPath("api/v1")
public class JakartaRestConfiguration extends ResourceConfig {

    public JakartaRestConfiguration() {
        // Escanea tu paquete de recursos y providers
        packages("com.jgranados.apirestapp.resources")
                .property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);
    }

}
