package com.muthu.client;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacsonAPI {
	ObjectMapper om=new ObjectMapper();
	public static void main(String[] args) throws Exception{
		JacsonAPI jp=new JacsonAPI();
		
		/*
		 * Pass Java obj and get Json
		 * 
		 * */
		
		 Country c=new Country();
		State st=new State();
		st.setName("TamilNadu");
		c.setName("India");
		c.setSt(st);
		c.setSt(st);
		jp.generateJsonfromOBJ(c);
		
		/* Pass json String and get java obj
		 * 
		 */
		String json="{\"name\":\"India\",\"st\":{\"name\":\"TamilNadu\"}}";
		jp.generateObjFromJsonString(json);
		 
		
	}
	
	//Similarly, u can read from file, write file and so on....
	
	void generateObjFromJsonString(String json) throws JsonParseException, JsonMappingException, IOException{
		System.out.println(om.readValue(json, Country.class));
	}
	void generateJsonfromOBJ(Country c) throws JsonProcessingException{
		System.out.println(om.writeValueAsString(c));
	}
}


class Country{
	String name;
	State st;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public State getSt() {
		return st;
	}
	public void setSt(State st) {
		this.st = st;
	}
	
}

class State{
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}