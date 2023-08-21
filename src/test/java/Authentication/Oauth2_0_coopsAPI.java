package Authentication;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class Oauth2_0_coopsAPI {
	
	public static void main(String[] args) {
		
		//Generate The access Token
		System.out.println("This is used to generate the token");
		Response response = given()
				.formParam("client_id", "Soumya")
				.formParam("client_secret", "3f3409b24dad08582d95db7b1947fe07")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri ", "http://soumya.com")
				.formParam("code ", "authorization_code")
		.when()
				.post("http://coop.apps.symfonycasts.com/token ");
		
		//Capture The Access Token
		
		String token = response.jsonPath().get("access_token");
		
		System.out.println("Capturing the token:- "+token);
		
		response.then().log().all().statusCode(200);
		//Use token in perticular api
		System.err.println("This is for eggs-collect");
		
		given()
			.auth()
			.oauth2(token)
			.pathParam("uId", 4638)
			
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{uId}/eggs-collect")
		.then().log().all().statusCode(200);
		
		System.err.println("This is for chicken-feed");
		given()
				.auth()
				.oauth2(token)
				.pathParam("uId", 4638)
		
		.when()
				.post("http://coop.apps.symfonycasts.com/api/{uId}/chickens-feed")
				.then().log().all();
		
		System.err.println("This is for eggs-count");
		
		given()
				.auth()
				.oauth2(token)
				.pathParam("uId", 4638)
				

		.when()
				.post("http://coop.apps.symfonycasts.com/api/{uId}/eggs-count")
				.then().log().all().statusCode(200);
		
		
		System.err.println("This is for toiletseat-down");
		
		given()
				.auth()
				.oauth2(token)
				.pathParam("uId", 4638)
				
		.when()
				.post("http://coop.apps.symfonycasts.com/api/{uId}/toiletseat-down")
				
		.then()
				.log().all().statusCode(200);
		
	}

}
