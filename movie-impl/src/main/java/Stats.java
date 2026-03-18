import java.net.URISyntaxException;
import java.nio.file.Path;

public class Stats {
    static CsvReader reader;
    static MovieStatsService stats;
//    static Path path = Path.of("src/main/resources/NetflixOriginals.csv");
    static Path path;
    {
        try {
            path = Path.of(this.getClass().getClassLoader().getResource("./NetflixOriginals.csv").toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        reader = new CsvReaderImpl();
        stats = new MovieStatsServiceImpl(reader);

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
