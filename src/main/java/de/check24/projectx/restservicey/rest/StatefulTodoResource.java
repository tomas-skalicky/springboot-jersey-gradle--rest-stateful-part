package de.check24.projectx.restservicey.rest;

import java.util.Iterator;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;

import de.check24.projectx.restservicey.domain.StatefulTodos;
import de.check24.projectx.restservicey.domain.Todo;
import de.check24.projectx.restservicey.rest.transferentity.AddTodoResponse;
import de.check24.projectx.restservicey.rest.transferentity.RemoveTodoResponse;
import de.check24.projectx.restservicey.rest.transferentity.UpdateTodoResponse;
import de.check24.projectx.restservicey.rest.transferentity.builder.AddTodoResponseBuilder;
import de.check24.projectx.restservicey.rest.transferentity.builder.RemoveTodoResponseBuilder;
import de.check24.projectx.restservicey.rest.transferentity.builder.UpdateTodoResponseBuilder;

/**
 * @author Tomas Skalicky
 *         <p>
 *         Created on 20.05.2014
 *         </p>
 *         <p>
 *         Copyright (c) 2014, Check24 Vergleichsportal GmbH
 */
@RestController
// @Path("/")
@RequestMapping("/stateful")
@Scope(value = "prototype")
public class StatefulTodoResource {

	@Inject
	private StatefulTodos todos;

	// @POST
	// @Consumes(MediaType.APPLICATION_JSON)
	// @Produces(MediaType.APPLICATION_JSON)
	// @Path("/add")
	// public Response addTodo(Todo todo) {
	// if (todos == null) {
	// todos = new StatefulTodos();
	// }
	// todos.add(todo);
	// return
	// Response.status(Response.Status.CREATED).entity(todos.getAll()).build();
	// }

	// Spring

	/**
	 * Adds a new {@link Todo}.
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public AddTodoResponse addTodo(@RequestBody Todo todo) {
		if (todos == null) {
			todos = new StatefulTodos();
		}

		boolean added = todos.add(todo);
		Iterator<Todo> existingTodos = todos.getAll();
		return AddTodoResponseBuilder.anAddTodoResponse().withAdded(added).withExistingTodos(existingTodos).build();
	}

	/**
	 * Updates an existing {@link Todo}.
	 */
	@RequestMapping(value = "/update/{todoId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public UpdateTodoResponse updateTodo(@PathVariable Integer todoId, @RequestBody Todo todoToBeUpdated) {
		Preconditions.checkNotNull(todos, "Collection of TODOs cannot be null");

		boolean updated = todos.update(todoId, todoToBeUpdated);
		Iterator<Todo> existingTodos = todos.getAll();
		return UpdateTodoResponseBuilder.anUpdateTodoResponse().withUpdated(updated).withExistingTodos(existingTodos).build();
	}

	/**
	 * Removes an existing {@link Todo}.
	 */
	@RequestMapping(value = "/remove/{todoId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public RemoveTodoResponse deleteTodo(@PathVariable Integer todoId) {
		Preconditions.checkNotNull(todos, "Collection of TODOs cannot be null");

		boolean removed = todos.remove(todoId);
		Iterator<Todo> existingTodos = todos.getAll();
		return RemoveTodoResponseBuilder.aRemoveTodoResponse().withRemoved(removed).withExistingTodos(existingTodos).build();
	}
}
