package aaaaa;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpijectScenario {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		option.setExperimentalOption("useAutomationExtension", false);
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.spicejet.com/");

		driver.findElement(By.xpath(
				"//div[@class='css-1dbjc4n']/descendant::div[.='round trip' and @data-testid='round-trip-radio-button']"))
				.click();
		driver.findElement(By.xpath(
				"//div[@class='css-1dbjc4n r-1pcd2l5 r-1uwte3a r-m611by r-bnwqim']/descendant::div[text()='From']"))
				.click();
		driver.findElement(By.xpath(
				"//div[@class='css-1dbjc4n r-13awgt0 r-18u37iz']/descendant::div[.='From' and @dir]/following-sibling::div/input[@autocapitalize=\"sentences\"]"))
				.sendKeys("ben");
		driver.findElement(By.xpath(
				"//div[@class='css-1dbjc4n r-13awgt0 r-18u37iz']/descendant::div[.='From' and @dir]/following-sibling::div/input[@autocapitalize=\"sentences\"]/following::div[@class='css-1dbjc4n r-18u37iz']/descendant::div[.='Bengaluru']/div"))
				.click();
		driver.findElement(By.xpath(
				"//div[@class='css-1dbjc4n r-1pcd2l5 r-1uwte3a r-m611by r-bnwqim']/descendant::div[text()='To']"))
				.click();

		driver.findElement(By.xpath(
				"//div[@class='css-1dbjc4n r-13awgt0 r-18u37iz']/descendant::div[.='To' and @dir]/following-sibling::div/input[@autocapitalize=\"sentences\"]"))
				.sendKeys("man");

		driver.findElement(By.xpath(
				"//div[@class='css-1dbjc4n r-13awgt0 r-18u37iz']/descendant::div[.='To' and @dir]/following-sibling::div/input[@autocapitalize=\"sentences\"]/following::div[@class='css-1dbjc4n r-18u37iz']/descendant::div[.='Mangaluru']/div"))
				.click();
		
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
		Date d = new Date();
		String month = sdf.format(d);
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 0);
		Date d2 = cal.getTime();
		String date = sdf2.format(d2);
	
		
		driver.findElement(By.xpath(
				"//div[@data-testid='undefined-month-"+month+"']/descendant::div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41' and .='"+date+"']"))
				.click();
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("MMMM-yyyy");
		Date d1 = new Date();
		String month1 = sdf1.format(d1);
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd");
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE,2);
		Date d3 = cal2.getTime();
		String date1 = sdf3.format(d3);
		
		
		driver.findElement(By.xpath(
				"//div[@data-testid='undefined-month-"+month1+"']/descendant::div[@class='css-1dbjc4n r-1awozwy r-1pi2tsx r-1777fci r-13qz1uu']/div[.='"+date1+"']"))
				.click();

		// passenger

		driver.findElement(By.xpath("//div[.='Passengers']")).click();

		for (int i = 0; i < 3; i++) {
			driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		}

		WebElement chil = driver.findElement(By.xpath("//div[@data-testid='Children-testID-plus-one-cta']"));

		new Actions(driver).moveToElement(chil).doubleClick().perform();

		driver.findElement(By.xpath("//div[@data-testid='Infant-testID-plus-one-cta']")).click();
		driver.findElement(By.xpath("//div[@data-testid='home-page-travellers-done-cta']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement search = driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']"));

		wait.until(ExpectedConditions.elementToBeClickable(search)).click();
	}

}
