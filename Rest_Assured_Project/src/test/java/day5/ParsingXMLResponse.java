package day5;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class ParsingXMLResponse {
	
	
//	@Test
	void testXMLresponse()
	{
		//approach1
//		given()
//		
//		.when()
//		.get("http://localhost:3000/travelers")
//		
//		.then()
//		.statusCode(200)
//		.header("Content-Type","application/xml")
//		.body("TravelerinformationResponse.page",equalTo("1"))
//		.body("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo("Vijay Bharath Reddy"));
		
		
		//approach2
		Response res=given()
		
		.when()
		.get("http://localhost:3000/travelers");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/xml");
		
		String pageno = res.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(pageno, "1");
		
		String traveler_name=res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		Assert.assertEquals(traveler_name, "Vijay Bharath Reddy");
		
	}
	
	@Test
	void testXMLresponseBody()
	{
		Response res=given()
		
		.when()
		.get("http://localhost:3000/travelers");
		
		XmlPath xmlobj = new XmlPath(res.asString());
		
		List<String> traverllers=xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
		
		Assert.assertEquals(traverllers.size(), 20);
		
		List<String> traveller_names=xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		
//		for(String traveller_name:traveller_names)
//		{
//			System.out.println(traveller_name);
//		}
		
		boolean status=false;
		
		for(String traveller_name:traveller_names)
		{
			if(traveller_name.equals("Vijay Bharath Reddy"))
			{
				status=true;
				break;
			}
		}
		
		Assert.assertEquals(status, true);
	}

}
