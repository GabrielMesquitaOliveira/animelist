package org.acme.repository;

import org.acme.dto.Anime;
import org.acme.model.AnimeEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AnimeRepository implements PanacheRepository<AnimeEntity> {

    public AnimeEntity findByMalId(int malId) {
        return find("malId", malId).firstResult();
    }

    public void save(AnimeEntity anime) {
        persist(anime);
    }
}
