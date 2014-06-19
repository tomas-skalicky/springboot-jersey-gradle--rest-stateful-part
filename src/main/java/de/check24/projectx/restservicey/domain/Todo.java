package de.check24.projectx.restservicey.domain;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.annotation.Generated;

/**
 * @author Tomas Skalicky
 *         <p>
 *         Created on 20.05.2014
 *         </p>
 *         <p>
 *         Copyright (c) 2014, Check24 Vergleichsportal GmbH
 */
public class Todo implements Serializable {

	private static final long serialVersionUID = -8998514761064670214L;

	private Integer id;
	private String text;
	private OffsetDateTime dueDate;

	public Todo() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public OffsetDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(OffsetDateTime dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "Todo [text=" + text + ", dueDate=" + dueDate + "]";
	}

	@Generated("by Bob the Builder")
	private Todo(Builder builder) {

		id = builder.id;
		text = builder.text;
		dueDate = builder.dueDate;
	}

	@Generated("by Bob the Builder")
	public static class Builder {

		private Integer id;
		private String text;
		private OffsetDateTime dueDate;

		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}

		public Builder withText(String text) {
			this.text = text;
			return this;
		}

		public Builder withDueDate(OffsetDateTime dueDate) {
			this.dueDate = dueDate;
			return this;
		}

		public Todo build() {
			return new Todo(this);
		}
	}
}
