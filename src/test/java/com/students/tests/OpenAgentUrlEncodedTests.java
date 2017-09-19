package com.students.tests;

import static com.jayway.restassured.RestAssured.given;
import java.util.Map;
import java.util.HashMap;
import org.json.*;
import static org.junit.Assert.assertEquals;
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
	public void updateVisitor(){
        String munchParam= "asdf23432";
		Response response = given()
				.header("Content-Type", "application/x-www-form-urlencoded")
				.formParam("munchkin",munchParam)
				.request()				
		        .put("/35039");
		assertParamWithResponse(response,munchParam,"munchkin");
	}
	
	
	public Map<String, String> turnResponseToHashmap(Response response){
		Map<String, String> responseBody= new HashMap<String,String>();
		String data=response.body().jsonPath().getString("data");
		data = data.substring(1,data.length()-1); // Remove bracket
		String[] resData = data.split(",");
		for(String value : resData)
		{
			String[] entry = value.split(":");
			responseBody.put(entry[0].trim(), entry[1].trim());
		}
		System.out.println(responseBody);
		return responseBody;	
	}
	
	public void assertParamWithResponse(Response response, String param, String resKey){
		Long statusCode = new Long(response.statusCode());
		if(statusCode.toString().equals("200")){	
			String resValue = turnResponseToHashmap(response).get(resKey);
			assertEquals(param, resValue);
		}
	}
	
}
