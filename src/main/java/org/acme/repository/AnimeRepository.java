package org.acme.repository;

import org.acme.model.AnimeEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AnimeRepository implements PanacheRepository<AnimeEntity> {

}
