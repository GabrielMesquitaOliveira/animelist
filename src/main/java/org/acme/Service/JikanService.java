package org.acme.Service;

import org.acme.client.JikanRestClient;
import org.acme.dto.Anime;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class JikanService {

    @Inject
    @RestClient
    JikanRestClient jikanRestClient;

    public Anime getAnimeById(int id) {
        return jikanRestClient.getAnimeById(id);
    }
}