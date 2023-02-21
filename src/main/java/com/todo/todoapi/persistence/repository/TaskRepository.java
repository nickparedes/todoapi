package com.todo.todoapi.persistence.repository;

import com.todo.todoapi.persistence.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;


//Este es un repositorio de acceso a datos para la clase Task
// el primer parametro es del tipo de dato de nuestra entidad
// el segundo parametro es del tipo de datos de nuestro id
public interface TaskRepository  extends JpaRepository <Task, Long> {
}
