package day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serialization_DeSerialization {
	
	
//	@Test
	void convertPOJO2JSON() throws JsonProcessingException
	{
		Student stupojo = new Student();
		stupojo.setName("David");
		stupojo.setLocation("Canada");
		stupojo.setPhone("9123456789");
		
		String coursearr[]= {"JavaScript","Cypress"};
		stupojo.setCourses(coursearr);
		
		//convert java object ---> json object (serialization)
		ObjectMapper objmap = new ObjectMapper();
		
		String jsondata=objmap.writerWithDefaultPrettyPrinter().writeValueAsString(stupojo);
		
		System.out.println(jsondata);
		
		
	}

	@Test
	void convertJSON2POJO() throws JsonProcessingException
	{
		String jsondata ="{\r\n"
				+ "  \"name\" : \"David\",\r\n"
				+ "  \"location\" : \"Canada\",\r\n"
				+ "  \"phone\" : \"9123456789\",\r\n"
				+ "  \"courses\" : [ \"JavaScript\", \"Cypress\" ]\r\n"
				+ "}";
		
		ObjectMapper objmap = new ObjectMapper();
		
		Student stupojo = objmap.readValue(jsondata, Student.class);
		
		System.out.println(stupojo.getName());
		System.out.println(stupojo.getLocation());
		System.out.println(stupojo.getPhone());
		System.out.println(stupojo.getCourses()[0]);
		System.out.println(stupojo.getCourses()[1]);
		
		
	}
}
