package dataProvider;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RMGyantra.Utility.JavaUtility;

import Pojo.CreateApojoRMG;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class CreateProjectUsingDataProvider {
	
	@DataProvider
	public Object[][] data() {
		
		JavaUtility jLib = new JavaUtility();
		Object[][] obj = new Object[4][4];
		
		obj[0][0]="soumya";
		obj[0][1]="Tyss"+jLib.getRandomNum()+"";
		obj[0][2]="completed";
		obj[0][3]=8;
		
		obj[1][0]="soumya";
		obj[1][1]="TYSS"+jLib.getRandomNum()+"";
		obj[1][2]="created";
		obj[1][3]=14;
		
		obj[2][0]="soumya";
		obj[2][1]="soumya"+jLib.getRandomNum()+"";
		obj[2][2]="OnTheWay";
		obj[2][3]=12;
		
		obj[3][0]="soumya";
		obj[3][1]="soumya"+jLib.getRandomNum()+"";
		obj[3][2]="Ongoing";
		obj[3][3]=10;	
		
		return obj;
	}
	
	@Test(dataProvider = "data")	
	public void createProjectUsingDataProvider(String createdBy,String projectName,String status,int teamSize) {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		CreateApojoRMG poj = new CreateApojoRMG(createdBy, projectName, status, teamSize);
		
		given()
			.body(poj)
			.contentType(ContentType.JSON)
		.when()
			.post("/addProject")
		.then()
			.assertThat()
			.time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS)
			.statusCode(201)
			.log().all();
	}
	

}
