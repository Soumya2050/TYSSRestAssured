package dataProvider;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://cosmocode.io/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement ele = driver.findElement(By.xpath("//nav[@id='site-navigation']/descendant::a[.='More']/span"));
		
		Actions a = new Actions(driver);
		
		a.moveToElement(ele).perform();
		
		driver.findElement(By.xpath("//nav[@id='site-navigation']/descendant::a[.='More']/following-sibling::ul/descendant::a[.='Automation Practice | WebTable']")).click();
		
		
		List<WebElement> elem = driver.findElements(By.xpath("//table/tbody/tr/td[contains(text(),'Dollar')]/following-sibling::td[contains(text(),'English')]/preceding-sibling::td/strong"));
		
		int count=0;
		for (WebElement webElement : elem) {
			System.out.println(webElement.getText());
			count++;
		}
		
		System.out.println("Total country is: = "+count);
		
		driver.quit();
	}

}
