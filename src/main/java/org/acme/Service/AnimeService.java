package org.acme.Service;

import org.acme.dto.Anime;
import org.acme.model.AnimeEntity;
import org.acme.repository.AnimeRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AnimeService {

    @Inject
    AnimeRepository animeRepository;

    public void salvarAnime(Anime anime) {
        AnimeEntity entity = new AnimeEntity();
        entity.setMalId(anime.getData().getMalId());
        entity.setMalScore(anime.getData().getScore());
        entity.setImdbScore(null); // Pode ser preenchido depois
        entity.setRottenScore(null);
        entity.setMyScore(null);

        animeRepository.save(anime);
    }
}

