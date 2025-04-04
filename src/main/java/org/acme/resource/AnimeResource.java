package org.acme.resource;

import org.acme.Service.JikanService;
import org.acme.dto.Anime;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/anime")
public class AnimeResource {

    @Inject  
    JikanService jikanService;
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Anime getAnime(@PathParam("id") int id) {
        Anime anime = jikanService.getAnimeById(id);
        System.out.println(anime.getData().getScore());
        return jikanService.getAnimeById(id);
    }
}

