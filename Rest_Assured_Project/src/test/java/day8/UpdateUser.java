package day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {
	
	@Test
	void testUpdateUser(ITestContext context)
	{
//		int id = (int) context.getAttribute("user_id");
		
		int id = (int) context.getSuite().getAttribute("user_id");
		
//		String bearertoken = "66823a1b5478bef4a32d2edfhdf1244e6cce16f32688bfc132ac0339d29bea3ee06c8";

		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
	
		
		given()
//		.headers("Authorization","Bearer "+bearertoken)
		.contentType("application/json")
		.pathParam("userid",id)
		.body(data.toString())
		
		.when()
		.put("https://gorest.co.in/public/v2/users/{userid}")
		
		.then()
		.statusCode(200)
		.log().all();
	}

}
