package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageLeavePage {

	// Verification of page
	private WebDriver driver;

	@FindBy(xpath = "//span[normalize-space()='Manage Leave']")
	private WebElement heading;

	public ManageLeavePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Return the text of the page
	public String getHeading() {
		return heading.getText();
	}

}
