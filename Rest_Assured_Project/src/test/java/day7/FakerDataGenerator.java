package day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class FakerDataGenerator {
	
	@Test
	void testGenerateDummyData()
	{
		Faker faker = new Faker();
		
		System.out.println(faker.name().fullName());
		System.out.println(faker.name().firstName());
		System.out.println(faker.name().lastName());
		System.out.println(faker.phoneNumber().cellPhone());
		System.out.println(faker.name().username());
		System.out.println(faker.internet().password());
		System.out.println(faker.internet().safeEmailAddress());
		
	}

}
