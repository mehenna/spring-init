package com.mmi.review.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmi.review.model.Todo;
import com.mmi.review.service.TodoService;

@Controller
public class Todocontroller {
	
	private  TodoService todoService ;

	@Autowired
	public Todocontroller(TodoService todoService) {
		this.todoService = todoService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), false));
	}
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value="/list-todos")
	public String showTodosList(ModelMap model) {
		model.put("todos", todoService.retrieveTodos("fack"));
		return "list-todos";
	}

	@GetMapping(value="/add-todo")
	public String addTodosList(ModelMap model) {
		model.addAttribute("todo", new Todo(0,getLoggedInUserName(model) ,"INIT", new Date(),false));
		return "todo";
	}

	@PostMapping(value="/add-todo")
	public String addTodo(ModelMap model,@Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		todoService.addTodos(getLoggedInUserName(model) , todo.getDesc(), new Date(), false);
		return "redirect:/list-todos";
	}

	
	@GetMapping(value="/delete-todo")
	public String deleteTodosList(@RequestParam int id) {
		todoService.deleteTodo(id-1);
		return "redirect:/list-todos";
	}

	@GetMapping(value="/update-todo")
	public String updateTodo(ModelMap model , @RequestParam int id) throws Exception {
		if(id==1)
			throw new Exception("Teste generating Errors !!!");
		
		Optional<Todo> result =  todoService.retrieveTodo(id) ;
		Todo todo= result.isPresent() ? result.get() : null;
		model.put("todo",todo);
		return "todo";
	}

	@PostMapping(value="/update-todo")
	public String updateTodo(ModelMap model,@Valid Todo todo, BindingResult result)  {
		if (result.hasErrors()) {
			return "todo";
		}
		todo.setUser(getLoggedInUserName(model));
		todoService.updateTodos(todo);
		return "redirect:/list-todos";
	}
//	/**
//	 * 
//	 * @param model
//	 * @return
//	 */
//	private String getLoggedInUserName(ModelMap model) {
//		return (String)model.get("name");
//	}
	
	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getPassword();
		else
			return principal.toString();
	}
}

