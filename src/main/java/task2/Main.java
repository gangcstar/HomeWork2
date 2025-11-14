package task2;

import task2.model.Todo;
import task2.service.TodoManagerInMemory;

import java.io.File;
import java.lang.reflect.Array;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main (String[] args) {
        Todo subtodo1 = new Todo("Подзадача1", null);
        Todo subtodo2 = new Todo("Подзадача2", null);
        Todo todo1 = new Todo("Главная задача", List.of(subtodo1, subtodo2));

        TodoManagerInMemory manager = new TodoManagerInMemory();
        manager.add(subtodo1);
        manager.add(subtodo2);
        manager.add(todo1);


        System.out.println(manager.getAll());
        //manager.complete(3);
        System.out.println(todo1);

        try {
            main(new String[]{});

        }
        finally {
            System.out.println("123");
        }
    }
}