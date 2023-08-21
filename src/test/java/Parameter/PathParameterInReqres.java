package Parameter;

import  static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class PathParameterInReqres {
	
	public static void main(String[] args) {
		
		baseURI="https://reqres.in";
		
		given()
			.pathParam("path", 2)
			
			.when().get("/api/users/{path}")
			
			.then().assertThat()
			.time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS)
			.log().all();
	}
}
