package Authentication;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.RMGyantra.Utility.Iconstant;

public class BasicAuth {

	@Test(priority = 1)
	public void basicAuth() {

		baseURI = "http://rmgtestingserver";
		port = 8084;
		given().auth().basic("rmgyantra", "rmgy@9999").when().get("/login").then().log().all().statusCode(202)
				.assertThat().time(Matchers.lessThan(3000l), TimeUnit.MILLISECONDS);

	}

	@Test(priority = 2)
	public void authPreemtive() {
		baseURI = "http://rmgtestingserver";
		port = 8084;

		given().auth().preemptive().basic("rmgyantra", "rmgy@9999").when().get("/login").then().log().all().assertThat()
				.statusCode(202).time(Matchers.lessThan(3000l), TimeUnit.MILLISECONDS);
	}

	@Test(priority = 3)
	public void AuthDigest() {
		baseURI = "http://rmgtestingserver";
		port = 8084;

		given().auth().digest("rmgyantra", "rmgy@9999").when().get("/login").then().log().all().assertThat()
				.statusCode(202).time(Matchers.lessThan(3000l), TimeUnit.MILLISECONDS);
	}
}
