package com.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/person")
public class PersonResource {
    @Inject
    private PersonRepository repo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersons() {
        return Response
                .ok(repo.findAll())
                .build();
    }
}
