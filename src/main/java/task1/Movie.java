package task1;

import java.time.LocalDate;

public class Movie {
    private String name ;
    private String genre;
    private LocalDate premiere;
    private int runtime;
    private double score;
    private Languages language;


    public Movie(String name, String genre, LocalDate premiere, int runtime, double score, Languages language) {
        this.name = name;
        this.genre = genre;
        this.premiere = premiere;
        this.runtime = runtime;
        this.score = score;
        this.language = language;
    }

    public Movie() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getPremiere() {
        return premiere;
    }

    public void setPremiere(LocalDate premiere) {
        this.premiere = premiere;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Languages getLanguage() {
        return language;
    }

    public void setLanguage(Languages language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Название: " + getName() +
                ", Жанр: " + getGenre() +
                ", Премьера: " + getPremiere() +
                ", Длительность: " + getRuntime() +
                ", Оценка: " + getScore() +
                ", Язык: " + getLanguage() + ".";
    }
}
