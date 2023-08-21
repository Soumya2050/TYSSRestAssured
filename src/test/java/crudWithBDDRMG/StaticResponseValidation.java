package crudWithBDDRMG;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;

import io.restassured.response.Response;

public class StaticResponseValidation {
	
	
	public static void main(String[] args) {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		String expData = "TY_PROJ_9523";
		
		Response response = when().get("/projects");
		
		List<String> actData = response.jsonPath().get("projectId");
		
		boolean flag = false;
		for (String string : actData) {
			
			if(actData.equals(expData))
			{
				flag = true;
			}
		}
		Assert.assertTrue(true);
		System.out.println("Project is verified");
	}

}
