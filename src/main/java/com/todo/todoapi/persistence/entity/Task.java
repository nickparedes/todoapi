package com.todo.todoapi.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data   // nos permitirá utilizar getters y setters de la clase
@Entity //Especificamos que es una entidad de base de datos
@Table(name = "task") //Especificamos que es una tabla y tambien le damos un nombre
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime eta;
    private boolean finished;
    private TaskStatus taskStatus;
}
