package org.acme.Service;

import java.util.Optional;

import org.acme.dto.Anime;
import org.acme.model.AnimeEntity;
import org.acme.repository.AnimeRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AnimeService {

    @Inject
    AnimeRepository animeRepository;

    public void createAnime(Anime anime, Double ImdbScore, Double RottenScore) {
        AnimeEntity entity = new AnimeEntity();
        entity.setMalId(anime.getData().getMalId());
        entity.setMalScore(anime.getData().getScore());
        entity.setImdbScore(ImdbScore);
        entity.setRottenScore(RottenScore);
        entity.setMyScore(null);
        entity.setMyReview(null);

        animeRepository.persist(entity);
    }

    //update


}

