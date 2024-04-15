package aaaaa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Random;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

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

	@Test
	public void unlimitedPost() {

		for (;;) {
			baseURI = "https://reqres.in";
			Random ran = new Random();
			int random = ran.nextInt(10);
			JSONObject obj = new JSONObject();

			obj.put("name", "Jyoti-" + random + "");
			obj.put("job", "SoftwareTE");

			given().body(obj).contentType(ContentType.JSON).when().post("/api/users").then().statusCode(201).log()
					.all();
		}
	}

}
