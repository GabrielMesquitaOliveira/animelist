package org.acme.dto;

import lombok.Data;

import java.util.List;

@Data
public class CharacterListResponse {
    private List<CharacterEntry> data;

    @Data
    public static class CharacterEntry {
        private Character character;
        private String role;
    }

    @Data
    public static class Character {
        private int mal_id;
        private String name;
        private String url;
        private Images images;
    }

    @Data
    public static class Images {
        private ImageType jpg;
        private ImageType webp;
    }

    @Data
    public static class ImageType {
        private String image_url;
        private String small_image_url;
    }
}
