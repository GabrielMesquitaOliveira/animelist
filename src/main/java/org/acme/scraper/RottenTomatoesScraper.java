package org.acme.scraper;

import jakarta.enterprise.context.ApplicationScoped;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Optional;

@ApplicationScoped
public class RottenTomatoesScraper {

    public Optional<Double> getCriticsScore(String title) {
        try {
            String formattedTitle = title.toLowerCase().replace(" ", "_");
            String url = "https://www.rottentomatoes.com/tv/" + formattedTitle;
    
            Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0")
                .get();
    
            Element scoreElement = doc.selectFirst("rt-text[slot=criticsScore]");
    
            if (scoreElement != null) {
                String scoreText = scoreElement.text().replace("%", "").trim();
                
                if (!scoreText.isEmpty()) {
                    return Optional.of(Double.parseDouble(scoreText));
                }
            }
    
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter score para número: " + e.getMessage());
        }
    
        return Optional.empty();
    }
    
}
