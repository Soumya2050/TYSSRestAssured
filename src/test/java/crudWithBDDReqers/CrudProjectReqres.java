package crudWithBDDReqers;


import java.io.File;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.RMGyantra.Utility.JavaUtility;

import io.github.bonigarcia.wdm.online.HttpClient;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CrudProjectReqres {

	JSONObject jObj = null;
	JavaUtility jLib = null;

	@Test
	public void createProject() {

		baseURI = "https://reqres.in";
		jObj = new JSONObject();
		jLib = new JavaUtility();
		System.out.println(jLib.getRandomNum());
		jObj.put("name", "acsfsgd" + jLib.getRandomNum());
		jObj.put("job", "XYZ");

		// pre-condition

		given().body(jObj).contentType(ContentType.JSON)

				// action

				.when().post("/api/users")
				

				//
				.then()
				.assertThat()
				.time(Matchers.lessThanOrEqualTo(3000l), TimeUnit.MILLISECONDS)
				.statusCode(201).contentType(ContentType.JSON)
				.log()
				.all();
	}

	@Test
	public void getAllProject() {
		baseURI = "https://reqres.in";

		when().get("/api/users?page=2")

				.then().assertThat()
				.time(Matchers.lessThanOrEqualTo(3000l), TimeUnit.MILLISECONDS)
				.statusCode(200)
				.contentType(ContentType.JSON)
				.log()
				.all();
	}

	@Test
	public void getSingleProject() {

		baseURI = "https://reqres.in";

		when().get("/api/users/9")

				.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
	}

	@Test
	public void updateProject() {

		baseURI = "https://reqres.in";
		jObj = new JSONObject();
		jLib = new JavaUtility();

		System.out.println(jLib.getRandomNum());
		jObj.put("name", "Soumya" + jLib.getRandomNum());
		jObj.put("job", "XYZ");

		given().body(jObj).contentType(ContentType.JSON)

				.when().put("/api/users/12")

				.then()
				.assertThat()
				.time(Matchers.lessThanOrEqualTo(3000l), TimeUnit.MILLISECONDS)
				.contentType(ContentType.JSON)
				.statusCode(200)
				.log()
				.all();
	}

	@Test
	public void partialUpdate() {

		baseURI = "https://reqres.in";
		jObj = new JSONObject();
		jLib = new JavaUtility();

		jObj.put("name", "Soumya" + jLib.getRandomNum());

		given().body(jObj).contentType(ContentType.JSON)

				.when().patch("/api/users/9")

				.then()
				.assertThat()
				.time(Matchers.lessThanOrEqualTo(3000l), TimeUnit.MILLISECONDS)
				.contentType(ContentType.JSON)
				.statusCode(200)
				.log()
				.all();
	}

	@Test
	public void deleteProject() {

		baseURI = "https://reqres.in";

		when().delete("/api/users/2").then()
		.assertThat()
		.time(Matchers.lessThanOrEqualTo(3000l), TimeUnit.MILLISECONDS)
		.statusCode(204)
		.log()
		.all();

	}

	@Test

	public void createUsingJSONFile() {

		baseURI = "https://reqres.in";
		jObj = new JSONObject();

		File file = new File("C:/Users/srjen/OneDrive/Desktop/SDET-49.json");
		// pre-condition
		given().body(file).contentType(ContentType.JSON)
				// Action
				.when().post("/api/users")
				// Validation
				.then()
				.assertThat()
				.time(Matchers.lessThanOrEqualTo(3000l), TimeUnit.MILLISECONDS)
				.contentType(ContentType.JSON)
				.statusCode(201)
				.log()
				.all();

	}

	@Test
	public void createUsingMap() {

		baseURI = "https://reqres.in";
		jLib = new JavaUtility();
		LinkedHashMap<String, String> map = new LinkedHashMap<>();

		map.put("name", "Jyoti12321" + jLib.getRandomNum());
		map.put("job", "SoftwareTesting");
		// pre-condition
		given().body(map).contentType(ContentType.JSON)
				// Action
				.when().post("/api/users")
				// Validation
				.then()
				.assertThat()
				.time(Matchers.lessThanOrEqualTo(3000l), TimeUnit.MILLISECONDS)
				.contentType(ContentType.JSON)
				.statusCode(201)
				.statusLine(Matchers.stringContainsInOrder("Created"))
				.log()
				.all();
	}
	
	@Test
	public void method() {
		
	}
}
