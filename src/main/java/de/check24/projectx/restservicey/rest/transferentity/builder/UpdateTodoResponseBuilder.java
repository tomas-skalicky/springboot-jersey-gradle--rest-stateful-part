package de.check24.projectx.restservicey.rest.transferentity.builder;

import java.util.Iterator;

import javax.annotation.Generated;

import de.check24.projectx.restservicey.domain.Todo;
import de.check24.projectx.restservicey.rest.transferentity.UpdateTodoResponse;

/**
 * @author Tomas Skalicky
 *         <p/>
 *         Created on 20.06.2014
 *         <p/>
 *         Copyright (c) 2014, Check24 Vergleichsportal GmbH
 */
@Generated("by IntelliJ Builder")
public class UpdateTodoResponseBuilder {
	private Boolean updated;
	private Iterator<Todo> existingTodos;

	private UpdateTodoResponseBuilder() {
	}

	public static UpdateTodoResponseBuilder anUpdateTodoResponse() {
		return new UpdateTodoResponseBuilder();
	}

	public UpdateTodoResponseBuilder withUpdated(Boolean updated) {
		this.updated = updated;
		return this;
	}

	public UpdateTodoResponseBuilder withExistingTodos(Iterator<Todo> existingTodos) {
		this.existingTodos = existingTodos;
		return this;
	}

	public UpdateTodoResponse build() {
		UpdateTodoResponse updateTodo = new UpdateTodoResponse();
		updateTodo.setUpdated(updated);
		updateTodo.setExistingTodos(existingTodos);
		return updateTodo;
	}
}
