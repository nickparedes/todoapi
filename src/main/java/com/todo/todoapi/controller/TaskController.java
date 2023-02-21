package com.todo.todoapi.controller;


import com.todo.todoapi.persistence.entity.Task;
import com.todo.todoapi.persistence.entity.TaskStatus;
import com.todo.todoapi.service.TaskService;
import com.todo.todoapi.service.dto.TaskInDTO;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/status/{status}")
    public List<Task> findAllByTaskStatus(@PathVariable("status") TaskStatus status){
        return this.taskService.findAllByTaskStatus(status);
    }


    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<Void> maskAsFinished(@PathVariable("id") Long id){
        this.taskService.updateTaskAsFinishes(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        this.taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
