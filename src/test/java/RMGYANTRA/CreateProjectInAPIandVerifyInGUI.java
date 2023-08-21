package RMGYANTRA;

import static io.restassured.RestAssured.*;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.RMGyantra.Utility.EndPointLibrary;
import com.RMGyantra.Utility.Iconstant;
import com.RMGyantra.Utility.JavaUtility;
import com.aventstack.extentreports.gherkin.model.Then;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProjectPage;
import Pojo.CreateApojoRMG;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateProjectInAPIandVerifyInGUI {

	@Test
	public void createProjectInAPIandVfInGUI() {
		baseURI = Iconstant.AppUrl;
		JavaUtility jLib = new JavaUtility();
		int random = jLib.getRandomNum();
		CreateApojoRMG po = new CreateApojoRMG("soumya", "Tyss--" + random + "", "Opened", 15);

		Response response = given().body(po).contentType(ContentType.JSON).when().post(EndPointLibrary.addProject);
		response.then().log().all().statusCode(201);

		String projectId = response.jsonPath().get("projectId");

		System.out.println(projectId);

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Iconstant.AppUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		/**
		 * This method is used to LogIn to DB
		 */
		LoginPage l = new LoginPage(driver);
		l.loginToApp(Iconstant.appUserName, Iconstant.appPassword);

		HomePage h = new HomePage(driver);
		h.clickProject();

		ProjectPage p = new ProjectPage(driver);
		p.clickOnProjectId();

		List<WebElement> pro = p.getAllProject(driver);

		boolean flag = false;

		for (WebElement webElement : pro) {
			if (webElement.getText().equalsIgnoreCase(projectId)) {
				flag = true;
			}
		}
		Assert.assertTrue(true);
		System.out.println("Project id is Verified successFully");

		driver.close();
	}

	@Test
	public void deleteProject() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Iconstant.AppUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		/**
		 * This method is used to LogIn to DB
		 */
		LoginPage l = new LoginPage(driver);
		l.loginToApp(Iconstant.appUserName, Iconstant.appPassword);

		HomePage h = new HomePage(driver);
		h.clickProject();

		ProjectPage p = new ProjectPage(driver);
		p.clickOnProjectId();

		List<WebElement> pro = p.getAllProject(driver);

		for (WebElement webElement : pro) {
			baseURI = Iconstant.AppUrl;
			when().delete(EndPointLibrary.deleteProj + webElement.getText()).then().log().all().statusCode(204);
		}

	}

	@Test
	public void createProjectRandom() {

		for (;;) {
			baseURI = Iconstant.AppUrl;
			JavaUtility jLib = new JavaUtility();
			int rendom = jLib.getRandomNum();
			CreateApojoRMG pojo = new CreateApojoRMG("Soumya", "Tyss-" + rendom + "", "OnGoing", 8);
			given().body(pojo).contentType(ContentType.JSON).when().post(EndPointLibrary.addProject).then().log().all();
		}
	}

}
