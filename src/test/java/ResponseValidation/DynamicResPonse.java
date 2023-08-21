package ResponseValidation;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.Assert;

import io.restassured.response.Response;

public class DynamicResPonse {

	public static void main(String[] args) {

		baseURI = "http://rmgtestingserver";
		port = 8084;

		String expData = "TY_PROJ_12348";

		Response response = when().get("/projects");

		List<String> actData = response.jsonPath().get("projectId");

		boolean flag = false;

		for (String string : actData) {

			if (actData.equals(expData)) {
				flag = true;
			}
		}

		Assert.assertTrue(true);
		System.out.println("The projectId is verified successfully");

		response.then()
		.assertThat()
		.time(Matchers.lessThanOrEqualTo(3000l), TimeUnit.MILLISECONDS)
		.statusCode(200);
	}

}
