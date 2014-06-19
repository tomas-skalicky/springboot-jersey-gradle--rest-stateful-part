package de.check24.projectx.restservicey.services.impl;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import de.check24.projectx.restservicey.domain.Todo;
import de.check24.projectx.restservicey.services.TodoService;

/**
 * @author Tomas Skalicky
 *         <p>
 *         Created on 20.05.2014
 *         </p>
 *         <p>
 *         Copyright (c) 2014, Check24 Vergleichsportal GmbH
 */
@Service
public class StatelessTodoServiceImpl implements TodoService {

	private final Todo[] todos = {
			new Todo.Builder().withId(1).withText("Todo1").withDueDate(OffsetDateTime.now().plusHours(1))
					.build(),
			new Todo.Builder().withId(2).withText("Todo2").withDueDate(OffsetDateTime.now().plusDays(2))
					.build() };

	@Override
	public Iterator<Todo> getAllExisting() {
		return Arrays.asList(todos).iterator();
	}

	@Override
	public Iterator<Todo> getByText(String text) {
		if (text == null) {
			return new ArrayList<Todo>().iterator();
		}

		List<Todo> filteredTodos = new ArrayList<>();
		for (Todo todo : todos) {
			if (text.equals(todo.getText())) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos.iterator();
	}
}
