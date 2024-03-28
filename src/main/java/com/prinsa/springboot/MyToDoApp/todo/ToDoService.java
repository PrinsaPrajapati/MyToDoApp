package com.prinsa.springboot.MyToDoApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class ToDoService {

	private static List<ToDo> todos = new ArrayList<>();
	private static int todosCount = 0;

	static {
		todos.add(new ToDo(++todosCount, "prinsa", "Learn Aws certificate", LocalDate.now().plusYears(1), false));
		todos.add(new ToDo(++todosCount, "prinsa", "Learn Python certificate", LocalDate.now().plusYears(1), false));
		todos.add(new ToDo(++todosCount, "prinsa", "Learn DSA certificate", LocalDate.now().plusYears(1), false));
		todos.add(new ToDo(++todosCount, "prinsa", "Learn Microservices", LocalDate.now().plusYears(1), false));

	}

	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {

		ToDo todo = new ToDo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
	}

	public List<ToDo> findByUserName(String username) {
		return todos;

	}

	public void deleteById(int id) {
		// todo.getId() == id
		// todo -> todo.getId() == id
		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public ToDo findById(int id) {
		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		ToDo todo = todos.stream().filter(predicate).findFirst().get();//functional programming
		return todo;
	}

	public void updateTodo(@Valid ToDo todo) {
		deleteById(todo.getId());
		todos.add(todo);
		
	}
}
