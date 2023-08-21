package ResponseValidation;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class StaticResponseValidation {
	
	@Test
	public void verifyAllProject() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		String expData = "TY_PROJ_12318";
		Response response = when().get("/projects");
		
		String actData = response.jsonPath().get("[0].projectId");
		
		Assert.assertEquals(actData, expData);
		System.out.println("The project is verified");
		
		response.then().statusCode(200)/*log().all()*/;
	}
	
	@Test
	public void singleProject() {
		
		
		baseURI = "http://rmgtestingserver";
		port = 8084;

		String expData = "TY_PROJ_12318";
		Response response = when().get("/projects/TY_PROJ_12318");

		String actData = response.jsonPath().get("projectId");

		Assert.assertEquals(actData, expData);
		System.out.println("The project is verified");

		response.then().statusCode(200);

	}

}
