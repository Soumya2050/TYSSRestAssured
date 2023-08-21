package crudWithoutBDDRMGYANTRA;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.RMGyantra.Utility.JavaUtility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RmgYantra {

	JSONObject jObj = null;
	JavaUtility jLib = null;

	@Test(priority = 1)
	public void createProject() {
		jLib = new JavaUtility();
		int randumNum = jLib.getRandomNum();
		System.out.println(randumNum);
		jObj = new JSONObject();
		jObj.put("createdBy", "soumya-");
		jObj.put("projectName", "TestYantra" + randumNum);
		jObj.put("status", "created");
		jObj.put("teamSize", "5");

		RequestSpecification request = RestAssured.given();
		request.body(jObj);
		request.contentType(ContentType.JSON);
		Response response = request.post("http://rmgtestingserver:8084/addProject");
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 201);
		
		
		
		System.err.println(response.getTime());
		System.out.println(response.getContentType());
		System.err.println(response.getStatusLine());
		System.out.println(response.asPrettyString());

	}

	@Test(priority = 2)
	public void getAllProject() {

		RequestSpecification request = RestAssured.given();
		request.contentType(ContentType.JSON);
		Response response = request.get("http://rmgtestingserver:8084/projects");
		String expValue = "TY_PROJ_12318";

		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);

		String actVal = response.jsonPath().get("[0].projectId");
		Assert.assertEquals(actVal, expValue);
		System.out.println("Value is verified");

		System.err.println(response.getTime());
		System.out.println(response.getContentType());
		System.err.println(response.getStatusLine());
//		System.err.println(response.asPrettyString());
	}

	@Test(priority = 3)
	public void getSingleProject() {
		RequestSpecification request = RestAssured.given();
		request.contentType(ContentType.JSON);
		Response response = request.get("http://rmgtestingserver:8084/projects/TY_PROJ_12319");
		String expData = "TY_PROJ_12319";
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);

		String actData = response.jsonPath().get("projectId");
		Assert.assertEquals(actData, expData);
		System.out.println("Data is verified successfully");

		System.err.println(response.getTime());
		System.out.println(response.getContentType());
		System.err.println(response.getStatusLine());
//		System.err.println(response.asPrettyString());
	}

	@Test(priority = 4)
	public void updateProject() {
		jLib = new JavaUtility();
		int randomNum = jLib.getRandomNum();
		System.err.println(randomNum);
		jObj = new JSONObject();

		jObj.put("createdBy", "soumya");
		jObj.put("projectName", "TYss-" + randomNum);
		jObj.put("status", "created");
		jObj.put("teamSize", "5");

		RequestSpecification request = RestAssured.given();
		request.body(jObj);
		request.contentType(ContentType.JSON);

		Response response = request.put("http://rmgtestingserver:8084/projects/TY_PROJ_24370");// TY_ZooView_69

		int statusCode = response.getStatusCode();

		Assert.assertEquals(statusCode, 200);
		System.out.println(response.getContentType());
		System.out.println(response.getStatusLine() + " " + response.getTime());
		System.out.println(response.asPrettyString());

	}

	@Test(priority = 5)
	public void deleteProject() {
		RequestSpecification request = RestAssured.given();
		Response response = request.delete("http://rmgtestingserver:8084/projects/TY_PROJ_9879");

		int statusCode = response.getStatusCode();

		Assert.assertEquals(statusCode, 204);
		System.out.println(response.getStatusLine() + " " + response.getTime());
	}

}
