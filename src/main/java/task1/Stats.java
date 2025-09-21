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
        List<Movie> movies = reader.readFile(path);
        //List<Movie> lists =  reader.readFile(path);
        //stats.countMoviesByGenre(lists);

        for (int i = 0; i < movies.size(); i++) {
            System.out.println(movies.get(i));
        }

    }
}
