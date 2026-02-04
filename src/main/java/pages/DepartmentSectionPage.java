package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepartmentSectionPage {

	// Verification of page
	private WebDriver driver;

	@FindBy(xpath = "//h4[normalize-space()='Department Section']")
	private WebElement heading;

	public DepartmentSectionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Return the text of the page
	public String getHeading() {
		return heading.getText();
	}

}
