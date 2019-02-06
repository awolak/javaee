package com.example.servletdemo.domain;

public class Rodo {
	private boolean rodo=false;
	private boolean rodo2=false;
	private boolean newsletter=false;

	public boolean isRodo() {
		return rodo;
	}
	public void setRodo(boolean rodo) {
		this.rodo = rodo;
	}
	public boolean isRodo2() {
		return rodo2;
	}
	public void setRodo2(boolean rodo2) {
		this.rodo2 = rodo2;
	}
	public boolean isNewsletter() {
		return newsletter;
	}
	public void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
	}
	
	public Rodo(boolean rodo, boolean rodo2, boolean newsletter) {
		super();
		this.rodo = rodo;
		this.rodo2 = rodo2;
		this.newsletter = newsletter;
	}
	
	public Rodo() {
		super();
	}

}