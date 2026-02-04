package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class EmployeeSectionPage {

	// After add new employee details
	// All the details added should be visible om employee section

	private WebDriver driver;

	@FindBy(xpath = "//a[normalize-space()='Add New Employee']")
	private WebElement addNewEmployeeButton;

	// Table rows for employee list
	@FindBy(xpath = "//table//tbody//tr")
	private List<WebElement> tablerows;

	public EmployeeSectionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Clicks on AddNewEmployeebutton and navigate to add employee form
	@Step("Clicking on Add New Employee Button")
	public void clickAddNewEmployee() {
		addNewEmployeeButton.click();
	}

	// Verify employee details by using EmployeeId
	// second column (employeeid) should return true if found
	// if not found return false
	@Step("Checking if Employee with ID {employeeID}is present")
	public boolean isEmployeePresent(String employeeID) {
		boolean found = false;

		for (int i = 0; i < tablerows.size(); i++) {
			WebElement row = tablerows.get(i);

			List<WebElement> cols = row.findElements(By.tagName("td"));
			if (cols.size() > 1) {
				String idText = cols.get(i).getText().trim();
				if (idText.equalsIgnoreCase(employeeID)) {

					found = true;
					break;

				}
			}

		}
		return found;
	}

}
