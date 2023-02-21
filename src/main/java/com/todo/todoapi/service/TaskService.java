package com.todo.todoapi.service;

import com.todo.todoapi.mapper.TaskInDTOToTask;
import com.todo.todoapi.persistence.entity.Task;
import com.todo.todoapi.persistence.repository.TaskRepository;
import com.todo.todoapi.service.dto.TaskInDTO;
import org.springframework.stereotype.Service;

import java.util.List;

//Dentro de este packete utilizaremos toda la logica para nuestras funcionalidades
//por ejemplo en esta clase implementaremos la funcionalidad de crear tareas


@Service
public class TaskService {


    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;
    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDto){
        Task task = mapper.map(taskInDto);
        return this.repository.save(task);
    }

    public List<Task> finAll(){
        return this.repository.findAll();
    }

}
