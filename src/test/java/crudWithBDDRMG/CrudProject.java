package crudWithBDDRMG;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.RMGyantra.Utility.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class CrudProject {

	JSONObject jObj = null;

	// JavaUtility jLib = null;
	@Test
	public void createProject() {
		JavaUtility jlib = new JavaUtility();

		baseURI = "http://rmgtestingserver";
		port = 8084;
		String expData = "Successfully Added";
		// System.out.println(randumNum);
		jObj = new JSONObject();
		jObj.put("createdBy", "soumya-");
		jObj.put("projectName", "TestYantraa" + jlib.getRandomNum());
		jObj.put("status", "created");
		jObj.put("teamSize", 5);

		// Step 1: pre-condition
		Response response = given().body(jObj).contentType(ContentType.JSON).when().post("/addProject");

		String actData = response.jsonPath().get("msg");

		Assert.assertEquals(actData, expData);

		System.out.println("Message is successfully verified");

		response.then().assertThat().statusCode(201).log().all();
	}

	@Test
	public void getAllProject() {
		baseURI = "http://rmgtestingserver";
		port = 8084;

		when().get("projects")

				.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
	}

	@Test
	public void getSingleProject() {

		baseURI = "http://rmgtestingserver";
		port = 8084;

		when().get("projects/TY_PROJ_12429")

				.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
	}

	@Test
	public void updateProject() {

		baseURI = "http://rmgtestingserver";
		port = 8084;
		JavaUtility jlib = new JavaUtility();
		int randumNum = jlib.getRandomNum();
		System.out.println(randumNum);
		jObj = new JSONObject();
		jObj.put("createdBy", "soumya");
		jObj.put("projectName", "TestYantra" + randumNum);
		jObj.put("status", "created");

		// Pre-condition

		given().body(jObj).contentType(ContentType.JSON)

				// Action

				.when().put("/projects/TY_PROJ_12343")

				// Validation

				.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
	}

	@Test
	public void deleteProject() {
		baseURI = "http://rmgtestingserver";
		port = 8084;

		when().delete("/projects/TY_Pro_112534422")

				// validation

				.then().assertThat().statusCode(204).contentType(ContentType.JSON).log().all();
	}

}
