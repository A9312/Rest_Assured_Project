package day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesDemo {

	
//	@Test(priority = 1)
	void testCookies()
	{
		given()
		
		.when()
		.get("https://www.google.com/")
		
		.then()
		.cookie("AEC","AVh_V2hWIxY8w1IhPyF9Mn0K3tYo7Wft780zV-Myt4UHTdQrJTD8UEYA_co")
		.log().all();
	}
	
	@Test(priority = 2)
	void getCookiesInfo()
	{
		Response res=given()
		
		.when()
		.get("https://www.google.com/");
		
//		String cookie_value = res.getCookie("AEC");
//		System.out.println("value of cookie is=====>"+cookie_value);
		
		Map<String, String> cookie_values=res.getCookies();
		
//		System.out.println(cookie_values.keySet());
		
		for(String k:res.getCookies().keySet())
		{
			String cookie_value = res.getCookie(k);
			System.out.println(k+"     "+cookie_value);
		}
		
	}
	
	
	
}
