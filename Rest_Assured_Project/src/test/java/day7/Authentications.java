package day7;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Authentications {

	
//	@Test(priority = 1)
	void testBasicauthentication()
	{
		given()
		.auth().basic("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	
	
	
	
//	@Test(priority = 2)
	void testDigestauthentication()
	{
		given()
		.auth().digest("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	
	
//	@Test(priority = 3)
	void testPreemptiveauthentication()
	{
		given()
		.auth().preemptive().basic("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	
//	@Test(priority = 4)
	void testBearerTokenAuthentication()
	{
//		String bearertoken="ghp_baoRlpCbdfhfgh7PbcCKkkqAXXU6pYfuwkC24IXgle";
		
		given()
//		.headers("Authorization","Bearer"+bearertoken)
		
		
		.when()
		.get("https://api.github.com/users//repos")
		
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	
//	@Test(priority = 5)
	void testOAuth1Authentication()
	{
		given()
		.auth().oauth("consumerKey", "consumerSecret", "accessToken", "tokenSecret")
		
		
		.when()
		.get("url")
		
		
		.then()
		.log().all();
	}
	
	
//	@Test
	void testOAuth2Authentication()
	{
		given()
//		.auth().oauth2("ghp_baoRlpCb7dfgdfgdfdgbcCKkkqAXXU6pYfuwkC24IXgle")
		
		.when()
		.get("https://api.github.com/users//repos")
		
		
		.then()
		.statusCode(200)
		.log().body();
		
	}
	
	
	@Test
	void testAPIkeyauthentication()
	{
		given()
		.header("x-api-key", "reqres-free-v1")
		
		.when()
		.get("https://reqres.in/api/users/2")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
