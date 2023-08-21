package RMGYANTRA;

import org.testng.annotations.Test;

import com.RMGyantra.Utility.BaseClass;
import com.RMGyantra.Utility.DataBaseUtility;
import com.RMGyantra.Utility.EndPointLibrary;
import com.RMGyantra.Utility.Iconstant;
import com.RMGyantra.Utility.JavaUtility;
import com.RMGyantra.Utility.RestAssuredLibrary;

import Pojo.CreateApojoRMG;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProject extends BaseClass {

	JavaUtility jLib = new JavaUtility();

	@Test
	public void createProjectAndValidateInDB() throws Throwable {

		baseURI = Iconstant.AppUrl;
		CreateApojoRMG cp = new CreateApojoRMG("Soumya", "soumya-" + jLib.getRandomNum() + "", "Created", 10);

		Response response = given().body(cp).contentType(ContentType.JSON).when().post(EndPointLibrary.addProject);

		response.then().log().all();

		RestAssuredLibrary rLib = new RestAssuredLibrary();
		String data = rLib.getData(response, "projectId");
		System.out.println(data);
		DataBaseUtility dLib = new DataBaseUtility();
		String query = "Select * from project";
		dLib.executeQuerryAndVerify(query, 1, data);

	}

}
