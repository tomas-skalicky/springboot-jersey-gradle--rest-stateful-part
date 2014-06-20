package de.check24.projectx.restservicey.rest.transferentity;

import java.io.Serializable;
import java.util.Iterator;

import de.check24.projectx.restservicey.domain.Todo;

/**
 * @author Tomas Skalicky
 *         <p/>
 *         Created on 20.06.2014
 *         <p/>
 *         Copyright (c) 2014, Check24 Vergleichsportal GmbH
 */
public class AddTodoResponse implements Serializable {

	private static final long serialVersionUID = 202258640784733464L;

	private Boolean added;
	private Iterator<Todo> existingTodos;

	public Boolean getAdded() {
		return added;
	}

	public void setAdded(Boolean added) {
		this.added = added;
	}

	public Iterator<Todo> getExistingTodos() {
		return existingTodos;
	}

	public void setExistingTodos(Iterator<Todo> existingTodos) {
		this.existingTodos = existingTodos;
	}
}
