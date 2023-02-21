package com.todo.todoapi.service;

import com.todo.todoapi.persistence.entity.Task;
import com.todo.todoapi.persistence.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.awt.*;

//Dentro de este packete utilizaremos toda la logica para nuestras funcionalidades
//por ejemplo en esta clase implementaremos la funcionalidad de crear tareas


@Service
public class TaskService {


    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task createTask(Task task){

        return task;
    }

}
