package requestAndResponseSpecBuilder;

import com.RMGyantra.Utility.JavaUtility;

import Pojo.CreateApojoRMG;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CreateProjectRMG {

	public static void main(String[] args) {
		JavaUtility jLib = new JavaUtility();

		CreateApojoRMG postData = new CreateApojoRMG("Soumya", "soumya~~" + jLib.getRandomNum() + "", "ongoing", 12);

		RequestSpecification request = new RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084")
				.setContentType(ContentType.JSON).build();

		ResponseSpecification respone = new ResponseSpecBuilder().expectStatusCode(201)
				.expectContentType(ContentType.JSON).build();
		
		given().spec(request).body(postData).contentType(ContentType.JSON)

				.when().post("/addProject")

				.then().spec(respone).time(Matchers.lessThan(3000l), TimeUnit.MILLISECONDS)
				/* .statusLine(Matchers.stringContainsInOrder("Created")) */.log().all();

	}

}
