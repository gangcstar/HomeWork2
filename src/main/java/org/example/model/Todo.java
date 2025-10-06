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
    private List<Todo> subTodos = new ArrayList<>();

    public Todo(String name, List<Todo> subTodos){
        this.id = Identifier.INSTANCE.generate();
        this.name = name;
        this.date = LocalDateTime.now();
        this.status = Status.IN_PROGRESS;
        if(subTodos != null) {
            this.subTodos = subTodos;
        }
    }

    //Сеттеры и геттеры
    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }
    public String getName() {
        return name;
    }

    public List<Todo> getSubTodos() {
        return subTodos;
    }

    public LocalDateTime getDate() {
        return date;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void updateStatus() {
        for (int i = 0; i < subTodos.size(); i++) {
            subTodos.get(i).setStatus(Status.DONE);

        }
    }

    @Override
    public String toString() {
        return "Todo " +
                "id = " + id +
                ", name = " + name +
                ", date = " + date +
                ", status=" + status +
                ", subTodos=" + subTodos;
    }
}
