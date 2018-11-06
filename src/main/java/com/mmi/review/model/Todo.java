package com.mmi.review.model;

import java.util.Date;

import javax.validation.constraints.Size;

public class Todo {

	private int id;
	private String user;
	
	@Size(min=10, message="Enter at least 10 characters" )
	private String desc;
	private Date targetdate;
	private boolean isDone;
	public Todo(int id, String user, String desc, Date targetdate, boolean isDone) {
		super();
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.targetdate = targetdate;
		this.isDone = isDone;
	}
	
	public Todo() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getTargetdate() {
		return targetdate;
	}
	public void setTargetdate(Date targetdate) {
		this.targetdate = targetdate;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", user=" + user + ", desc=" + desc + ", targetdate=" + targetdate + ", isDone="
				+ isDone + "]";
	}

}
