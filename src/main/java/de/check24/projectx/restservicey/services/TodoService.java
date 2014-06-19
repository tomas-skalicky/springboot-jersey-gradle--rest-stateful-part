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

	Iterator<Todo> getAllExisting();

	Iterator<Todo> getByText(String text);
}
