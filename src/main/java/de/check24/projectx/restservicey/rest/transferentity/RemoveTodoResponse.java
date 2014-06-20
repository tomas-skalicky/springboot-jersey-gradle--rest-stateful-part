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
public class RemoveTodoResponse implements Serializable {

	private static final long serialVersionUID = -470005206350143224L;

	private Boolean removed;
	private Iterator<Todo> existingTodos;

	public Boolean getRemoved() {
		return removed;
	}

	public void setRemoved(Boolean removed) {
		this.removed = removed;
	}

	public Iterator<Todo> getExistingTodos() {
		return existingTodos;
	}

	public void setExistingTodos(Iterator<Todo> existingTodos) {
		this.existingTodos = existingTodos;
	}
}
