package com.todo.todoapi.persistence.repository;

import com.todo.todoapi.persistence.entity.Task;
import com.todo.todoapi.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


//Este es un repositorio de acceso a datos para la clase Task
// el primer parametro es del tipo de dato de nuestra entidad
// el segundo parametro es del tipo de datos de nuestro id
public interface TaskRepository  extends JpaRepository <Task, Long> {

    public List<Task> findAllByTaskStatus(TaskStatus status);

    @Modifying //Es una query de actualizacion
    @Query(value="update TASK SET FINISHED=true where ID=:id", nativeQuery = true)
    public void markTaskAsFinished(@Param("id") Long id);
}
