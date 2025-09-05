package day5;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class FileUploadAndDownload {
	
	@Test(priority = 1)
	void singleFileUpload()
	{
		File myfile = new File("C:\\Users\\Hp\\Desktop\\demo\\file3.txt");
		
		given()
		.multiPart("file",myfile)
		.contentType("multipart/form-data")
		
		.when()
		.post("http://localhost:8080/uploadFile")
		
		.then()
		.statusCode(200)
		.body("fileName",equalTo("file3.txt"))
		.log().all();
	}
	
	
//	@Test
	void uploadMultipleFiles()
	{
		File myfile1 = new File("C:\\Users\\Hp\\Desktop\\demo\\file1.txt");
		File myfile2 = new File("C:\\Users\\Hp\\Desktop\\demo\\file2.txt");
		File myfile3 = new File("C:\\Users\\Hp\\Desktop\\demo\\file3.txt");
		
		
		given()
		.multiPart("files",myfile1)
		.multiPart("files",myfile2)
		.multiPart("files",myfile3)
		.contentType("multipart/form-data")
		
		.when()
		.post("http://localhost:8080/uploadMultipleFiles")
		
		.then()
		.statusCode(200)
		.body("[0].fileName", equalTo("file1.txt"))
		.body("[1].fileName", equalTo("file2.txt"))
		.body("[2].fileName", equalTo("file3.txt"))
		.log().all();
		
	}
	
	
	
	@Test(priority = 2)
	void testDownloadFile()
	{
		given()
		
		.when()
		.get("http://localhost:8080/downloadFile/file3.txt")
		
		.then()
		.statusCode(200)
		.log().body();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
