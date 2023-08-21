package crudWithoutBDDReqres;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	
	@Test(priority = 1)
	public void createProject() {
		
		JSONObject jObj = new JSONObject();
		jObj.put("name","Soumya");
		jObj.put("job", "XYZ");
		
		RequestSpecification request = RestAssured.given();
		request.body(jObj);		
		request.contentType(ContentType.JSON);		
		Response response = request.post("https://reqres.in/api/users");
		
		int statuscode=response.getStatusCode();
		Assert.assertEquals(201, statuscode);
		
		System.out.println(response.getContentType());
		System.out.println(response.getTime());
		System.out.println(response.prettyPeek());
	}
	
	@Test(priority = 2)
	public void getProect() {
		RequestSpecification request = RestAssured.given();
		request.contentType(ContentType.JSON);		
		Response response = request.get("https://reqres.in/api/users?page=2");
		
		int statuscode=response.getStatusCode();
		Assert.assertEquals(200, statuscode,"The status code is passed");
		
		System.out.println(response.getContentType());
		System.err.println(response.getTime());
		System.out.println(response.prettyPeek());
	}
	
	@Test(priority = 3)
	public void updateProject() {
		JSONObject jObj = new JSONObject();
		jObj.put("name","Soumya12");
		jObj.put("job", "SDETengineer");
		
		RequestSpecification request = RestAssured.given();
		request.body(jObj);		
		request.contentType(ContentType.JSON);		
		Response response = request.put("https://reqres.in/api/users/2");
		
		int statuscode=response.getStatusCode();
		Assert.assertEquals(200, statuscode);
		
		System.out.println(response.getContentType());
		System.out.println(response.getTime());
		System.err.println(response.asString());
	}
	
	@Test(priority = 4)
	public void partialUpdateProject() {
		JSONObject jObj = new JSONObject();
		jObj.put("name","Soumya12");
		
		RequestSpecification request = RestAssured.given();
		request.body(jObj);		
		request.contentType(ContentType.JSON);		
		Response response = request.patch("https://reqres.in/api/users/2");
		
		int statuscode=response.getStatusCode();
		Assert.assertEquals(200, statuscode,"The status code is passed");
		
		System.out.println(response.getContentType());
		System.out.println(response.getTime());
		System.err.println(response.asString());
	}
	
	@Test(priority = 5)
	public void deleteProject() {
		
		RequestSpecification request = RestAssured.given();		
		Response response = request.delete("https://reqres.in/api/users/2");
		
		int statuscode=response.getStatusCode();
		Assert.assertEquals(204, statuscode,"The status code is passed");
		System.err.println(response.getTime());				
	}

}
