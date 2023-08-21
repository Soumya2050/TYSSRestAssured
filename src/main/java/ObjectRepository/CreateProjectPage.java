package ObjectRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.RMGyantra.Utility.WebActionUtility;

public class CreateProjectPage {

	@FindBy(name = "projectName")
	private WebElement projectName;

	@FindBy(name = "teamSize")
	private WebElement teamSize;

	@FindBy(name = "createdBy")
	private WebElement projectManager;

	@FindBy(xpath = "//option[.='Select Value']/parent::select")
	private WebElement status;

	@FindBy(xpath = "//input[@value='Add Project']")
	private WebElement addProject;

	// Intialiazation

	public CreateProjectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Getters and Setters

	public WebElement getProjectName() {
		return projectName;
	}

	public void setProjectName(WebElement projectName) {
		this.projectName = projectName;
	}

	public WebElement getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(WebElement teamSize) {
		this.teamSize = teamSize;
	}

	public WebElement getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(WebElement projectManager) {
		this.projectManager = projectManager;
	}

	public WebElement getStatus() {
		return status;
	}

	public void setStatus(WebElement status) {
		this.status = status;
	}

	public WebElement getAddProject() {
		return addProject;
	}

	public void setAddProject(WebElement addProject) {
		this.addProject = addProject;
	}

	// Business Logic

	public void createProjectName(WebDriver driver, String project, int value, String createBy) {
		projectName.sendKeys(project);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByTagName('input').teamSize.value='" + value + "'");
		projectManager.sendKeys(createBy);
	}
	public void clickOnAddProject() {
		addProject.click();
	}

}
