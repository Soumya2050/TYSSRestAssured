package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Declaration
	
	@FindBy(id = "usernmae")
	private WebElement username;

	@FindBy(id = "inputPassword")
	private WebElement password;

	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement signIn;
	
	//Intialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Getters And Setters
	
	public WebElement getUsername() {
		return username;
	}

	public void setUsername(WebElement username) {
		this.username = username;
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public WebElement getSignIn() {
		return signIn;
	}

	public void setSignIn(WebElement signIn) {
		this.signIn = signIn;
	}

	// BusinessLibrary

	public void loginToApp(String usName, String psw) {
		username.sendKeys(usName);
		password.sendKeys(psw);
		signIn.click();
	}

}
