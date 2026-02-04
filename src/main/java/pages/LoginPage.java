package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class LoginPage {
	private WebDriver driver;

	// Login Page Fields
	@FindBy(name = "username")
	private WebElement usernameField;

	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(id = "form_submit")
	private WebElement submitButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Login to application
	@Step("Logging in with username{user}")
	public void login(String user, String password) {
		usernameField.clear();
		usernameField.sendKeys(user);

		
		passwordField.clear();
		passwordField.sendKeys(password);
		
		submitButton.click();

	}

}
