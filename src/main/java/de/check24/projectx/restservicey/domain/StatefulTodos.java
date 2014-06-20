package de.check24.projectx.restservicey.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.google.common.base.Preconditions;

/**
 * @author Tomas Skalicky
 *         <p/>
 *         Created on 18.06.2014
 *         <p/>
 *         Copyright (c) 2014, Check24 Vergleichsportal GmbH
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class StatefulTodos implements Serializable {

	private static final long serialVersionUID = 6100417400436384332L;

	private final List<Todo> todos = new ArrayList<Todo>();

	public StatefulTodos() {
		Logger.getLogger(StatelessTodos.class).debug("new instance of StatefulTodos");
	}

	public Iterator<Todo> getAll() {
		return todos.iterator();
	}

	public void add(Todo todo) {
		Preconditions.checkNotNull(todo, "TODO which is to be added cannot be null");
		Preconditions.checkNotNull(todo.getId(), "ID of TODO which is to be added needs to be given");

		if (todos.stream().anyMatch(t -> t.getId().equals(todo.getId()))) {
			throw new IllegalArgumentException("TODO with the same ID is already present");
		}

		todos.add(todo);
	}

	public void update(Integer todoId, Todo todoToBeUpdated) {
		Preconditions.checkNotNull(todoId, "ID of TODO which is to be updated needs to be given");
		Preconditions.checkNotNull(todoToBeUpdated, "TODO which is to be updated cannot be null");
		Preconditions.checkArgument(todoToBeUpdated.getId().equals(todoId),
				"ID argument and ID property of TODO need to be equal");

		// Replaces the old todo with the new one.
		for (int todoIndex = 0; todoIndex < todos.size(); ++todoIndex) {
			if (todos.get(todoIndex).getId().equals(todoId)) {
				todos.set(todoIndex, todoToBeUpdated);
			}
		}
	}

	public void delete(Integer todoId) {
		Preconditions.checkNotNull(todoId, "ID of TODO which is to be updated needs to be given");

		// TODO
	}
}
