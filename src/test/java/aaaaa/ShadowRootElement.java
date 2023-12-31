package aaaaa;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowRootElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();

		driver.get("https://shop.polymer-project.org/");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// Easy way to get the element JS path, go to the browser element address and
		// rt-click and copy JS path
		// second way by document route
		// document.querySelector(eleAdd).shadowRoot.querySelector(eleAdd)
		// use return keyword then only JS will return the DOM
		// Type cast the Object to WebElement
		WebElement shopNow = (WebElement) jse.executeScript(
				"return document.querySelector('body > shop-app').shadowRoot.querySelector('iron-pages > shop-home').shadowRoot.querySelector('div:nth-child(2) > shop-button > a')");
		shopNow.click();
		// if you cannot perform action using WebElement methods then use JS methods
		// To Click --> arguments[0].click();
		// To send the keys--> arguments[0].setAttribute('value','sendTheValue')
		// jse.executeScript("arguments[0].click();", shopNow);
	}

	@Test
	public void shadowElement() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://shop.polymer-project.org/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object elementObj = js.executeScript(
				"return document.querySelector(\"body > shop-app\").shadowRoot.querySelector(\"iron-pages > shop-home\").shadowRoot.querySelector(\"div:nth-child(2) > a > shop-image\").shadowRoot.querySelector(\"#img\")");
		WebElement element = (WebElement) elementObj;
		element.click();
		
		driver.quit();
	}

}
