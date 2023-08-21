package DifferentWaysToPostRequest;

import static io.restassured.RestAssured.*;

import java.io.File;

import io.restassured.http.ContentType;

public class CreateProjectUsingFile {

	public static void main(String[] args) {

		baseURI = "http://rmgtestingserver";
		port = 8084;

		File file = new File("./src/test/resources/createProject.json");
		// pre-condition

		given().body(file).contentType(ContentType.JSON)

				// action
				.when().post("/addProject")

				// validation
				.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}

}
