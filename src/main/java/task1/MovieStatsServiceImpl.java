package task1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieStatsServiceImpl implements MovieStatsService{
    @Override
    public Map<String, Integer> countMoviesByGenre(List<Movie> movies) {
        Map<String, Integer> genreCount = new HashMap<>();
        for (Movie movie : movies) {
            String genreStr = movie.getGenre();
            if (genreStr != null && !genreStr.isEmpty()) {
                String[] genres = genreStr.split(" / ");
                for (String g : genres) {
                    String trimmed = g.trim();
                    if (!trimmed.isEmpty()) {
                        Integer count = genreCount.get(trimmed);
                        if (count == null) {
                            genreCount.put(trimmed, 1);
                        } else {
                            genreCount.put(trimmed, count + 1);
                        }
                    }
                }
            }
        }
        return genreCount;
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
