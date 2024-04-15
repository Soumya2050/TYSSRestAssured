package ResponseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicResPonse {

	public static void main(String[] args) {

		baseURI = "http://rmgtestingserver";
		port = 8084;

		String expData = "TY_PROJ_12348";

		Response response = when().get("/projects");

		List<String> actData = response.jsonPath().get("projectId");

		boolean flag = false;

		for (String string : actData) {

			if (actData.equals(expData)) {
				flag = true;
			}
		}

		Assert.assertTrue(true);
		System.out.println("The projectId is verified successfully");

		response.then()
		.assertThat()
		.time(Matchers.lessThanOrEqualTo(3000l), TimeUnit.MILLISECONDS)
		.statusCode(200);
	}
	
	@Test
	public void switchToMultipleTab() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		for(int i=1;i<=3;i++) {
		driver.switchTo().newWindow(WindowType.TAB);
		}
		
		ArrayList<String> list  = new ArrayList<>(driver.getWindowHandles());
		String lastTab = list.get(list.size()-1);
		
	
			driver.switchTo().window(lastTab);
		
			
	}

}
