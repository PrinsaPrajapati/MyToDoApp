package com.prinsa.springboot.MyToDoApp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class ToDoControllerJpa {

	// @Autowired
	private ToDoRepository todoRepository;

	public ToDoControllerJpa(ToDoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username = getLopggedinUserName(model);

		List<Todo> todos = todoRepository.findByUsername(username);
		model.addAttribute("todos", todos);

		return "listToDos";
	}

	// http://localhost:8080/login
	// GET, POST
	@GetMapping("add-todo")
	public String showNewTodoPage(ModelMap model) {

		String username = getLopggedinUserName(model);
		Todo todo = new Todo(0, username, "Default Desc", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);

		return "todo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	// @PostMapping("add-todo")
	public String addNewTodo(ModelMap model, @Valid @ModelAttribute("todo") Todo todo, BindingResult result) {// BindingResult
																												// result

		if (result.hasErrors()) {
			return "todo";
		}
		String username = getLopggedinUserName(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}

	private String getLopggedinUserName(ModelMap model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		authentication.getName();
		return authentication.getName();
	}

	// Delete todo
	@RequestMapping("delete-todo")
	// @RequestMapping(value="delete-todo", method = RequestMethod.DELETE)
	public String deleteTodo(@RequestParam int id) {
		todoRepository.deleteById(id);
		return "redirect:list-todos";

	}

	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateToDo(ModelMap model, @Valid @ModelAttribute("todo") Todo todo, BindingResult result) {// BindingResult
																												// result
		if (result.hasErrors()) {
			return "todo";
		}
		String username = getLopggedinUserName(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
}
