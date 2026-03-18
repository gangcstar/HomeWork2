import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public interface MovieStatsService {
    Map<String, Long> countMoviesByGenre(Path pathToFile);
    List<Movie> countTopPopular(Path pathToFile, int topN);
    Map<String, Long> countMoviesByLanguage(Path pathToFile);
    Movie getNewestMovie(Path pathToFile);
    Movie getOldestMovie(Path pathToFile);
    String getGeneralRuntime(Path pathToFile);
    Map<Integer, Movie> getHighRankFilmOfYear(Path pathToFile);
    Map<Integer, Movie> getLowRankFilmOfYear(Path pathToFile);
}
