package com.muthu.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

public class MainClient {

	Client client=ClientBuilder.newClient();
	WebTarget target=null;
	
	public static void main(String[] args) {
		//new MainClient().getMethod();
		new MainClient().postMethod();
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
		String resp = target.request().post(Entity.form(mvp),String.class);
		System.out.print(resp);
	}
}
