package org.acme.resource;

import java.util.Optional;

import org.acme.client.JikanRestClient;
import org.acme.client.OmdbRestClient;
import org.acme.dto.Anime;
import org.acme.scraper.RottenTomatoesScraper;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/anime")
public class AnimeResource {

    // Api do Jikan
    @RestClient
    @Inject
    JikanRestClient jikanService;

    // API OMDB
    @RestClient
    @Inject
    OmdbRestClient omdbService;

    // Rotten Scrapper
    @Inject
    RottenTomatoesScraper rottenTomatoesScraper;

    // Retorna um anime com suas notas no Jikan/IMDB/Rotten
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Anime getAnime(@PathParam("id") int id) {
        Anime anime = jikanService.getAnimeById(id);

        // Mal Score
        System.out.println(anime.getData().getScore());

        // IMDB Score
        System.out.println(omdbService.getMovieByTitle(anime.getData().getTitleEnglish(), "87e7d976").getImdbRating());
        
        // Rotten Score
        System.out.println(rottenTomatoesScraper.getCriticsScore(anime.getData().getTitleEnglish()));

        String imdbRatingStr = omdbService
                .getMovieByTitle(anime.getData().getTitleEnglish(), "87e7d976")
                .getImdbRating();

        Double imdbScore = null;
        if (imdbRatingStr != null && !imdbRatingStr.isBlank()) {
            try {
                imdbScore = Double.parseDouble(imdbRatingStr);
            } catch (NumberFormatException e) {
                e.printStackTrace(); // ou log.error(...)
            }
        }

        Optional<Double> rottenScoreOpt = rottenTomatoesScraper.getCriticsScore(anime.getData().getTitleEnglish());
        Double rottenScore = rottenScoreOpt.orElse(null);

        anime.getData().setImbdscore(imdbScore);
        anime.getData().setRottenscore(rottenScore);

        return anime;
    }
}
