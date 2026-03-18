import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
class CsvReaderImplTest {
    @InjectMocks
    private CsvReaderImpl csvReaderImpl;

    @Mock
    private CsvReader csvReader;


    private Path varPath;
    {
        try {
            varPath = Path.of(this.getClass().getClassLoader().getResource("./EmptyMovie.csv").toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Должен прочитать пустой файл")
    void shouldReadZeroMoviesFromEmptyFile() {
        //Given
        CsvReaderImpl reader = new CsvReaderImpl();

        //When
        List<Movie> result = reader.readFile(varPath);
        List<Movie> expected = new ArrayList();

        //Then
        assertEquals(result, expected);

    }

    @Test
    @DisplayName("Должен прочитать пустой мок файл")
    void shouldReadZeroMoviesFromEmptyFileWithMockito() {
        Mockito.when(csvReader.readFile(varPath)).thenReturn(List.of());

        List<Movie> result = csvReader.readFile(varPath);
        assertThat(result, empty());
    }

    @Test
    @DisplayName("Должен прочитать не пустой файл")
    void shouldReadNonEmptyFile() {
        Movie movie = new Movie();
        List<Movie> movies = List.of(movie);
        Mockito.when(csvReader.readFile(varPath)).thenReturn(movies);

        List<Movie> result = csvReader.readFile(varPath);
        assertThat(result, not(empty()));
    }

    @Test
    @DisplayName("Должен корректно считать строки, подсчитать количество и распарсить их")
    void shouldCorrectReadLineAndCountingAndParcing() throws URISyntaxException {
        Path goodMoviePath = Path.of(this.getClass().getClassLoader().getResource("./GoodMovie.csv").toURI());
        CsvReader reader = new CsvReaderImpl();
        List<Movie> movies = reader.readFile(goodMoviePath);

        assertThat(movies, hasSize(3));

        Movie movie = movies.get(0);
        assertThat(movie.getName(), is("Enter the Anime"));
        assertThat(movie.getGenre(), is("Documentary"));
        assertThat(movie.getPremiere(), is(LocalDate.of(2019,8,05)));
        assertThat(movie.getRuntime(), is(58));
        assertThat(movie.getScore(), is(2.5));
        assertThat(movie.getLanguage(), is("English/Japanese"));
    }

    @Test
    @DisplayName("Должен прочитать файл с неверной структурой и выбросить ошибку")
    void shouldReadWrongStructureLine() throws URISyntaxException {
        Path wrongMovieSignature = Path.of(this.getClass().getClassLoader().getResource("./WrongMovieSignature.csv").toURI());

        CsvReader readerWrong = new CsvReaderImpl();

        assertThrows(
                Exception.class,
                () -> readerWrong.readFile(wrongMovieSignature)
        );

    }

    @Test
    @DisplayName("Должен прочитать неверный формат файла и выбросить ошибку")
    void shouldReadWrongFormatFile() throws URISyntaxException {
        CsvReader reader = new CsvReaderImpl();

        assertThrows(
                Exception.class,
                () -> reader.readFile(Path.of(this.getClass().getClassLoader().getResource("./file").toURI()))
        );
    }
}