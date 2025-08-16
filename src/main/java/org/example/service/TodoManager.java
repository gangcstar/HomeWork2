package org.example;

public interface TodoManager {
    void add(Todo todo);

    void getAll();

    void complete(int id);
}
