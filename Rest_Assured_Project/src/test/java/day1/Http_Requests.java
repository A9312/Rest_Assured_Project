package day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.lang.System.Logger;
import java.util.HashMap;

// given()	- content type, set cookies, add auth, add params, set headers info etc....

// when()	- get, post, put , delete

// then()	- validate status code, extract response, extract header cookies & response body...

public class Http_Requests {

	int id;

	@Test(priority = 1)
	void getUsers() {
		
		given()
		.header("x-api-key", "reqres-free-v1")

				.when()
				.get("https://reqres.in/api/users?page=2")

				.then()
				.statusCode(200)
				.body("page", equalTo(2))
				.log().all();
	}

	@Test(priority = 2)
	void createUser() {
		HashMap data1 = new HashMap();
		data1.put("name", "morpheus");
		data1.put("job", "leader");

		id = given()
				.header("x-api-key", "reqres-free-v1")
				.contentType("application/json")
				.body(data1)

				.when()
				.post("https://reqres.in/api/users")
				.jsonPath().getInt("id");

//		.then()
//		.statusCode(201)
//		.log().all();
	}

	@Test(priority = 3, dependsOnMethods = { "createUser" })
	void updateUser() {
		HashMap data2 = new HashMap();
		data2.put("name", "morpheus");
		data2.put("job", "zion resident");

		given()
		.header("x-api-key", "reqres-free-v1")
		.contentType("application/json")
		.body(data2)

				.when()
				.put("https://reqres.in/api/users/" + id)

				.then()
				.statusCode(200).log().all();
	}

	@Test(priority = 4)
	void deleteUser() {
		given()
		.header("x-api-key", "reqres-free-v1")

				.when()
				.delete("https://reqres.in/api/users/" + id)

				.then().statusCode(204).log().all();
	}

}
