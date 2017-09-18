package com.student.loggingexamples;

import static com.jayway.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.UUID;

import org.json.JSONException;
import org.junit.Test;

import com.jayway.restassured.response.Response;
import com.student.base.TestBase;
import com.student.modal.Student;

public class LoggingRequestValues extends TestBase{
	
	
	/*
	 * This test will print out all the request headers
	 */
	@Test
	public void test001(){
		given()
		.log()
		.headers()
		.when()
		.get("/1");		
	}
	
	/*
	 * This test will print out all the request parameters
	 */
	@Test
	public void test002(){
		given()
		.param("programme", "Computer Science")
		.log()
		.params()
		.when()
		.get("/1");		
	}
	
	
	@Test
	public void test003() throws JSONException{
		
		Response response = given()
				.contentType("application/json;charset=UTF-8")
				.log()
				.body()
				.when()
				.body(student())
		        .post();
		response.body().prettyPrint();
		response.then().statusCode(201);	
	}
	
	
	public Student student(){
		ArrayList<String> courses = new ArrayList<>();
		courses.add("Java");
		courses.add("RestAssured");
		
		Student student = new Student();
		student.setFirstName("Nancy");
		student.setLastName("Cai");
		student.setEmail(randomEmailGenerator());
		student.setProgramme("Computer Science");
		student.setCourses(courses);
		
		return student;
	}
	
	public String randomEmailGenerator(){
		String random = UUID.randomUUID().toString();
		String emailName = random.replace("-", ".");
		String email= emailName + "@test.com";

	    return email;
	}


}
