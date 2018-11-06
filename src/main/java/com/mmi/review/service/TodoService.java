package com.mmi.review.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mmi.review.model.Todo;

@Service
public class TodoService {
	private static List<Todo> todos = null;

	static {
		todos = new ArrayList<>(Arrays.asList(new Todo(1, "user_One", "Learn Spring MVC", new Date(), false),
				new Todo(2, "user_Two", "Learn Struts", new Date(), false),
				new Todo(3, "user_Three", "Learn Hibernate", new Date(), false)));

	}

	/**
	 * Retrieve element from the initial list supplied
	 * 
	 * @param user
	 * @return
	 */
	public List<Todo> retrieveTodos(final String user) {
		System.out.println("------------------------------------->" + user);
		//Comparator<Todo> comparator = (t1, t2) -> t1.getId() - t1.getId();
		TodoService.todos.stream().forEach(System.err::println);
		
		//TodoService.todos = TodoService.todos.stream().filter(todo -> !todo.getUser().equals(user)).sorted(comparator).collect(Collectors.toList());
		return TodoService.todos;
	}

	/**
	 * 
	 * @param name
	 * @param desc
	 * @param targetDate
	 * @param isDone
	 */
	public void addTodos(final String name, final String desc, final Date targetDate, final boolean isDone) {
		int position = TodoService.todos.get(TodoService.todos.size() - 1).getId() + 1;
		TodoService.todos.add(new Todo(position, name, desc, targetDate, isDone));
	}

	public void deleteTodo(final int id) {
		TodoService.todos = TodoService.todos.stream().filter(t -> t.getId() != id)
				.sorted((t1, t2) -> t1.getId() - t1.getId())
				//.peek(todo -> System.out.println("deleteTod->" + todo.toString()))
				.collect(Collectors.toList());
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Todo> retrieveTodo(final int id) {
		List<Todo> result = TodoService.todos.stream().filter(todo -> todo.getId() == id)
				.collect(Collectors.toList());
		return Optional.ofNullable(result.get(0));
	}

	public void updateTodos(final Todo todo) {
		TodoService.todos = TodoService.todos.stream().filter(t -> t.getId() != todo.getId()).collect(Collectors.toList());
		addTodos(todo.getUser(), todo.getDesc(), todo.getTargetdate(), todo.isDone());
		TodoService.todos = TodoService.todos.stream().sorted((t1, t2) -> t1.getId() - t1.getId()).collect(Collectors.toList());
	}
}
