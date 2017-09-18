package com.students.tests;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.student.base.TestBase;
import com.student.modal.Student;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.UUID;

import static com.jayway.restassured.RestAssured.*;

public class StudentPostTests extends TestBase {
	
	@Test
	public void createNewStudent() throws JSONException{
		
		Response response = given()
				.contentType("application/json;charset=UTF-8")
				.when()
				.body(student())
		        .post();
		response.body().prettyPrint();
		response.then().statusCode(201);	
	}
	
	@Test
	public void createNewStudentWithFile(){
		String url="src/test/resources/PostJson/createNewStudent.json";
		try {
			String studentJson = new String(Files.readAllBytes(Paths.get(url)));
			System.out.println(studentJson);
			Response response = given()
					.contentType(ContentType.JSON)
					.when()
					.body(studentJson)
					.post();
			response.body().prettyPeek();
			response.then().statusCode(201);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		System.out.println(email);
	    return email;
	}

}
