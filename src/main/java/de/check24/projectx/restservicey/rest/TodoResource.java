package de.check24.projectx.restservicey.rest;

import java.util.Iterator;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

	// @GET
	// @Produces(MediaType.APPLICATION_JSON)
	// @Path("/")
	// public Response getAllTodos() {
	// List<Todo> existingTodos = todoService.getAllExisting();
	// return
	// Response.status(Response.Status.OK).entity(existingTodos.get(0)).build();
	// }
	//
	// @GET
	// @Produces(MediaType.APPLICATION_JSON)
	// @Path("/get/{text}")
	// public Response getTodos(@PathParam("text") String text) {
	// Iterator<Todo> foundTodos = todoService.getByText(text);
	// return Response.status(Response.Status.OK).entity(foundTodos).build();
	// }

	// Spring

	/**
	 * @return All existing {@link Todo}s
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public Iterator<Todo> getAllTodos() {
		return todoService.getAll();
	}
}
