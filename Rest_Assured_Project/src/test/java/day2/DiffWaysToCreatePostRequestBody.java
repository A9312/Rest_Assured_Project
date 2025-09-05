package day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.System.Logger;
import java.util.HashMap;


public class DiffWaysToCreatePostRequestBody {
	
	String id;
	
//	@Test(priority = 1)
	void testdatausingHashMap()
	{
		HashMap data = new HashMap();
		data.put("name", "David");
		data.put("location", "Canada");
		data.put("phone", "9123456789");
		
		String coursearr[]= {"JavaScript","Cypress"};
		data.put("courses", coursearr);
		
		id=given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:3000/students")
		.jsonPath().getString("id");
		
//		.then()
//		.statusCode(201)
//		.body("name",equalTo("David"))
//		.body("location",equalTo("Canada"))
//		.body("phone",equalTo("9123456789"))
//		.body("courses[0]",equalTo("JavaScript"))
//		.body("courses[1]",equalTo("Cypress"))
//		.header("Content-Type", "application/json")
//		.log().all();
	}
	
	
//	@Test(priority = 1)
	void testdatausingJSONLibrary()
	{
		JSONObject data = new JSONObject();
		data.put("name", "David");
		data.put("location", "Canada");
		data.put("phone", "9123456789");
		
		String coursearr[]= {"JavaScript","Cypress"};
		data.put("courses", coursearr);
		
		id=given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/students")
		.jsonPath().getString("id");
		
//		.then()
//		.statusCode(201)
//		.body("name",equalTo("David"))
//		.body("location",equalTo("Canada"))
//		.body("phone",equalTo("9123456789"))
//		.body("courses[0]",equalTo("JavaScript"))
//		.body("courses[1]",equalTo("Cypress"))
//		.header("Content-Type", "application/json")
//		.log().all();
	}
	
	
//	@Test(priority = 1)
	void testdatausingPOJOClass()
	{
		POJO_RequestBody data = new POJO_RequestBody();
		data.setName("David");
		data.setLocation("Canada");
		data.setPhone("9123456789");
		
		String coursearr[]= {"JavaScript","Cypress"};
		data.setCourses(coursearr);
		
		id=given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:3000/students")
		.jsonPath().getString("id");
		
//		.then()
//		.statusCode(201)
//		.body("name",equalTo("David"))
//		.body("location",equalTo("Canada"))
//		.body("phone",equalTo("9123456789"))
//		.body("courses[0]",equalTo("JavaScript"))
//		.body("courses[1]",equalTo("Cypress"))
//		.header("Content-Type", "application/json")
//		.log().all();
	}
	

	@Test(priority = 1)
	void testdatausingExternalJSONFile() throws FileNotFoundException
	{
		File f = new File("E:\\java_workspace\\RestAssuredProject\\BODY.json");
		
		FileReader fr = new FileReader(f);
		
		JSONTokener jt = new JSONTokener(fr);
		
		JSONObject data = new JSONObject(jt);
		
		id=given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/students")
		.jsonPath().getString("id");
		
//		.then()
//		.statusCode(201)
//		.body("name",equalTo("David"))
//		.body("location",equalTo("Canada"))
//		.body("phone",equalTo("9123456789"))
//		.body("courses[0]",equalTo("JavaScript"))
//		.body("courses[1]",equalTo("Cypress"))
//		.header("Content-Type", "application/json")
//		.log().all();
	}

	
	@Test(priority = 2)
	void testDelete()
	{
		given()
		
		.when()
		.delete("http://localhost:3000/students/"+id)
		
		.then()
		.statusCode(200);
	}

}
