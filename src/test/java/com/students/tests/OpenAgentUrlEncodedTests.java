package com.students.tests;

import static com.jayway.restassured.RestAssured.given;
import org.json.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.json.JSONException;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

public class OpenAgentUrlEncodedTests {
	
	@BeforeClass
	public static void init(){
		RestAssured.baseURI="http://apidev.openagent.com.au/v1/VisitorREST";
		RestAssured.basePath="/visitor";
	}
	
	@Test
	public void createVisitor() throws JSONException{

		Response response = given()
				.header("Content-Type", "application/x-www-form-urlencoded")
				.formParam("munchkin","sadfxesce")
				.request()				
		        .post();
		response.body().prettyPrint();
		response.then().statusCode(200);
	}
	
	@Test
	public void updateVisitor() throws JSONException{

		Response response = given()
				.header("Content-Type", "application/x-www-form-urlencoded")
				.formParam("munchkin","sa8dfxe")
				.request()				
		        .put("/35039");
		
		// Find how to convert string to hashmap
//		String datas[] =response.body().jsonPath().getString("data").split(",");
//		String munchkin = datas[2];
//		System.out.println(munchkin);
		
		Long statusCode = new Long(response.statusCode());

		if(statusCode.toString().equals("200")){		
	
		}
	}

}
