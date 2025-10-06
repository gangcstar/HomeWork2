package org.example.service;
import org.example.model.Todo;
import java.util.List;

public interface TodoManager {
    void add(Todo todo);

    List<Todo> getAll();

    void complete(int id);
}
