package day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {

	
	@Test
	void testGetUser(ITestContext context)
	{
//		int id = (int) context.getAttribute("user_id"); 	//this id will come from createuser class
		
		int id = (int) context.getSuite().getAttribute("user_id"); 
		
//		String bearertoken = "66823a1b5478bef4a32drftujhfg2e1244e6cce16f32688bfc132ac0339d29bea3ee06c8";
		
		given()
//		.headers("Authorization","Bearer "+bearertoken)
		.pathParam("userid",id)
		
		.when()
		.get("https://gorest.co.in/public/v2/users/{userid}")
		
		
		.then()
		.statusCode(200)
		.log().all();
	}

}
