package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageAdminPage {

	// Verification of page
	private WebDriver driver;

	@FindBy(xpath = "//h4[normalize-space()='Admin Section']")
	private WebElement heading;

	public ManageAdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Return the text of the page
	public String getHeading() {
		return heading.getText();
	}

}
