package requestChaining;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import com.RMGyantra.Utility.JavaUtility;

import Pojo.ReqresPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestChainingInReqres {

	public static void main(String[] args) {

		JavaUtility jLib = new JavaUtility();
		int random = jLib.getRandomNum();
		baseURI = "https://reqres.in";

		ReqresPOJO req = new ReqresPOJO("soumya--" + random + "", "sdet");
		
		System.err.println("This is used to fetch all the project");
		
		given()
				.queryParam("page", 2);
		
		Response response = when().get("/api/users");
		
		System.err.println("This method is used capture the id data");
		
		int pid = response.jsonPath().get("data[0].id");

		System.out.println(pid);
		
		response.then().log().all()
						.assertThat()
						.time(Matchers.lessThan(3000l), TimeUnit.MILLISECONDS)
						.statusCode(200)
						.contentType(ContentType.JSON);
		
		System.err.println("This method is used to fetch the single id");
		given().pathParam("aid", pid)

				.when().get("/api/users/{aid}")

				.then().log().all().assertThat().time(Matchers.lessThan(3000l), TimeUnit.MILLISECONDS).statusCode(200);
		
		System.err.println("This method is used to update the id");
		given()
				.pathParam("Aid", pid)
				.body(req)
				.contentType(ContentType.JSON)
		.when()
				.put("/api/users/{Aid}")
		.then()
				.log().all()
				.assertThat()
				.time(Matchers.lessThan(3000l), TimeUnit.MILLISECONDS)
				.statusCode(200)
				.contentType(ContentType.JSON);
		
		System.err.println("This method is used to delete the id");
		
		given().pathParam("deleteId", pid)
		
		.when()
				.delete("/api/users/{deleteId}")
		.then()
				.log().all()
				.statusCode(204)
				.time(Matchers.lessThan(3000l), TimeUnit.MILLISECONDS);
		

	}

}
