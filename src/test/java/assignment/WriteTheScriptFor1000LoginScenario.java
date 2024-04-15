package assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import groovy.lang.Buildable;

public class WriteTheScriptFor1000LoginScenario {

	@Test(dataProvider = "testData")
	public void data(String a, String b) {
		System.out.println(a + ">>>>>>>>>>" + b);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.actitime.com/login.do");

		driver.findElement(By.name("username")).sendKeys(a);
		driver.findElement(By.name("pwd")).sendKeys(b);
		driver.findElement(By.id("loginButton")).click();
		driver.quit();
	}

	@DataProvider
	public Object[][] testData() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/ProjectRMG.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet3");
		int row = sh.getLastRowNum() + 1;
		int cell = sh.getRow(0).getLastCellNum();

		Object[][] obj = new Object[row][cell];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cell; j++) {
				obj[i][j] = sh.getRow(i).getCell(j).toString();
			}
		}
		return obj;

	}

	@Test
	public void clearUsingActionClass() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.actitime.com/login.do");

		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys("admin");
		Thread.sleep(3000);
		Actions a = new Actions(driver);
		a.click(userName).keyDown(Keys.CONTROL).sendKeys("a")
		.keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE)
		.build().perform();
		Thread.sleep(3000);
		userName.sendKeys("admin");
		userName.clear();
		
		userName.sendKeys("admin");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementsByName('username').value=' ';" ,userName);
		
	}

}
