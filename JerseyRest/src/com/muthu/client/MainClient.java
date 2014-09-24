package com.muthu.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class MainClient {

	Client client=ClientBuilder.newClient();
	WebTarget target=null;
	
	public static void main(String[] args) {
		new MainClient().getMethod();
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
	
}
