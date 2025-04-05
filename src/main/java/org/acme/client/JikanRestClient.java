package org.acme.client;

import org.acme.dto.Anime;
import org.acme.dto.AnimeListResponse;
import org.acme.dto.CharacterListResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "https://api.jikan.moe/v4")
public interface JikanRestClient {

    // Detalhes do anime por ID
    @GET
    @Path("/anime/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Anime getAnimeById(@PathParam("id") int id);

    // Busca por título de anime
    @GET
    @Path("/anime")
    @Produces(MediaType.APPLICATION_JSON)
    AnimeListResponse searchAnime(@QueryParam("q") String query,
            @QueryParam("limit") @DefaultValue("10") int limit,
            @QueryParam("page") @DefaultValue("1") int page);

    // Animes da temporada atual
    @GET
    @Path("/seasons/now")
    @Produces(MediaType.APPLICATION_JSON)
    AnimeListResponse getSeasonNow();

    // Top animes
    @GET
    @Path("/top/anime")
    @Produces(MediaType.APPLICATION_JSON)
    AnimeListResponse getTopAnime(@QueryParam("limit") @DefaultValue("10") int limit);

    // Animes por temporada e ano
    @GET
    @Path("/seasons/{year}/{season}")
    @Produces(MediaType.APPLICATION_JSON)
    AnimeListResponse getSeasonalAnime(@PathParam("year") int year,
            @PathParam("season") String season);

    // Personagens de um anime
    @GET
    @Path("/anime/{id}/characters")
    @Produces(MediaType.APPLICATION_JSON)
    CharacterListResponse getAnimeCharacters(@PathParam("id") int id);
}
