package com.muthu.rest;

import javax.servlet.http.Cookie;
import javax.ws.rs.BeanParam;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("Math")
public class MathService {

	int a=30;
	int b=20;
	
	//Standard Services; doesn't accepts any args; returns int.
	//http://localhost:8080/JerseyRest/Math/noarg
	@GET
	@Path("noarg")
	public int add(){	
		return a+b;
	}
	
	//Use @QueryParam annotation, to get params for request
	//http://localhost:8080/JerseyRest/Math/addargs?a=44&b=44
		@GET
		@Path("addargs")
		public int add(@QueryParam("a")int a, @QueryParam("b")int b){
			System.out.print(a+b);
			return a+b;
		}
		
	//Use @PathParam annotation, to get params for url
	//http://localhost:8080/JerseyRest/Math/addfrompath/22/33
		@GET
		@Path("addfrompath/{a}/{b}")
		public float add(@PathParam("a")int a, @PathParam("b")float b){
			
			return a+b;
		}
		
	//Use @DefaultValue annotation, to set default value in case of param miss. 
	//http://localhost:8080/JerseyRest/Math/default?a=22
		@GET
		@Path("default")
		public float add(@QueryParam("a")float a,@DefaultValue("20") @QueryParam("b")float b){
			
			return a+b;
		}
	//Matrix param is like query param, but delimited by semi colon(;)
	//http://localhost:8080/JerseyRest/Math/matrix;a=33;b=44
		@GET
		@Path("matrix")
		public int sub(@MatrixParam("a") int a,@MatrixParam("b")int b){
			return a+b;
		}
		
	 //Use @HeadParam to get header info from request
	//http://localhost:8080/JerseyRest/Math/header
		@GET
		@Path("header")
		public String geUserAgentFromHeader(@HeaderParam("User-Agent")String userAgent ){
			return userAgent;
		}
	
	//Use @FormParam to get the content from jspform.
	//http://localhost:8080/JerseyRest/Math/form ; use post and add payload form.	
		@Path("form")
		@POST
		public String getFormParam(@FormParam("name")String name){
			return name;
		}
	
	//Use @BeanParam to aggregate all other type of param annotations.
	//below ex: used queryparam and path param.
	//http://localhost:8080/JerseyRest/Math/userbean/muthu?pass=passda
		@GET
		@Path("userbean/{user}")
		public String getBean(@BeanParam UserBean ub){
			return ub.toString();
		}
}

