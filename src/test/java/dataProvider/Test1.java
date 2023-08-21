package dataProvider;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.RMGyantra.Utility.Iconstant;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProjectPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Iconstant.AppUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LoginPage l = new LoginPage(driver);
		l.loginToApp(Iconstant.appUserName, Iconstant.appPassword);
		
		HomePage h = new HomePage(driver);
		h.clickProject();
		
		ProjectPage p = new ProjectPage(driver);
		p.clickOnProjectId();
		
		List<WebElement> s = p.getAllProject(driver);
		int count=0;
		for (WebElement webElement : s) {
//			System.out.println(webElement.getText());
			count++;
		}
		
		System.out.println(count);
		
		driver.quit();
	}

}
