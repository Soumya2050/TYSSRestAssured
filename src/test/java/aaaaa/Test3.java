package aaaaa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test3 {

	public static void main(String[] args) {

		JSONObject obj = new JSONObject();
		obj.put("soumya", "24");
		obj.put("id", "TR553");
		obj.put("phNo", "5463");

		try {
			FileWriter file = new FileWriter(new File("./xyz.json"));
			file.write(obj.toString());
			file.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void chrome() {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		op.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		op.setExperimentalOption("useAutomationExtension", false);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

}
