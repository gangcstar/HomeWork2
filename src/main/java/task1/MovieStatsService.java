package task1;

import java.util.List;
import java.util.Map;

public interface MovieStatsService {
    Map<String, Integer> countMoviesByGenre(List<Movie> movie);
    List<Movie> countTopPopular(List<Movie> movie, int topN);
}
