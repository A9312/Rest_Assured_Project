package day3;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HeadersDemo {

//	@Test(priority = 1)
	void testHeaders()
	{
		given()
		
		.when()
		.get("https://www.google.com/")
		
		.then()
		.header("Content-Type", "text/html; charset=ISO-8859-1")
		.header("Content-Encoding", "gzip")
		.header("Server", "gws");
	}
	
	@Test(priority = 1)
	void GetHeadersInfo()
	{
		Response res = given()
		
		.when()
		.get("https://www.google.com/");
		
//		String header_value=res.getHeader("Content-Type");
//		System.out.println("value of content-type header is======>"+header_value);

		Headers headers_values=res.getHeaders();
		
		for(Header x:headers_values)
		{
			System.out.println(x.getName()+"   "+x.getValue());
		}
		
	}
	
}
