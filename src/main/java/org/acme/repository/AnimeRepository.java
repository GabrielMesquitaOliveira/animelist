package org.acme.repository;

import org.acme.dto.Anime;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AnimeRepository implements PanacheRepository<Anime> {

    public Anime findByMalId(int malId) {
        return find("malId", malId).firstResult();
    }
}
