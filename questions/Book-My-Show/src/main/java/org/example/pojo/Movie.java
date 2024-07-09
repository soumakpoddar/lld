package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {
    private int movieId;
    private String movieName;
    private int movieDuration;
    private String movieGenre;
    private String movieLanguage;
}
