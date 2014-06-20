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
public class UpdateTodoResponse implements Serializable {

	private static final long serialVersionUID = 2945426364767045371L;

	private Boolean updated;
	private Iterator<Todo> existingTodos;

	public Boolean getUpdated() {
		return updated;
	}

	public void setUpdated(Boolean updated) {
		this.updated = updated;
	}

	public Iterator<Todo> getExistingTodos() {
		return existingTodos;
	}

	public void setExistingTodos(Iterator<Todo> existingTodos) {
		this.existingTodos = existingTodos;
	}
}
