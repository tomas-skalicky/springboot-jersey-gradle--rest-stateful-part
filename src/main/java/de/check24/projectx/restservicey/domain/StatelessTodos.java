package de.check24.projectx.restservicey.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
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
		Logger.getLogger(StatelessTodos.class).debug("new instance of StatelessTodos");
	}

	public Iterator<Todo> getAll() {
		return todos.iterator();
	}

	public boolean add(Todo todo) {
		Preconditions.checkNotNull(todo, "TODO which is to be added cannot be null");
		Preconditions.checkNotNull(todo.getId(), "ID of TODO which is to be added needs to be given");

		if (todos.stream().anyMatch(t -> t.getId().equals(todo.getId()))) {
			throw new IllegalArgumentException("TODO with the same ID is already present");
		}

		todos.add(todo);
		return true;
	}

	/**
	 * @return <code>true</code> if a {@link Todo} with the given ID has been updated; <code>false</code> otherwise.
	 */
	public boolean update(Integer todoId, Todo todoToBeUpdated) {
		Preconditions.checkNotNull(todoId, "ID of TODO which is to be updated needs to be given");
		Preconditions.checkNotNull(todoToBeUpdated, "TODO which is to be updated cannot be null");
		Preconditions.checkArgument(todoToBeUpdated.getId().equals(todoId),
				"ID argument and ID property of TODO need to be equal");

		// Replaces the old todo with the new one.
		for (int todoIndex = 0; todoIndex < todos.size(); ++todoIndex) {
			if (todos.get(todoIndex).getId().equals(todoId)) {
				todos.set(todoIndex, todoToBeUpdated);
				return true;
			}
		}
		return false;
	}

	/**
	 * @return <code>true</code> if any {@link Todo} has been removed; <code>false</code> otherwise.
	 */
	public boolean remove(Integer todoId) {
		Preconditions.checkNotNull(todoId, "ID of TODO which is to be removed needs to be given");

		return todos.removeIf(t -> t.getId().equals(todoId));
	}
}
