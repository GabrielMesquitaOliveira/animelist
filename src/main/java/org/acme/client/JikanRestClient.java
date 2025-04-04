package org.acme.client;

import org.acme.dto.Anime;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@RegisterRestClient(baseUri = "https://api.jikan.moe/v4")
public interface JikanRestClient {

    @GET
    @Path("/anime/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Anime getAnimeById(@PathParam("id") int id);
}
