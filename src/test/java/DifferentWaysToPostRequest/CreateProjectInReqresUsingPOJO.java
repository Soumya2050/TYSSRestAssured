package DifferentWaysToPostRequest;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;

import com.RMGyantra.Utility.JavaUtility;

import Pojo.ReqresPOJO;
import io.restassured.http.ContentType;

public class CreateProjectInReqresUsingPOJO {

	public static void main(String[] args) {
		JavaUtility jLib = new JavaUtility();
		int random = jLib.getRandomNum();
		baseURI = "https://reqres.in";
		ReqresPOJO po = new ReqresPOJO("soumya--" + random + "", "SoftwareTest");

		given().body(po).contentType(ContentType.JSON)

				// action
				.when().post("/api/users")
				// validation
				.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();

	}

}
