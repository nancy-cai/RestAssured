package com.students.tests;

import static com.jayway.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.student.base.TestBase;
import com.student.modal.Student;


public class studentDeleteTests extends TestBase {
	
	@Test
	public void deleteStudent(){
		Response response = given()
				.when()
				.delete("/44");
		response.then().statusCode(204);
		response.body().prettyPrint();
	}
}
