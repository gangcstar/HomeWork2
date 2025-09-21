package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvReaderImpl implements CsvReader {
    @Override
    public List<Movie> readFile(Path path) {
        List<Movie> movies = new ArrayList<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)))) {
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                Movie movie = new Movie();
                String[] split = line.split(",");
                movie.setName(split[0]);
                //movie.setGenre(split[1]);
                //movie.setPremiere(LocalDate.parse(split[2]));
                //movie.setRuntime(Integer.parseInt(split[3]));
                //movie.setScore(Double.parseDouble(split[4]));
                //movie.setLanguage(Languages.valueOf(split[5]));

                movies.add(movie);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
