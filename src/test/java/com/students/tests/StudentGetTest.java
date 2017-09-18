package com.students.tests;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.student.base.TestBase;

import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;

public class StudentGetTest extends TestBase {

	@Test
	public void getAllStudentsInfo(){
		/* given()
		 * set cookies, add auth, adding params, setting header info
		 * .when()
		 * GET,POST,PUT,DELETE...
		 * .then()
		 * Validate status ode, extract response, extract headers, cookies, Response body
		 */	
		setResponse("/list").then().statusCode(200);			
		
	}
	
	@Test
	public void getStudentInfo(){
		Response response = setResponse("/4");
		response.then().statusCode(200);
		printResponseBody(response);
	}
	
	@Test
	public void getStudentWithParam(){
		Response response = given()
				.param("programme", "Financial Analysis")
				.param("limit", 2)
				.when()
				.get("/list");
		response.body().prettyPeek();
		response.then().statusCode(200);
		
				
	}
	
	public Response setResponse(String getUrl){
		Response response= given()
				.when()
				.get(getUrl);
		return response;
	}
	
	public void printResponseBody(Response response){
		System.out.println(response.body());	
		
	}

}
