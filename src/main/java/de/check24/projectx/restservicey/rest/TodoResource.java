package de.check24.projectx.restservicey.rest;

import java.util.Iterator;

import javax.inject.Inject;
import javax.ws.rs.PathParam;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;

import de.check24.projectx.restservicey.domain.StatefulTodos;
import de.check24.projectx.restservicey.domain.StatelessTodos;
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
@RestController
// @Path("/")
@RequestMapping("/")
@Scope(value = "prototype")
public class TodoResource {

	@Inject
	private TodoService todoService;

	@Inject
	private StatefulTodos statefulTodos;

	@Inject
	private StatelessTodos statelessTodos;

	// @GET
	// @Produces(MediaType.APPLICATION_JSON)
	// @Path("/")
	// public Response getExistingTodos() {
	// List<Todo> existingTodos = todoService.getAllExisting();
	// return Response.status(Response.Status.OK).entity(existingTodos.get(0)).build();
	// }
	//
	// @GET
	// @Produces(MediaType.APPLICATION_JSON)
	// @Path("/getExistingTodos/{text}")
	// public Response getExistingTodos(@PathParam("text") String text) {
	// Iterator<Todo> foundTodos = todoService.getByText(text);
	// return Response.status(Response.Status.OK).entity(foundTodos).build();
	// }
	//
	// @POST
	// @Consumes(MediaType.APPLICATION_JSON)
	// @Produces(MediaType.APPLICATION_JSON)
	// @Path("/addStatefulTodo")
	// public Response addStatefulTodo(Todo newTodo) {
	//
	// if (statefulTodos == null) {
	// statefulTodos = new StatefulTodos();
	// }
	// statefulTodos.add(newTodo);
	// return Response.status(Response.Status.CREATED).entity(statefulTodos.getAll()).build();
	// }
	//
	// @PUT
	// @Consumes(MediaType.APPLICATION_JSON)
	// @Produces(MediaType.APPLICATION_JSON)
	// @Path("/addStatelessTodo")
	// public Response addStatelessTodo(Todo newTodo) {
	// if (statelessTodos == null) {
	// statelessTodos = new StatelessTodos();
	// }
	// statelessTodos.add(newTodo);
	// return Response.status(Response.Status.CREATED).entity(statelessTodos.getAll()).build();
	// }

	// Spring

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public Iterator<Todo> getExistingTodos1() {
		return todoService.getAllExisting();
	}

	@RequestMapping(value = "/add/stateful", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Iterator<Todo> addStatefulTodo(@RequestBody Todo newTodo) {
		if (statefulTodos == null) {
			statefulTodos = new StatefulTodos();
		}
		statefulTodos.add(newTodo);
		return statefulTodos.getAll();
	}

	@RequestMapping(value = "/add/stateless", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Iterator<Todo> addStatelessTodo(@RequestBody Todo newTodo) {
		if (statelessTodos == null) {
			statelessTodos = new StatelessTodos();
		}
		statelessTodos.add(newTodo);
		return statelessTodos.getAll();
	}

	@RequestMapping(value = "/update/{id}/stateful", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public Iterator<Todo> updateStatefulTodo(@PathParam("id") Integer todoId,
			@RequestBody Todo todoToBeUpdated) {
		Preconditions.checkNotNull(statefulTodos, "Collection of TODOs cannot be null");

		statefulTodos.update(todoId, todoToBeUpdated);
		return statefulTodos.getAll();
	}

	@RequestMapping(value = "/update/{id}/stateless", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public Iterator<Todo> updateStatelessTodo(@PathParam("id") Integer todoId,
			@RequestBody Todo todoToBeUpdated) {
		Preconditions.checkNotNull(statelessTodos, "Collection of TODOs cannot be null");

		statelessTodos.update(todoId, todoToBeUpdated);
		return statelessTodos.getAll();
	}
}
