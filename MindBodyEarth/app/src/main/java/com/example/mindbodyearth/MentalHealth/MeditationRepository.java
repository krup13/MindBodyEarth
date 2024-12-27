package com.example.mindbodyearth.MentalHealth;

import java.util.ArrayList;
import java.util.List;

public class MeditationRepository {
    private List<MeditationGuide> meditationGuides;

    public MeditationRepository() {
        this.meditationGuides = new ArrayList<>();
    }

    // Add a new meditation guide
    public void addGuide(MeditationGuide guide) {
        meditationGuides.add(guide);
    }

    // Get all meditation guides
    public List<MeditationGuide> getAllGuides() {
        return new ArrayList<>(meditationGuides);
    }

    // Find guides by title keyword
    public List<MeditationGuide> searchGuides(String keyword) {
        List<MeditationGuide> results = new ArrayList<>();
        for (MeditationGuide guide : meditationGuides) {
            if (guide.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(guide);
            }
        }
        return results;
    }
}
