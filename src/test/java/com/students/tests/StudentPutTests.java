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

public class StudentPutTests {
	
	
	@BeforeClass
	public static void init(){
		RestAssured.baseURI="http://apidev.openagent.com.au/v1";
		RestAssured.basePath="/VisitorREST/visitor";
	}
	
	@Test
	public void updateStudent() throws JSONException{
//		Student student = new Student();
//		student.setFirstName("Hhaa");
//		student.setEmail("test@test.com");
//		student.setProgramme("Jave");
		JSONObject jsonObj = new JSONObject()
				.put("data", new JSONObject()
						.put("gaclientid","sdf86.dsf76sdf")
		                .put("userid",171976)
						);
		System.out.println(jsonObj);
		Response response = given()
				.contentType("application/json")
				.when()
				.body(jsonObj.toString())
		        .put("/35038");
		response.body().prettyPrint();
		response.then().statusCode(200);
	}
	

}
