package InterViewQuestion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class WriteResponseInJson {
	
	
	@Test
	public void method1() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		Response response = when().get("projects");
		String responseBody = response.getBody().asPrettyString();
		
		

		try {
			FileWriter file = new FileWriter(new File("./xyz.json"));
			file.write(responseBody);
			file.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void method2() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		Response response = when().get("projects");
		
		String responseAsString = response.getBody().asString();
		
		byte[] responseByte = responseAsString.getBytes();
		
		File file = new File("./abcd.json");
		
		try {
			Files.write(responseByte, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Test
	public void method3() throws Throwable {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		Response response = when().get("projects");
		
		InputStream responseAsString = response.asInputStream();
		
		byte[] responseByte =new byte[responseAsString.available()];
		
		responseAsString.read(responseByte);
		
		File file = new File("./abcd1.json");
		
		try {
			Files.write(responseByte, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Test
	public void method4() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		Response response = when().get("projects");
		
		byte[] bytearray = response.asByteArray();
		
		File file = new File("./abcd1.1.json");
		
		try {
			Files.write(bytearray, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
