package task2.service;
import task2.model.Todo;
import java.util.List;

public interface TodoManager {
    void add(Todo todo);

    List<Todo> getAll();

    void complete(int id);
}
