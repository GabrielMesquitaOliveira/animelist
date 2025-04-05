package org.acme.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "anime")
public class AnimeEntity {

    @Id
    private int malId;

    private double malScore;
    private Double imdbScore;
    private Double rottenScore;
    private Double myScore;
    private String myReview;
}
