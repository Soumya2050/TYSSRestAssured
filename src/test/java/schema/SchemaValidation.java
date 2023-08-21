package schema;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

public class SchemaValidation {
	
	public static void main(String[] args) {
		
		File file = new File("./src/test/resources/JsonSchema.json");
		
		when().get("https://reqres.in/api/users?page=2")
		.then().assertThat()
		.body(JsonSchemaValidator.matchesJsonSchema(file))
		.log().all();
	}
	
	@Test
	public void scemaValidationRMG() {
		
		File file = new File("./src/test/resources/JsonSchemaRMG.json");
		
		when().get("http://rmgtestingserver:8084/projects")
		.then().assertThat()
		.body(JsonSchemaValidator.matchesJsonSchema(file)).statusCode(200)
		.log().all();
	}
	

}
