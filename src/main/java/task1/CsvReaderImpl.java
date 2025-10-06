package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CsvReaderImpl implements CsvReader {

    @Override
    public List<Movie> readFile(Path path) {
        List<Movie> movies = new ArrayList<>();
        String line;
        DateTimeFormatter[] formatters = {
                DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.US),
                DateTimeFormatter.ofPattern("MMMM d. yyyy", Locale.US)
    };
        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)))) {
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                Movie movie = new Movie();
                String[] split = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                movie.setName(split[0].replaceAll("\"", "").trim());
                movie.setGenre(split[1].replaceAll("\"", "").trim());
                String date = split[2].replaceAll("\"", "").trim();
                for (DateTimeFormatter formatter : formatters) {
                    try {
                        movie.setPremiere(LocalDate.parse(date, formatter));
                        break;
                    } catch (Exception e) {
                    }
                }
                movie.setRuntime(Integer.parseInt(split[3].trim()));
                movie.setScore(Double.parseDouble(split[4].trim()));
                movie.setLanguage(split[5].trim());

                movies.add(movie);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
