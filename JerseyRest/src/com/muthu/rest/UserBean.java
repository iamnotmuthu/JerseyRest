package com.muthu.rest;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

class UserBean{
	@PathParam("user")
	private String userName=null;
	
	@QueryParam("pass")
	private String pass=null;
	
	@Override
	public String toString() {
		return "UserBean [userName=" + userName + ", pass=" + pass + "]";
	}	
}