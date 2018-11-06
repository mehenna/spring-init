package com.mmi.review;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.mmi.review.model.Todo;
import com.mmi.review.service.TodoService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.NONE)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TodoServiceTests {

	@Autowired
	TodoService service;

	@Test
	public void aInit() {
	}

	@Test
	public void bTestRetrieve(){
		List<Todo> list =  service.retrieveTodos("user_Two");
		assertThat(list.size()).isGreaterThan(0);
		assertThat(list.get(0).getId()).isEqualTo(1);

	}

	@Test
	public void cTestAddTodos(){
		service.addTodos("Test feature", "Unit test learning", new Date(),false);
		assertThat(service.retrieveTodos("Smil")).isNotEmpty();
		assertThat(service.retrieveTodos("Smil").size()).isEqualTo(3);
		service.addTodos("Test feature", "Unit test learning", new Date(),false);
		assertThat(service.retrieveTodos("Smil").size()).isEqualTo(4);
	}

	@Test
	public void dTestDeleteFromTodos(){
		service.deleteTodo(1);
		assertThat(service.retrieveTodos("Smil")).isNotEmpty();
		assertThat(service.retrieveTodos("Smil").get(0).getUser()).isEqualTo("user_Three");
		service.deleteTodo(2);
		assertThat(service.retrieveTodos("Smil")).isNotEmpty();
		assertThat(service.retrieveTodos("Smil").get(0).getUser()).isEqualTo("user_Three");
		service.deleteTodo(3);
		assertThat(service.retrieveTodos("Smil")).isNotEmpty();
	}

	@Test
	public void eTestUpdateTodo(){
		assertThat(service.retrieveTodo(4).isPresent()).isTrue();
		assertThat(service.retrieveTodo(4).get().getDesc()).isEqualTo("Unit test learning");
	}
	
	@Test
	public void fTestRetrieveTodo(){
		Optional<Todo> opt =  service.retrieveTodo(4);
		assertThat(opt.isPresent()).isTrue();
		assertThat(opt.get().getDesc()).isNotEqualTo("Learn Spring MVC");
	}
}
