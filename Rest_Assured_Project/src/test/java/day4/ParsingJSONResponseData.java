package day4;

import static org.testng.Assert.assertEquals;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ParsingJSONResponseData {

	
	@Test(priority = 1)
	void testJSONResponse()
	{
		//Approach1
//		given()
//		.contentType("ContentType.json")
//		
//		.when()
//		.get("http://localhost:3000/store")
//		
//		.then()
//		.statusCode(200)
//		.header("Content-Type", "application/json")
//		.body("book[3].title",equalTo("Sapiens: A Brief History of Humankind"));
		
		
		//Approach2
		
		Response res=given()
		.contentType("ContentType.JSON")
		
		.when()
		.get("http://localhost:3000/store");
		
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.getHeader("Content-Type"), "application/json");
		
		String book_name = res.jsonPath().get("book[3].title").toString();
		Assert.assertEquals(book_name, "Sapiens: A Brief History of Humankind");
		
		
	}
	
	
	@Test(priority = 2)
	void TestJSONResponseBodyData()
	{
		Response res=given()
				.contentType("ContentType.JSON")
				
				.when()
				.get("http://localhost:3000/store");
				
//				Assert.assertEquals(res.getStatusCode(),200);
//				Assert.assertEquals(res.getHeader("Content-Type"), "application/json");
//				
//				String book_name = res.jsonPath().get("book[3].title").toString();
//				Assert.assertEquals(book_name, "Sapiens: A Brief History of Humankind");
		
		JSONObject jo = new JSONObject(res.asString());
		
		boolean status=false;
		
		for(int i=0; i<jo.getJSONArray("book").length();i++)
		{
			String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
//			System.out.println(bookTitle);
			
			if(bookTitle.equals("Sapiens: A Brief History of Humankind"))
			{
				status=true;
				break;
			}
		}
		
		Assert.assertEquals(status, true);
		
		double totalprice=0;
		
		for(int i=0; i<jo.getJSONArray("book").length();i++)
		{
			String price=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
			
			totalprice=totalprice+Double.parseDouble(price);
		}
		
		System.out.println("the total price of all the books are:"+totalprice);
		Assert.assertEquals(totalprice, 1476.5);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
