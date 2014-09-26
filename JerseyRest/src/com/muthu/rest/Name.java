package com.muthu.rest;

public class Name {
	String first;
	String last;
	CallName c;
	
	public CallName getC() {
		return c;
	}
	public void setC(CallName c) {
		this.c = c;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	
}

class CallName{
	private String displayName;
	private String desiredName;
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getDesiredName() {
		return desiredName;
	}
	public void setDesiredName(String desiredName) {
		this.desiredName = desiredName;
	}
	
}