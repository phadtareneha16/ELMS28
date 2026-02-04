package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeaveTypesPage {

	// Verification of page
	private WebDriver driver;

	@FindBy(xpath = "//h4[normalize-space()='Leave Section']")
	private WebElement heading;

	public LeaveTypesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Return the text of the page
	public String getHeading() {
		return heading.getText();
	}

}
