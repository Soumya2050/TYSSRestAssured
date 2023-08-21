package Authentication;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class BearerToken {

	@Test
	public void gitHub() {
		baseURI = "https://api.github.com";
		JSONObject jObj = new JSONObject();
		jObj.put("name", "RestAssured");
		jObj.put("description", "RepositoryForRestAssured");

		given().auth().oauth2("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").body(jObj).contentType(ContentType.JSON)
				.when().post("/user/repos").then().log().all().assertThat().statusCode(201)
				.statusLine(Matchers.stringContainsInOrder("Created"))
				.time(Matchers.lessThan(3000l), TimeUnit.MILLISECONDS);
	}

}
