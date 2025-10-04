package task1;

import java.util.List;
import java.util.Map;

public class MovieStatsServiceImpl implements MovieStatsService{
    @Override
    public Map<String, Integer> countMoviesByGenre(List<Movie> movie) {
        return Map.of();
    }

    @Override
    public List<Movie> countTopPopular(List<Movie> movie, int topN) {
        return List.of();
    }

    @Override
    public Map<String, Integer> countMoviesByLanguage(List<Movie> movies) {
        return Map.of();
    }

    @Override
    public Movie getNewestMovie(List<Movie> movie) {
        return null;
    }

    @Override
    public Movie getOldestMovie(List<Movie> movie) {
        return null;
    }

    @Override
    public String getGeneralRuntime(List<Movie> movie) {
        return "";
    }
}
