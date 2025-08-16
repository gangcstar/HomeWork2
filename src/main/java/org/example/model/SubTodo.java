package org.example;

import java.time.LocalDateTime;

public class SubTodo extends Todo {
    private Todo todo;

    public SubTodo(String name, Todo todo) {
        super(name);
        this.todo = todo;
    }

    @Override
    public String toString() {
        return "SubTodo" +
                "id = " + id +
                ", name = " + name +
                ", date = " + date +
                ", status=" + status;
    }
}
