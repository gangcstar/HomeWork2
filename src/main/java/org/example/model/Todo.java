package org.example.model;

import org.example.util.Identifier;
import org.example.util.Status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Todo {
    protected int id;
    protected String name;
    protected LocalDateTime date;
    protected Status status;
    private List<SubTodo> subtodo = new ArrayList<>();

    public Todo(String name){
        this.id = Identifier.INSTANCE.generate();
        this.name = name;
        this.date = LocalDateTime.now();
        this.status = Status.IN_PROGRESS;
    }

    public int getId() {
        return id;
    }
    public Status getStatus() {
        return status;
    }

    public void addSubTodo(SubTodo todo) {
        subtodo.add(todo);
    }


    @Override
    public String toString() {
        return "Todo " +
                "id = " + id +
                ", name = " + name +
                ", date = " + date +
                ", status=" + status;
    }
}
