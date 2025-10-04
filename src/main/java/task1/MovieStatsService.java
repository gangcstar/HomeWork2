package task1;

import java.util.List;
import java.util.Map;

public interface MovieStatsService {
    Map<String, Integer> countMoviesByGenre(List<Movie> movie);
    List<Movie> countTopPopular(List<Movie> movie, int topN);
    Map<String, Integer> countMoviesByLanguage(List<Movie> movies);
    Movie getNewestMovie(List<Movie> movie);
    Movie getOldestMovie(List<Movie> movie);
    String getGeneralRuntime(List<Movie> movie);

}
