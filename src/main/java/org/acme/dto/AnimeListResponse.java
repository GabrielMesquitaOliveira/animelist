package org.acme.dto;

import lombok.Data;
import java.util.List;

@Data
public class AnimeListResponse {
    private List<Anime> data;
}
