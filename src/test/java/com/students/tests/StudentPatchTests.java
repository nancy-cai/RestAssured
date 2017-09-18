package com.students.tests;
import static com.jayway.restassured.RestAssured.given;
import java.util.UUID;

import org.json.JSONException;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.student.base.TestBase;
import com.student.modal.Student;

public class StudentPatchTests extends TestBase {

	@Test
	public void createNewStudent() throws JSONException{
		
		Response response = given()
				.contentType("application/json;charset=UTF-8")
				.when()
				.body(student())
		        .patch("/6");
		response.body().prettyPrint();
		response.then().statusCode(200);	
	}
	
	public Student student(){
		Student student = new Student();
		student.setEmail(randomEmailGenerator());	
		return student;
	}
	
	public String randomEmailGenerator(){
		String random = UUID.randomUUID().toString();
		String emailName = random.replace("-", ".");
		String email= emailName + "@test.com";
		System.out.println(email);
	    return email;
	}
	

}
