package DifferentWaysToPostRequest;

import com.RMGyantra.Utility.JavaUtility;

import Pojo.CreateApojoRMG;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingPojo {

	public static void main(String[] args) {

		baseURI = "http://rmgtestingserver";
		port = 8084;
		JavaUtility jLib = new JavaUtility();
		int random = jLib.getRandomNum();

		CreateApojoRMG po = new CreateApojoRMG("SOUMYA", "TYSS--" + random + "", "Created", 8);
		// pre-request
		given().body(po).contentType(ContentType.JSON)
				// action
				.when().post("/addProject")
				// validation
				.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}

}
