package task2.service;

import task2.model.Todo;
import task2.util.Status;

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
        notes.get(id).setStatus(Status.DONE);
        notes.get(id).updateStatus();
    }
}
