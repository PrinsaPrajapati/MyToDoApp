package com.prinsa.springboot.MyToDoApp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
@Component
public interface ToDoRepository extends JpaRepository<Todo, Integer>{

	
	public List<Todo> findByUsername(String username);
}
