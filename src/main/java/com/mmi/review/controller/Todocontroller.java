package com.mmi.review.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mmi.review.model.Todo;
import com.mmi.review.service.TodoService;

@Controller
@SessionAttributes("name")
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
		model.addAttribute("todo", new Todo(0,(String)model.get("name") ,"INIT", new Date(),false));
		return "todo";
	}

	@PostMapping(value="/add-todo")
	public String addTodo(ModelMap model,@Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		todoService.addTodos((String)model.get("name") , todo.getDesc(), new Date(), false);
		return "redirect:/list-todos";
	}

	
	@GetMapping(value="/delete-todo")
	public String deleteTodosList(@RequestParam int id) {
		todoService.deleteTodo(id-1);
		return "redirect:/list-todos";
	}

	@GetMapping(value="/update-todo")
	public String updateTodo(ModelMap model , @RequestParam int id) {
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
		todo.setUser((String)model.get("name"));
		todoService.updateTodos(todo);
		return "redirect:/list-todos";
	}


}

