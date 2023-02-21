package com.todo.todoapi.controller;


import com.todo.todoapi.persistence.entity.Task;
import com.todo.todoapi.service.TaskService;
import com.todo.todoapi.service.dto.TaskInDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping //Notación que nos permite crear elementos
    public Task createElements(@RequestBody TaskInDTO taskInDto){
        return this.taskService.createTask(taskInDto);
    }

    @GetMapping

    public List<Task> findAll(){
        return this.taskService.finAll();
    }

}
