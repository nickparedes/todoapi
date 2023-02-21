package com.todo.todoapi.service;

import com.todo.todoapi.exceptions.ToDoExceptions;
import com.todo.todoapi.mapper.TaskInDTOToTask;
import com.todo.todoapi.persistence.entity.Task;
import com.todo.todoapi.persistence.entity.TaskStatus;
import com.todo.todoapi.persistence.repository.TaskRepository;
import com.todo.todoapi.service.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    public void updateTaskAsFinishes(Long id){
        Optional<Task> optionalTask = this.repository.findById(id);

        if(optionalTask.isEmpty()){
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.markTaskAsFinished(id);
    }

    public List<Task> findAllByTaskStatus(TaskStatus status){
        return this.repository.findAllByTaskStatus(status);
    }



    public void deleteById(Long id){
        Optional<Task> optionalTask = this.repository.findById(id);

        if(optionalTask.isEmpty()){
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }




}
