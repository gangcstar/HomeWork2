import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class MovieStatsServiceImpl implements MovieStatsService{
    CsvReader reader;
    public MovieStatsServiceImpl (CsvReader reader) {
        this.reader = reader;
    }
    @Override
    public Map<String, Long> countMoviesByGenre(Path pathToFile) {
        Map<String, Long> genreCount = reader.readFile(pathToFile).stream()
                .filter(movie -> movie.getGenre() != null)
                .collect(Collectors.groupingBy(Movie::getGenre,
                        Collectors.counting()
                        ));

        return genreCount;
    }

    @Override
    public List<Movie> countTopPopular(Path pathToFile, int topN) {
        List<Movie> sortedMoviesPopular = reader.readFile(pathToFile).stream()
                .sorted(Comparator.comparingDouble(Movie::getScore).reversed())
                .limit(topN)
                .collect(Collectors.toList());

        return sortedMoviesPopular;
    }

    @Override
    public Map<String, Long> countMoviesByLanguage(Path pathToFile) {
        Map<String, Long> langCount = reader.readFile(pathToFile).stream()
                .filter(movie -> movie.getLanguage() != null)
                .collect(Collectors.groupingBy(Movie::getLanguage,
                        Collectors.counting()
                ));

        return langCount;
    }

    @Override
    public Movie getNewestMovie(Path pathToFile) {
        Movie newest = reader.readFile(pathToFile).stream()
                .max(Comparator.comparing(Movie::getPremiere))
                .orElse(null);
        return newest;
    }

    @Override
    public Movie getOldestMovie(Path pathToFile) {
        Movie oldest = reader.readFile(pathToFile).stream()
                .min(Comparator.comparing(Movie::getPremiere))
                .orElse(null);
        return oldest;
    }

    @Override
    public String getGeneralRuntime(Path pathToFile) {
        int totalRuntime = reader.readFile(pathToFile).stream()
                .mapToInt(Movie::getRuntime)
                .sum();

        int totalHours = (int) Math.round(totalRuntime / 60.0);
        int totalDays = (int) Math.round(totalRuntime / 1440.0);
        return String.format("Общая длительность: %d мин (%d часов, %d дней)", totalRuntime, totalHours, totalDays);
    }

    @Override
    public Map<Integer, Movie> getHighRankFilmOfYear(Path pathToFile) {
        Map<Integer, Movie> highRank = reader.readFile(pathToFile).stream()
                .filter(f -> f.getPremiere() != null)
                .collect(Collectors.toMap(
                        movie -> movie.getPremiere().getYear(),
                        movie -> movie,
                        (movie1, movie2) -> movie1.getScore() > movie2.getScore()
                            ? movie1 : movie2

                ));
        return highRank;
    }

    @Override
    public Map<Integer, Movie> getLowRankFilmOfYear(Path pathToFile) {
        Map<Integer, Movie> lowRank = reader.readFile(pathToFile).stream()
                .filter(f -> f.getPremiere() != null)
                .collect(Collectors.toMap(
                        movie -> movie.getPremiere().getYear(),
                        movie -> movie,
                        (movie1, movie2) -> movie1.getScore() < movie2.getScore()
                                ? movie1 : movie2
                ));
        return lowRank;
    }
}
