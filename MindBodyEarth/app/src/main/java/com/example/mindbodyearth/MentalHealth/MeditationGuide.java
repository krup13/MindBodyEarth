package com.example.mindbodyearth.MentalHealth;
public class MeditationGuide {
    private String title;
    private String filePath;
    private int duration; // Duration in minutes

    public MeditationGuide(String title, String filePath, int duration) {
        this.title = title;
        this.filePath = filePath;
        this.duration = duration;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getDuration() {
        return duration;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
