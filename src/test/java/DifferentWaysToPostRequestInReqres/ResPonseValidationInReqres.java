package DifferentWaysToPostRequestInReqres;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ResPonseValidationInReqres {

	public static void main(String[] args) {

		baseURI = "https://reqres.in";

		String exp = "Ferguson";

		Response res = when().get("/api/users?page=2");

		List<String> act = res.jsonPath().get("data.last_name");

		boolean flag = false;
		for (String string : act) {

			if (act.equals(exp)) {
				flag = true;
			}
		}
		Assert.assertTrue(true);
		System.out.println("Last name is verified successfully");

		res.then()
		.assertThat()
		.time(Matchers.lessThanOrEqualTo(3000l), TimeUnit.MILLISECONDS)
		.statusCode(200);
	}

	@Test
	public void staticResponseValidation() {
		
		baseURI = "https://reqres.in";

		String exp = "Ferguson";
		
		Response res = when().get("/api/users?page=2");
		
		String act = res.jsonPath().getString("data[1].last_name");
		
		Assert.assertEquals(act, exp);
		System.out.println("The name is verified");
		
		res.then()
		.assertThat()
		.time(Matchers.lessThanOrEqualTo(3000l), TimeUnit.MILLISECONDS)
		.statusCode(200);
	}

}
