package de.check24.projectx.restservicey.domain.builder;

import java.time.OffsetDateTime;

import javax.annotation.Generated;

import de.check24.projectx.restservicey.domain.Todo;

/**
 * @author Tomas Skalicky
 *         <p/>
 *         Created on 20.06.2014
 *         <p/>
 *         Copyright (c) 2014, Check24 Vergleichsportal GmbH
 */
@Generated("by IntelliJ Builder")
public class TodoBuilder {
	private Integer id;
	private String text;
	private OffsetDateTime dueDate;

	private TodoBuilder() {
	}

	public static TodoBuilder aTodo() {
		return new TodoBuilder();
	}

	public TodoBuilder withId(Integer id) {
		this.id = id;
		return this;
	}

	public TodoBuilder withText(String text) {
		this.text = text;
		return this;
	}

	public TodoBuilder withDueDate(OffsetDateTime dueDate) {
		this.dueDate = dueDate;
		return this;
	}

	public Todo build() {
		Todo todo = new Todo();
		todo.setId(id);
		todo.setText(text);
		todo.setDueDate(dueDate);
		return todo;
	}
}
