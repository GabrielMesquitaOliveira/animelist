package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Anime {

    @JsonProperty("data")
    private AnimeData data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AnimeData {
        @JsonProperty("mal_id")
        private int malId;
        private String url;
        private String title;

        @JsonProperty("title_english")
        private String titleEnglish;

        @JsonProperty("title_japanese")
        private String titleJapanese;

        @JsonProperty("title_synonyms")
        private List<String> titleSynonyms;

        private String type;
        private String source;
        private int episodes;
        private String status;
        private boolean airing;
        private String duration;
        private String rating;
        private double score;

        @JsonProperty("scored_by")
        private int scoredBy;

        private int rank;
        private int popularity;
        private int members;
        private int favorites;
        private String synopsis;
        private String background;
        private String season;
        private int year;

        @JsonProperty("broadcast")
        private Map<String, String> broadcast;

        @JsonProperty("images")
        private Map<String, Map<String, String>> images;

        @JsonProperty("trailer")
        private Trailer trailer;

        @JsonProperty("titles")
        private List<Title> titles;

        @JsonProperty("aired")
        private Aired aired;

        @JsonProperty("producers")
        private List<Producer> producers;

        @JsonProperty("licensors")
        private List<Producer> licensors;

        @JsonProperty("studios")
        private List<Producer> studios;

        @JsonProperty("genres")
        private List<Genre> genres;

        @JsonProperty("explicit_genres")
        private List<Genre> explicitGenres;

        @JsonProperty("themes")
        private List<Genre> themes;

        @JsonProperty("demographics")
        private List<Genre> demographics;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Trailer {
        @JsonProperty("youtube_id")
        private String youtubeId;
        private String url;
        @JsonProperty("embed_url")
        private String embedUrl;
        private Map<String, String> images;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Title {
        private String type;
        private String title;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Aired {
        private String from;
        private String to;
        private String string;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Producer {
        @JsonProperty("mal_id")
        private int malId;
        private String type;
        private String name;
        private String url;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Genre {
        @JsonProperty("mal_id")
        private int malId;
        private String type;
        private String name;
        private String url;
    }
}
