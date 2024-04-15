package aaaaa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A {
	
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://connect2compute.wordpress.com/what-is-java/java-inheritance/");
	}

}
