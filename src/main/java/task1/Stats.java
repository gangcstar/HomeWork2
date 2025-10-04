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
        Map<String, Integer> genreCount = stats.countMoviesByGenre(movies);
        for (Map.Entry<String, Integer> entry : genreCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}
