package org.example;

import java.util.HashMap;
import java.util.Map;

public class TodoManagerInMemory implements TodoManager {

    private final Map<Integer, Todo> notes = new HashMap<>();

    @Override
    public void add(Todo todo) {
        notes.put(todo.getId(), todo);

    }

    @Override
    public void getAll() {

    }

    @Override
    public void complete(int id) {

    }
}
