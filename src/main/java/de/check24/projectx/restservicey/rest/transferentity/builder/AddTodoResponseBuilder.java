package de.check24.projectx.restservicey.rest.transferentity.builder;

import java.util.Iterator;

import javax.annotation.Generated;

import de.check24.projectx.restservicey.domain.Todo;
import de.check24.projectx.restservicey.rest.transferentity.AddTodoResponse;

/**
 * @author Tomas Skalicky
 *         <p/>
 *         Created on 20.06.2014
 *         <p/>
 *         Copyright (c) 2014, Check24 Vergleichsportal GmbH
 */
@Generated("by IntelliJ Builder")
public class AddTodoResponseBuilder {
	private Boolean added;
	private Iterator<Todo> existingTodos;

	private AddTodoResponseBuilder() {
	}

	public static AddTodoResponseBuilder anAddTodoResponse() {
		return new AddTodoResponseBuilder();
	}

	public AddTodoResponseBuilder withAdded(Boolean added) {
		this.added = added;
		return this;
	}

	public AddTodoResponseBuilder withExistingTodos(Iterator<Todo> existingTodos) {
		this.existingTodos = existingTodos;
		return this;
	}

	public AddTodoResponse build() {
		AddTodoResponse addTodo = new AddTodoResponse();
		addTodo.setAdded(added);
		addTodo.setExistingTodos(existingTodos);
		return addTodo;
	}
}
