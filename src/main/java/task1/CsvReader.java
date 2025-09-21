package task1;

import java.nio.file.Path;
import java.util.List;

public interface CsvReader {
    List<Movie> readFile(Path path); // class File, class Path,URI

}
