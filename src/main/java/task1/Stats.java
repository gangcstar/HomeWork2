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
        stats = new MovieStatsServiceImpl(reader);
        //List<Movie> movies = reader.readFile(path);

        //подсчет по жанрам
        System.out.println("-=Подсчет по жанрам=-");
        stats.countMoviesByGenre(path)
                        .forEach((genre, count) -> System.out.println(genre + " : " + count));
        System.out.println();

        //подсчет по языкам
        System.out.println("-=Подсчет по языкам=-");
        stats.countMoviesByLanguage(path)
                        .forEach((lang, count) -> System.out.println(lang + " : " + count));
        System.out.println();

        //топ популярных
        System.out.println("-=Топ 5 популярных=-");
        stats.countTopPopular(path, 5)
                .forEach(movie -> System.out.println(movie));
        System.out.println();

        //самый новый
        System.out.println("-=Самый новый фильм=-");
        System.out.println(stats.getNewestMovie(path));
        System.out.println();

        //самый старый
        System.out.println("-=Самый старый фильм=-");
        System.out.println(stats.getOldestMovie(path));
        System.out.println();

        //общая длительность
        System.out.println("-=Общая длительность=-");
        System.out.println(stats.getGeneralRuntime(path));
        System.out.println();

        //фильмы с высоким рейтингом за каждый год
        System.out.println("-=Фильмы с высоким рейтингом за каждый год=-");
        stats.getHighRankFilmOfYear(path)
                        .forEach((year, film) -> System.out.println("Год: " + year + ". Фильм: " + film.getName() + ". Оценка: " + film.getScore()));
        System.out.println();

        //фильмы с низким рейтингом за каждый год
        System.out.println("-=Фильмы с низким рейтингом за каждый год=-");
        stats.getLowRankFilmOfYear(path)
                        .forEach((year, film) -> System.out.println("Год: " + year + ". Фильм: " + film.getName() + ". Оценка: " + film.getScore()));
        System.out.println();

        /*
        //сортировка фильмов по длительности
        System.out.println("-=Отсортированные по длительности фильмы=-");
        List<Movie> movie = reader.readFile(path);
        Collections.sort(movie);
        movie.forEach(System.out::println);

         */
    }
}
