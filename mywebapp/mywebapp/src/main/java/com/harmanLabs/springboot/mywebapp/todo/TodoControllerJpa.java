package com.harmanLabs.springboot.mywebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

	private TodoService todoService;
	
	private TodoRepository todoRepository;

	public TodoControllerJpa(TodoService todoService, TodoRepository todoRepository) {
		super();
		this.todoService = todoService;
		this.todoRepository=todoRepository;
	}
	
	
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		
		String username=getLoggedInUserName();
		
		List<Todo> todos=todoRepository.findByUsername(username);
		
		model.addAttribute("todos", todos);
		
		return "listTodos";
		
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username=getLoggedInUserName();
		Todo todo = new Todo(0,username,"",LocalDate.now(),false);
		model.put("todo", todo);
		return "todo";
		
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";	
		}
		
		String username=getLoggedInUserName();
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:list-todos";
		
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		
		todoRepository.deleteById(id);
		
		return "redirect:list-todos";
		
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		
		Todo todo=todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		
		return "todo";
		
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";	
		}
		//System.out.print(todo);
//		String username=(String)model.get("name");
		String username=getLoggedInUserName();
		todo.setUsername(username);
		todoRepository.save(todo);
		
		
		return "redirect:list-todos";
		
	}
	
	
	private String getLoggedInUserName() {
		
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();
	}
	
}
