package de.check24.projectx.restservicey.rest.transferentity.builder;

import java.util.Iterator;

import javax.annotation.Generated;

import de.check24.projectx.restservicey.domain.Todo;
import de.check24.projectx.restservicey.rest.transferentity.RemoveTodoResponse;

/**
 * @author Tomas Skalicky
 *         <p/>
 *         Created on 20.06.2014
 *         <p/>
 *         Copyright (c) 2014, Check24 Vergleichsportal GmbH
 */
@Generated("by IntelliJ Builder")
public class RemoveTodoResponseBuilder {
	private Boolean removed;
	private Iterator<Todo> existingTodos;

	private RemoveTodoResponseBuilder() {
	}

	public static RemoveTodoResponseBuilder aRemoveTodoResponse() {
		return new RemoveTodoResponseBuilder();
	}

	public RemoveTodoResponseBuilder withRemoved(Boolean removed) {
		this.removed = removed;
		return this;
	}

	public RemoveTodoResponseBuilder withExistingTodos(Iterator<Todo> existingTodos) {
		this.existingTodos = existingTodos;
		return this;
	}

	public RemoveTodoResponse build() {
		RemoveTodoResponse removeTodo = new RemoveTodoResponse();
		removeTodo.setRemoved(removed);
		removeTodo.setExistingTodos(existingTodos);
		return removeTodo;
	}
}
