package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//Declaration
	
	@FindBy(xpath = "//h2[text()='Welcome To Project Management System']")private WebElement projectHeader;
	
	@FindBy(xpath = "//nav[@id='sidebar']/descendant::a[.='Projects']")private WebElement project;
	
	@FindBy(xpath = "//span[text()='Create Project']")private WebElement createProject;
	
	//Intialization
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Getters and Setters
	
	public WebElement getProjectHeader() {
		return projectHeader;
	}

	public void setProjectHeader(WebElement projectHeader) {
		this.projectHeader = projectHeader;
	}

	public WebElement getProject() {
		return project;
	}

	public void setProject(WebElement project) {
		this.project = project;
	}

	public WebElement getCreateProject() {
		return createProject;
	}

	public void setCreateProject(WebElement createProject) {
		this.createProject = createProject;
	}
	
	//BusinessLibrary
	
	public void clickProject() {
		
		project.click();
	}
	
	public void clickCreateProject() {
		createProject.click();
	}
	
	

}
