package de.check24.projectx.restservicey.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.common.base.Preconditions;

/**
 * @author Tomas Skalicky
 *         <p/>
 *         Created on 18.06.2014
 *         <p/>
 *         Copyright (c) 2014, Check24 Vergleichsportal GmbH
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class StatelessTodos implements Serializable {

	private static final long serialVersionUID = 7858094579796686438L;

	private final List<Todo> todos = new ArrayList<Todo>();

	public StatelessTodos() {
		System.err.println("new instance of StatelessTodos");
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
		Preconditions.checkArgument(!todoToBeUpdated.getId().equals(todoId),
				"ID argument and ID property of TODO need to be equal");

		// Replaces the old todo with the new one.
		for (int todoIndex = 0; todoIndex < todos.size(); ++todoIndex) {
			if (todos.get(todoIndex).getId().equals(todoId)) {
				todos.set(todoIndex, todoToBeUpdated);
			}
		}
	}
}
