package com.students.tests;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

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
		RestAssured.baseURI="http://petstore.swagger.io/v2";
		RestAssured.basePath="/pet";
	}
	
	@Test
	public void updatePet() throws JSONException{

		JSONObject jsonObj = new JSONObject()
				.put("id", 10)
				.put("category", new JSONObject()
						.put("name","gege")
						.put("id",8)                
						);
		System.out.println(jsonObj);
		Response response = given()
				.contentType("application/json; charset=UTF-8")
				.when()
				.body(jsonObj.toString())
		        .put();
		response.body().prettyPrint();
		
		Long statusCode = new Long(response.statusCode());
		Long id=null;

		if(statusCode.toString().equals("200")){		
			id = new Long(response.body().jsonPath().getInt("id")); //How can i access name in category?
			System.out.println(id);
		}
	}
	

}
