package org.example;

import org.example.model.SubTodo;
import org.example.model.Todo;
import org.example.service.TodoManagerInMemory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Todo todo = new Todo("todo1");
        Todo todo3 = new Todo("todo3");
        SubTodo todo2 = new SubTodo("todo2", todo);

        TodoManagerInMemory manager = new TodoManagerInMemory();
        manager.add(todo);
        manager.add(todo2);
        manager.add(todo3);

        System.out.println(manager.getAll());

    }
}