package day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;


public class DeleteUser {
	
	
	
	@Test
	void testDeleteUser(ITestContext context)
	{
//		int id = (int) context.getAttribute("user_id");
		
		int id = (int) context.getSuite().getAttribute("user_id");
		
//		String bearertoken = "66823a1b5478bef4a32ghjghd2e1244e6cce16f32688bfc132ac0339d29bea3ee06c8";

		given()
//		.headers("Authorization","Bearer "+bearertoken)
		.pathParam("userid",id)
		
		.when()
		.delete("https://gorest.co.in/public/v2/users/{userid}")
		
		.then()
		.statusCode(204)
		.log().all();
	}
	
	

}
