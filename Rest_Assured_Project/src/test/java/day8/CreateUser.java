package day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateUser {
	
	@Test
	void testCreateUser(ITestContext context)
	{
//		String bearertoken = "66823a1b5478bef4a32d2e1244ertyfghcce16f32688bfc132ac0339d29bea3ee06c8";
		
		
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		int id=given()
//		.headers("Authorization","Bearer "+bearertoken)
		.contentType("application/json")
		.body(data.toString())
		
		
		.when()
		.post("https://gorest.co.in/public/v2/users")
		.jsonPath().getInt("id");
		
		System.out.println(id);
		
//		context.setAttribute("user_id", id);
		
		context.getSuite().setAttribute("user_id", id);
		
		
	}

}
