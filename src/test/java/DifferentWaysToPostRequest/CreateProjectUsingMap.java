package DifferentWaysToPostRequest;

import static io.restassured.RestAssured.*;

import java.util.LinkedHashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.RMGyantra.Utility.JavaUtility;

import io.restassured.http.ContentType;

public class CreateProjectUsingMap {

	public static void main(String[] args) {

		baseURI = "http://rmgtestingserver";
		port = 8084;
		JavaUtility jLib = new JavaUtility();
		LinkedHashMap<String, String> map = new LinkedHashMap<>();

		map.put("createdBy", "SOujdb");
		map.put("projectName", "SDET-" + "" + jLib.getRandomNum() + "");
		map.put("status", "ongoing143");
		map.put("teamSize", "10");
		// pre-condition
		given().body(map).contentType(ContentType.JSON)
				// Action
				.when().post("/addProject")
				// Validation
				.then().assertThat().contentType(ContentType.JSON).statusCode(201).log().all();
	}
}
