package Parameter;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

public class QueryParameterInReqres {

	public static void main(String[] args) {

		baseURI = "https://reqres.in";

		given()
			.queryParam("page", 2)

				.when()
					.get("/api/users")

				.then()
					.assertThat()
					.time(Matchers.lessThan(3000l), TimeUnit.MILLISECONDS)
					.statusCode(200)
					.statusLine(Matchers.stringContainsInOrder("OK"))
					.log().all();
	}

}
