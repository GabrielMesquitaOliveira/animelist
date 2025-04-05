package org.acme.model;

import java.util.Optional;

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
    private Optional<Double> rottenScore;
    private Double myScore;
    private String myReview;
}
