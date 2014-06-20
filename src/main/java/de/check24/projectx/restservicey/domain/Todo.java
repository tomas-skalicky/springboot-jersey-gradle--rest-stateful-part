package de.check24.projectx.restservicey.domain;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * @author Tomas Skalicky
 *         <p>
 *         Created on 20.05.2014
 *         </p>
 *         <p>
 *         Copyright (c) 2014, Check24 Vergleichsportal GmbH
 */
public class Todo implements Serializable {

	private static final long serialVersionUID = 8294345087513319038L;

	private Integer id;
	private String text;
	private OffsetDateTime dueDate;

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
		return "Todo [id=" + id + ", text=" + text + ", dueDate=" + dueDate + "]";
	}
}
