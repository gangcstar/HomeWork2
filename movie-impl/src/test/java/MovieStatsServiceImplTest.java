import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieStatsServiceImplTest {
    @Mock
    private CsvReader csvReader;

    @InjectMocks
    private  MovieStatsServiceImpl service;

    private List<Movie> movies;

    private Path path;

    @BeforeEach
    void setUp() {
        movies = List.of(
                new Movie("Enter the Anime", "Drama" , LocalDate.of(2019,8,5), 58, 2.5, "English/Japanese"),
                new Movie("Dark Forces", "Thriller", LocalDate.of(2020,8,21), 81, 2.6, "Spanish"),
                new Movie("The App", "Drama", LocalDate.of(2019,12,26), 79, 2.0, "Spanish")
        );
    }
    @Test
    @DisplayName("Должен считать количество жанров")
    void shouldCountMoviesByGenre() {
        when(csvReader.readFile(any())).thenReturn(movies);

        Map<String, Long> result = service.countMoviesByGenre(path);

        assertThat(result, aMapWithSize(2));
        assertThat(result, hasEntry("Drama", 2L));
        assertThat(result,hasEntry("Thriller", 1L));
    }

    @Test
    @DisplayName("Возвращает ТОП-N популярных по рейтингу фильмов")
    void shouldCountTopPopular() {
        when(csvReader.readFile(any())).thenReturn(movies);

        List<Movie> top3Movie = service.countTopPopular(path, 3);

        assertThat(top3Movie, hasSize(3));
        assertThat(top3Movie.get(0).getScore(), is (2.6));
        assertThat(top3Movie.get(1).getScore(), is (2.5));
        assertThat(top3Movie.get(2).getScore(), is (2.0));
    }

    @Test
    @DisplayName("Считает количество фильмов по жанрам")
    void shouldCountMoviesByLanguage() {
        when(csvReader.readFile(any())).thenReturn(movies);

        Map<String, Long> langCount = service.countMoviesByLanguage(path);

        assertThat(langCount, hasEntry("English/Japanese", 1L));
        assertThat(langCount, hasEntry("Spanish", 2L));
    }

    @Test
    @DisplayName("Возвращает самый новый фильм")
    void shouldReturnNewestMovie() {
        when(csvReader.readFile(any())).thenReturn(movies);

        Movie newest = service.getNewestMovie(path);

        assertThat(newest.getPremiere(), is(LocalDate.of(2020,8,21)));
    }

    @Test
    @DisplayName("Возвращает самый старый фильм")
    void shouldReturnOldestMovie() {
        when(csvReader.readFile(any())).thenReturn(movies);

        Movie oldest = service.getOldestMovie(path);

        assertThat(oldest.getPremiere(), is(LocalDate.of(2019,8,5)));
    }

    @Test
    @DisplayName("Должен подсчитать общую длительность фильмов")
    void shouldCalculateGeneralRuntime() {
        when(csvReader.readFile(any())).thenReturn(movies);

        String runtime = service.getGeneralRuntime(path);

        assertThat(runtime, containsString("218"));

    }

    @Test
    @DisplayName("Возвращает самый лучший фильм по рейтингу за год")
    void shouldReturnHighRankFilmOfYear() {
        when(csvReader.readFile(any())).thenReturn(movies);

        Map<Integer, Movie> highRank = service.getHighRankFilmOfYear(path);

        assertThat(highRank.get(2019).getScore(), is (2.5));
    }

    @Test
    @DisplayName("Возвращает самый худший фильм по рейтингу за год")
    void shouldReturnLowRankFimlOfYear() {
        when(csvReader.readFile(any())).thenReturn(movies);

        Map<Integer, Movie> lowRank = service.getLowRankFilmOfYear(path);

        assertThat(lowRank.get(2019).getScore(), is (2.0));
    }

}