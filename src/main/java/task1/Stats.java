package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.nio.file.Path;
import java.util.*;

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
        stats.countMoviesByGenre(movies)
                        .forEach((genre, count) -> System.out.println(genre + " : " + count));
        System.out.println();

        //подсчет по языкам
        System.out.println("-=Подсчет по языкам=-");
        stats.countMoviesByLanguage(movies)
                        .forEach((lang, count) -> System.out.println(lang + " : " + count));
        System.out.println();

        //топ популярных
        System.out.println("-=Топ 5 популярных=-");
        stats.countTopPopular(movies, 5)
                .forEach(movie -> System.out.println(movie));
        System.out.println();

        //самый новый
        System.out.println("-=Самый новый фильм=-");
        System.out.println(stats.getNewestMovie(movies));
        System.out.println();

        //самый старый
        System.out.println("-=Самый старый фильм=-");
        System.out.println(stats.getOldestMovie(movies));
        System.out.println();

        //общая длительность
        System.out.println("-=Общая длительность=-");
        System.out.println(stats.getGeneralRuntime(movies));
        System.out.println();

        //фильмы с высоким рейтингом за каждый год
        System.out.println("-=Фильмы с высоким рейтингом за каждый год=-");
        stats.getHighRankFilmOfYear(movies)
                        .forEach((year, film) -> System.out.println("Год: " + year + ". Фильм: " + film.getName() + ". Оценка: " + film.getScore()));
        System.out.println();

        //фильмы с низким рейтингом за каждый год
        System.out.println("-=Фильмы с низким рейтингом за каждый год=-");
        stats.getLowRankFilmOfYear(movies)
                        .forEach((year, film) -> System.out.println("Год: " + year + ". Фильм: " + film.getName() + ". Оценка: " + film.getScore()));
        System.out.println();

        //сортировка фильмов по длительности
        System.out.println("-=Отсортированные по длительности фильмы=-");
        Collections.sort(movies);
        movies.forEach(System.out::println);
    }
}
