package com.students.tests;
import static com.jayway.restassured.RestAssured.given;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.student.base.TestBase;
import com.student.modal.Student;

public class StudentPutTests extends TestBase {
	
	@Test
	public void updateStudent() throws JSONException{
//		Student student = new Student();
//		student.setFirstName("Hhaa");
//		student.setEmail("test@test.com");
//		student.setProgramme("Jave");
		JSONObject jsonObj = new JSONObject()
                .put("firstName","Glebe")
                .put("programme", "IT")
                .put("email","tt@ww.ww");
		
		Response response = given()
				.contentType("application/json")
				.when()
				.body(jsonObj.toString())
		        .put("/2");
		response.body().prettyPrint();
		response.then().statusCode(200);
	}
	

}
