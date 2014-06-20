package de.check24.projectx.restservicey.services;

import java.util.Iterator;

import de.check24.projectx.restservicey.domain.Todo;

/**
 * @author Tomas Skalicky
 *         <p>
 *         Created on 20.05.2014
 *         </p>
 *         <p>
 *         Copyright (c) 2014, Check24 Vergleichsportal GmbH
 */
public interface TodoService {

	/**
	 * @return All existing {@link Todo}s
	 */
	Iterator<Todo> getAll();

	Iterator<Todo> getByText(String text);
}
