package DifferentWaysToPostRequestInReqres;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.RMGyantra.Utility.JavaUtility;

import Pojo.ReqresPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class CreateProjectInDifferentWays {

	JavaUtility jLib = null;
	JSONObject jObj = null;

	@Test(priority = 1)
	public void createProjectUsingPOJO() {
		jLib = new JavaUtility();
		int random = jLib.getRandomNum();
		baseURI = "https://reqres.in";
		ReqresPOJO po = new ReqresPOJO("soumya--" + random + "", "SoftwareTest");
		//pre-request
		given()
		.body(po)
		.contentType(ContentType.JSON)

				// action
				.when().post("/api/users")
				// validation
				.then()
				.assertThat()
				.time(Matchers.lessThan(3000l), TimeUnit.MILLISECONDS)
				.statusCode(201).contentType(ContentType.JSON)
				.log()
				.all();

	}

	@Test(priority = 2)
	public void createProjectUsingMap() {

		baseURI = "https://reqres.in";
		jLib = new JavaUtility();
		int random = jLib.getRandomNum();

		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map.put("name", "soumya<->" + random + "");
		map.put("job", "TestEngineer");
		String exp = "TestEngineer";
		Response res = given().body(map).contentType(ContentType.JSON).when().post("/api/users");
		
		String act = res.jsonPath().get("job");
		Assert.assertEquals(exp, act);	
		System.out.println("The job is verified successfully");
		
		res.then()
		.assertThat()
		.time(Matchers.lessThan(3000l), TimeUnit.MILLISECONDS)
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log()
		.all();
	}

	@Test(priority = 3)
	public void createUsingJSONFile() {

		baseURI = "https://reqres.in";
		jObj = new JSONObject();

		File file = new File("./src/test/resources/dataForReqres.json");
		// pre-condition
		given().body(file).contentType(ContentType.JSON)
				// Action
				.when().post("/api/users")
				// Validation
				.then().assertThat().contentType(ContentType.JSON).statusCode(201).log().all();
	}

	@Test
	public void createProjectUsingJsonObject() {
		baseURI = "https://reqres.in";
		jObj = new JSONObject();
		jLib = new JavaUtility();
		int random = jLib.getRandomNum();
		System.out.println(jLib.getRandomNum());
		jObj.put("name", "Soumya<->" + random + "");
		jObj.put("job", "TestEngineer");

		// pre-condition

		given()
		.body(jObj)
		.contentType(ContentType.JSON)

				// action

				.when()
				.post("/api/users")

				//
				.then()
				.assertThat()
				.time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS)
				.statusCode(201)
				.contentType(ContentType.JSON)
				.log()
				.all();
	}

}
