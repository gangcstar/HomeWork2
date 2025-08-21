package org.example.service;

import org.example.model.Todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoManagerInMemory implements TodoManager {

    private final Map<Integer, Todo> notes = new HashMap<>();

    @Override
    public void add(Todo todo) {
        notes.put(todo.getId(), todo);

    }

    @Override
    public List<Todo> getAll() {
        List<Todo> result = new ArrayList<>();
        for (Todo todo : notes.values()) {
            result.add(todo);
        }
        return result;
    }

    @Override
    public void complete(int id) {

    }
}
