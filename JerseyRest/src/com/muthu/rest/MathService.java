package com.muthu.rest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("Math")
public class MathService {

	int a=30;
	int b=20;
	
	//Standard Services; doesn't accepts any args; returns int.
	@GET
	@Path("noarg")
	public int add(){	
		return a+b;
	}
	
	//Use @QueryParam annotation, to get params for request
		@GET
		@Path("addargs")
		public int add(@QueryParam("a")int a, @QueryParam("b")int b){
			System.out.print(a+b);
			return a+b;
		}
		
	//Use @PathParam annotation, to get params for url
		@GET
		@Path("addfrompath/{a}/{b}")
		public float add(@PathParam("a")int a, @PathParam("b")float b){
			
			return a+b;
		}
		
	//Use @DefaultValue annotation, to set default value in case of param miss. 
		@GET
		@Path("default")
		public float add(@QueryParam("a")float a,@DefaultValue("20") @QueryParam("b")float b){
			
			return a+b;
		}
}
