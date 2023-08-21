package RMGYANTRA;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.RMGyantra.Utility.BaseClass;
import com.RMGyantra.Utility.DataBaseUtility;
import com.RMGyantra.Utility.EndPointLibrary;
import com.RMGyantra.Utility.Iconstant;
import com.RMGyantra.Utility.JavaUtility;
import com.RMGyantra.Utility.RestAssuredLibrary;
import com.RMGyantra.Utility.WebActionUtility;

import ObjectRepository.CreateProjectPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProjectPage;
import Pojo.CreateApojoRMG;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProjectInGUI extends BaseClass{

	@Test
	public void createProjectWithGUIAndUpdateInAPIAndValidateDB() throws Throwable {

		JavaUtility jLib = new JavaUtility();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Iconstant.AppUrl);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		LoginPage l = new LoginPage(driver);

		l.loginToApp(Iconstant.appUserName, Iconstant.appPassword);

		HomePage h = new HomePage(driver);
		h.clickProject();
		h.clickCreateProject();

		CreateProjectPage cp = new CreateProjectPage(driver);
		WebElement a = cp.getStatus();
		
		int random = jLib.getRandomNum();
		cp.createProjectName(driver, "Tyss--"+random+"", 13, "soumya");
		
//		WebActionUtility wLib = new WebActionUtility();
//		wLib.waitForElement(driver, a);
//		wLib.select(a, 1);
		cp.clickOnAddProject();
		
		driver.navigate().refresh();
		h.clickProject();
		ProjectPage p = new ProjectPage(driver);
		p.clickOnProjectId();
		String pId = p.getProjectId(driver, "Tyss--"+random+"");
		System.err.println(pId);
		driver.quit();
		
		baseURI=Iconstant.AppUrl;
		CreateApojoRMG c = new CreateApojoRMG("Soumya", "Tyss--"+random+"", "OnGoing", 15);
		
		Response response = given().body(c).contentType(ContentType.JSON)
		.when().put(EndPointLibrary.comUpdateProj+pId);
		
		response.then().log().all();
		
		RestAssuredLibrary rLib = new RestAssuredLibrary();
		
		String data = rLib.getData(response, "createdBy");
		System.out.println(data);
		DataBaseUtility dLib = new DataBaseUtility();
		String query = "Select * from project;";
		boolean flag = dLib.executeQuerryAndVerify(query, 2, data);
		System.out.println(flag);
		
//		when().get(EndPointLibrary.getProject).then().log().all();
		
	}
}
