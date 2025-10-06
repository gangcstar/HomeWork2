package task1;

import java.util.ArrayList;
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
    public List<Movie> countTopPopular(List<Movie> movies, int topN) {
        List<Movie> sortedMovies = new ArrayList<>(movies);
        for (int i = 0; i < sortedMovies.size() - 1; i++) {
            for (int j = 0; j < sortedMovies.size() - i - 1; j++) {
                if (sortedMovies.get(j).getScore() < sortedMovies.get(j + 1).getScore()) {
                    Movie temp = sortedMovies.get(j);
                    sortedMovies.set(j, sortedMovies.get(j + 1));
                    sortedMovies.set(j + 1, temp);
                }
            }
        }
        List<Movie> result = new ArrayList<>();
        for (int i = 0; i < Math.min(topN, sortedMovies.size()); i++) {
            result.add(sortedMovies.get(i));
        }
        return result;
    }

    @Override
    public Map<String, Integer> countMoviesByLanguage(List<Movie> movies) {
        Map<String, Integer> langCount = new HashMap<>();
        for (Movie movie : movies) {
            String lang = movie.getLanguage();
            if (lang != null && !lang.isEmpty()) {
                Integer count = langCount.get(lang);
                if (count == null) {
                    langCount.put(lang, 1);
                } else {
                    langCount.put(lang, count + 1);
                }
            }
        }
        return langCount;
    }

    @Override
    public Movie getNewestMovie(List<Movie> movies) {
        Movie newest = null;
        for (Movie movie : movies) {
            if (movie.getPremiere() != null) {
                if (newest == null || movie.getPremiere().isAfter(newest.getPremiere())) {
                    newest = movie;
                }
            }
        }
        return newest;
    }

    @Override
    public Movie getOldestMovie(List<Movie> movies) {
        Movie oldest = null;
        for (Movie movie : movies) {
            if (movie.getPremiere() != null) {
                if (oldest == null || movie.getPremiere().isBefore(oldest.getPremiere())) {
                    oldest = movie;
                }
            }
        }
        return oldest;
    }

    @Override
    public String getGeneralRuntime(List<Movie> movies) {
        int totalMinutes = 0;
        for (Movie movie : movies) {
            totalMinutes += movie.getRuntime();
        }
        int totalHours = (int) Math.round(totalMinutes / 60.0);
        int totalDays = (int) Math.round(totalMinutes / 1440.0);
        return String.format("Общая длительность: %d мин (%d часов, %d дней)", totalMinutes, totalHours, totalDays);
    }
}
