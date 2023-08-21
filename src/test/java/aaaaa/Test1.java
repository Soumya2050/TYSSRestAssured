package aaaaa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {

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

		Actions a = new Actions(driver);
		a.click().perform();

		driver.findElement(By.id("fromCity")).sendKeys("b");
		driver.findElement(By.xpath("//input[@id='fromCity']/following::div/descendant::p[.='Bengaluru, India']"))
				.click();

		driver.findElement(By.id("toCity")).sendKeys("g");

		driver.findElement(By.xpath(
				"//li[@id='react-autowhatever-1-section-0-item-0']/descendant::p[text()='Goa - Dabolim Airport, India']"))
				.click();

		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 2);
		Date d = cal.getTime();
		String date = sdf.format(d);

		SimpleDateFormat sdf1 = new SimpleDateFormat("MMMM yyyy");
		Date d1 = new Date();
		String month = sdf1.format(d1);

		driver.findElement(By.xpath(
				"//div[text()='" + month + "']/parent::div/following-sibling::div/descendant::p[.=" + date + "]"))
				.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele = driver.findElement(By.xpath("//span[.='Return']"));
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
		SimpleDateFormat sd = new SimpleDateFormat("MMMM");
		Date d2 = new Date();
		String mOnth = sd.format(d2);

		SimpleDateFormat sd1 = new SimpleDateFormat("dd");
		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.DATE, 4);
		Date dt1 = cal1.getTime();
		String date1 = sd1.format(dt1);

		driver.findElement(By.xpath(
				"//div[text()='" + mOnth + "']/parent::div/following-sibling::div/descendant::p[.=" + date1 + "]"))
				.click();

		driver.findElement(By.xpath("//a[.='Search']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']")).click();

//		WebElement air = driver.findElement(By
//				.xpath("//p[.='Airlines']/../descendant::p[@class='appendBottom15']/span[@class='linkText pointer']"));
//		a.scrollToElement(air).pause(500).click(air).perform();

		List<WebElement> airlines = driver
				.findElements(By.xpath("//p[.='Airlines']/parent::div/descendant::label/descendant::p"));
		for (WebElement web : airlines) {
			String st[] = web.getText().split(" ");
			int num = Integer.parseInt(st[st.length - 1].replaceAll("\\W+", ""));
			if (num <= 10) {
				WebElement list = driver.findElement(
						By.xpath("//p[text()='Airlines']/parent::div/descendant::label/descendant::p[contains(text(),'"
								+ web.getText() + "')]"));
				list.click();
			}
		}

		List<WebElement> flightName = driver.findElements(
				By.xpath("//div[@class='appendBottom15']/following-sibling::div/descendant::div[@class='makeFlex']"));
		List<WebElement> departureTime = driver.findElements(
				By.xpath("//div[@class='listingCardWrap']/descendant::div[@class='flexOne timeInfoLeft']/p/span"));
		List<WebElement> duration = driver.findElements(
				By.xpath("//div[@class='listingCardWrap']/descendant::div[@class='stop-info flexOne']/p"));
		List<WebElement> arival = driver.findElements(By.xpath(
				"//div[@class='listingCardWrap']/descendant::div[@class='flexOne timeInfoRight']/p[@class='appendBottom2 flightTimeInfo']"));
		List<WebElement> price = driver.findElements(By.xpath(
				"//div[@class='listingCardWrap']/descendant::div[@class='makeFlex column relative splitfare textRight ']/p"));

		FileInputStream fis = new FileInputStream("C:/Users/srjen/OneDrive/Desktop/MakeMyTrip.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet2");

		for (int i = 0; i < flightName.size(); i++) {
			int v = 0;
			sh.createRow(i).createCell(v++).setCellValue(flightName.get(i).getText());
			sh.getRow(i).createCell(v++).setCellValue(departureTime.get(i).getText());
			sh.getRow(i).createCell(v++).setCellValue(duration.get(i).getText());
			sh.getRow(i).createCell(v++).setCellValue(arival.get(i).getText());
			sh.getRow(i).createCell(v++).setCellValue(price.get(i).getText());
		}
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("C:/Users/srjen/OneDrive/Desktop/MakeMyTrip.xlsx");
			wb.write(fos);
		} catch (FileNotFoundException e) {
			wb.close();
		}
		driver.quit();

	}
}
///p/span
