package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stats {
    static Path path = Path.of("src/main/resources/NetflixOriginals.csv");
    static CsvReader reader;
    static MovieStatsService stats;
    public static void main(String[] args) {
        reader = new CsvReaderImpl();
        stats = new MovieStatsServiceImpl();
        List<Movie> movies = reader.readFile(path);

        //подсчет по жанрам
        System.out.println("-=Подсчет по жанрам=-");
        Map<String, Integer> genreCount = stats.countMoviesByGenre(movies);
        for (Map.Entry<String, Integer> entry : genreCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();

        //подсчет по языкам
        System.out.println("-=Подсчет по языкам=-");
        Map<String, Integer> langCount = stats.countMoviesByLanguage(movies);
        for (Map.Entry<String, Integer> entry : langCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();

        //топ популярных
        System.out.println("-=Топ 5 популярных=-");
        List<Movie> top5 = stats.countTopPopular(movies, 5);
        for (Movie movie : top5) {
            System.out.println(movie);
        }
        System.out.println();

        //самый новый
        System.out.println("-=Самый новый фильм=-");
        Movie newest = stats.getNewestMovie(movies);
        System.out.println(newest);
        System.out.println();

        //самый старый
        System.out.println("-=Самый старый фильм=-");
        Movie oldest = stats.getOldestMovie(movies);
        System.out.println(oldest);
        System.out.println();

        //общая длительность
        System.out.println("-=Общая длительность=-");
        System.out.println(stats.getGeneralRuntime(movies));
        System.out.println();

        //фильмы с высоким рейтингом за каждый год
        System.out.println("-=Фильмы с высоким рейтингом за каждый год=-");
        Map<Integer, Movie> highRank = stats.getHighRankFilmOfYear(movies);
        for (Map.Entry<Integer, Movie> entry : highRank.entrySet()) {
            System.out.println("Год: " + entry.getKey() + ". Фильм: " + entry.getValue().getName() + ". Оценка: " + entry.getValue().getScore());
        }
        System.out.println();

        //фильмы с низким рейтингом за каждый год
        System.out.println("-=Фильмы с низким рейтингом за каждый год=-");
        Map<Integer, Movie> lowRank = stats.getLowRankFilmOfYear(movies);
        for (Map.Entry<Integer, Movie> entry : lowRank.entrySet()) {
            System.out.println("Год: " + entry.getKey() + ". Фильм: " + entry.getValue().getName() + ". Оценка: " + entry.getValue().getScore());
        }
        System.out.println();

    }
}
