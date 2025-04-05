package org.acme.client;

import org.acme.dto.OmdbResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "https://www.omdbapi.com/")
public interface OmdbRestClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    OmdbResponse getMovieByTitle(@QueryParam("t") String title, @QueryParam("apikey") String apiKey);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    OmdbResponse getMovieByImdbId(@QueryParam("i") String imdbId, @QueryParam("apikey") String apiKey);
}
