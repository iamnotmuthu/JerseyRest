package com.muthu.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("Math")
public class MathService {

	int a=10;
	int b=20;
	
	//Standard Services doesn't accepts any args; returns int
	@GET
	@Path("noarg")
	public int add(){
		
		return a+b;
	}
	
}
