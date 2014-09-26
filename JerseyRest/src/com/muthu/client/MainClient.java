package com.muthu.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

public class MainClient {

	Client client=ClientBuilder.newClient();
	WebTarget target=null;
	String resp=null;
	public static void main(String[] args) {
		//new MainClient().getMethod();
		//new MainClient().postMethod();
	/*	new MainClient().getWithParam();
		new MainClient().getWithQueryParam();
		new MainClient().postWithConsumes();*/
		new MainClient().producer();
	}
	
	void getMethod(){
		target=client.target("http://localhost:8080/JerseyRest/Math/noarg");
	
		//To get response from server
		Response resp=target.request().get();
		System.out.println(resp);
		
		// To get intended output
		String response=target.request().get(String.class);
		System.out.print(response);
		
		//
	}
	
	//Payload should be sent in post as MultivaluedMap class type.
	void postMethod(){
		target=client.target("http://localhost:8080/JerseyRest/Math/form");
		MultivaluedHashMap mvp=new MultivaluedHashMap();
		mvp.add("name", "muthu");
		mvp.add("age", "22");
		resp = target.request().post(Entity.form(mvp),String.class);
		System.out.print(resp);
	}
	
	
	//Define path variable in  path("{}") and use resolve template to substitude value in it.
	void getWithParam(){
		target=client.target("http://localhost:8080/JerseyRest/Math/addfrompath");
		resp=target.path("{a}").resolveTemplate("a","29").path("{b}").resolveTemplate("b", "55").request().get(String.class);
		System.out.print(resp);
	}

	//Use path("subresource") to define subresource and queryParam to add query params in it.
	void getWithQueryParam(){
		target=client.target("http://localhost:8080/JerseyRest/Math");
		resp=target.path("addargs").queryParam("a", "44").queryParam("b", "99").request().get(String.class);
		System.out.print(resp);
	}
	
	
	/*
	 * Matrixparam,cookieparam are same as above.
	 * Nothing specific to be done for bean param.As bean param is aggregation of all other types, wld be taken care by server
	 * side script. here define as respective params (i.e)query/path params....
	 */
	
	/*
	 * Use accept to filter the service, based on content type(Consumes)
	 * @serverside - it consumes, so from client, we sent Accept 
	 */
	public void postWithConsumes(){
		target=client.target("http://localhost:8080/JerseyRest/Math");
		resp=target.path("consume").request().accept("application/xml").post(Entity.text("Plain Text"),String.class);
		System.out.print(resp);
	}
	

	/*
	 * MediaType.[desired content type] should be given in request(), to match produces
	 *  
	 */
	void producer(){
		target=client.target("http://localhost:8080/JerseyRest/Math");
		resp=target.path("produce").request(MediaType.APPLICATION_JSON).get(String.class);
		System.out.print(resp);
	}
	
}
