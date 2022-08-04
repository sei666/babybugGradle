package com.example.babybugGradle.repository;

import com.example.babybugGradle.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}
