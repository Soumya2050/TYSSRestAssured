package requestChaining;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

import com.RMGyantra.Utility.JavaUtility;

import Pojo.CreateApojoRMG;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestChainingInRMG {
	
	public static void main(String[] args) {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		JavaUtility jLib = new JavaUtility();
		int random = jLib.getRandomNum();
		CreateApojoRMG poj = new CreateApojoRMG("Soumya", "TYSS--"+random+"", "Created", 10);
		System.out.println("This method is used to create the project");
		Response res = given().body(poj).contentType(ContentType.JSON)
		
		.when().post("/addProject");
		
		res.then().log().all()
				  .assertThat().time(Matchers.lessThan(3000l), TimeUnit.MILLISECONDS)
				  .statusCode(201);
		System.err.println("This method is used to capture the projectId");
		String pid = res.jsonPath().get("projectId");
		String pName = res.jsonPath().getString("projectName");
		System.out.println(pid+"<--->"+pName);
		
		CreateApojoRMG poj1 = new CreateApojoRMG("Soumya123", pName, "OnGoing", 8);
		
		System.err.println("This method is used to completly update the project");
		
		given().pathParam("aid", pid).body(poj1).contentType(ContentType.JSON)
		
		.when().put("/projects/"+pid+"")
		
		.then().log().all().assertThat()
		.time(Matchers.lessThan(3000l), TimeUnit.MILLISECONDS)
		.statusCode(200);
		
		System.err.println("This method is used to fetch the projectId");
		
		given().pathParam("gId", pid).when().get("/projects/{gId}")
		.then().log().all().statusCode(200).time(Matchers.lessThan(3000l), TimeUnit.MILLISECONDS);
		
	}

}
