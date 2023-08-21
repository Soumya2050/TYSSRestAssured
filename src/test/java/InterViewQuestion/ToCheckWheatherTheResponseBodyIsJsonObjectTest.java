package InterViewQuestion;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ToCheckWheatherTheResponseBodyIsJsonObjectTest {
	
	@Test
	public void method1() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		Response response =given().pathParam("pid", "TYP_PROJ_850").when().get("/projects/{pid}");
		
		String responseBody = response.getBody().asString();
					
			try {
				
				ObjectMapper obj = new ObjectMapper();
				JsonNode jsonNode = obj.readTree(responseBody);
				
//				boolean a = jsonNode.isArray();
//				boolean b = jsonNode.isInt();
//				boolean c = jsonNode.isNull();
//				boolean d = jsonNode.isObject();
//				boolean e = jsonNode.isDouble();
//				boolean f = jsonNode.isBoolean();
				
				if(jsonNode.isObject())
				{
					System.out.println("Response is a Json Object");
				}else if(jsonNode.isArray())
				{
					System.out.println("The response is array");
				}else if(jsonNode.isInt())
				{
					System.out.println("The response is Int");
				}else if(jsonNode.isNull())
				{
					System.out.println("The response is null");
				}else if(jsonNode.isDouble())
				{
					System.out.println("The response is Double");
				}else if(jsonNode.isBoolean())
				{
					System.out.println("The response is boolean");
				}else {
					System.out.println("The response is plain string");
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}		
	}
	
	@Test
	public void method2() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		Response response =given().pathParam("pid","TYP_PROJ_850").when().get("/projects/{pid}");
		
		response.then().body("",Matchers.instanceOf(Map.class)).statusCode(200).contentType(ContentType.JSON)
		.log().all();
	}

}
