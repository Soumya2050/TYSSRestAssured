package Parameter;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

import io.restassured.http.ContentType;

public class FormParaMeter {
	
	public static void main(String[] args) {
		
		baseURI = "https://reqres.in";
		
		given()
			.formParam("name", "soumya")
			.formParam("job", "sdet-49")
			.contentType(ContentType.JSON)
			
		.when()
			.post("/api/users")
			
		.then()
			.assertThat()
			.time(Matchers.lessThan(3000l), TimeUnit.MILLISECONDS)
			.statusCode(201)
			.log().all();
	}

}
