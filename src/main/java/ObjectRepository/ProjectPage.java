package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectPage {

	// Declaration
	@FindBy(xpath = "//th[text()='ProjectId']")
	private WebElement projectId;

	// Intialization

	public ProjectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProjectId() {
		return projectId;
	}

	public void setProjectId(WebElement projectId) {
		this.projectId = projectId;
	}

	// BusinessLibrary
	public void clickOnProjectId() {
		projectId.click();
	}

	public String getProjectId(WebDriver driver, String projectName) {
		String poId = driver.findElement(By.xpath("//tr/td[.='" + projectName + "']/preceding-sibling::td")).getText();
		return poId;
	}
	
	public List<WebElement> getAllProject(WebDriver driver) {		
		List<WebElement> ele = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		return ele;
		
	}

}
