package DifferentWaysToPostRequest;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import com.RMGyantra.Utility.JavaUtility;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class CreateObjectUsingJsonObject {

	public static void main(String[] args) {

		JavaUtility jlib = new JavaUtility();
		baseURI = "http://rmgtestingserver";
		port = 8084;

		// System.out.println(randumNum);
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "soumya-");
		jObj.put("projectName", "TestYantraa" + jlib.getRandomNum());
		jObj.put("status", "created");
		jObj.put("teamSize", "5");

		// Step 1: pre-condition
		given()
			.body(jObj)
			.contentType(ContentType.JSON)

				// Step 2 : Action

				.when()
					.post("/addProject")

				// Step 3 : Validation

				.then()
					.assertThat()
					.time(Matchers.lessThanOrEqualTo(3000l), TimeUnit.MILLISECONDS)
					.statusCode(201)
					.log().all();

	}

}
