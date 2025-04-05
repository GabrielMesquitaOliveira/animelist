package org.acme.service;

import org.acme.dto.Anime;
import org.acme.model.AnimeEntity;
import org.acme.repository.AnimeRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AnimeService {

    @Inject
    AnimeRepository animeRepository;

    public void createAnime(Anime anime) {
        AnimeEntity entity = new AnimeEntity();
        entity.setMalId(anime.getData().getMalId());
        entity.setMalScore(anime.getData().getScore());
        entity.setImdbScore(anime.getData().getImbdscore());
        entity.setRottenScore(anime.getData().getRottenscore());
        entity.setMyScore(null);
        entity.setMyReview(null);

        animeRepository.persist(entity);
    }

    // update
    public void updateAnime(Anime anime, Double myScore, String myReview) {
        AnimeEntity entity = animeRepository.findById((long) anime.getData().getMalId());
        if (entity != null) {
            entity.setMalScore(anime.getData().getScore());
            entity.setImdbScore(anime.getData().getImbdscore());
            entity.setRottenScore(anime.getData().getRottenscore());
            entity.setMyScore(myScore);
            entity.setMyReview(myReview);
            animeRepository.persist(entity);
        }
    }

}
