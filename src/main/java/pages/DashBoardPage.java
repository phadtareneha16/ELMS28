package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class DashBoardPage {

	private WebDriver driver;

	// Menu links
	@FindBy(linkText = "Employee Section")
	private WebElement employeeSectionLink;

	@FindBy(linkText = "Department Section")
	private WebElement departmentSectionLink;

	@FindBy(linkText = "Leave Types")
	private WebElement leaveTypesLink;

	@FindBy(linkText = "Manage Leave")
	private WebElement manageLeaveLink;

	@FindBy(linkText = "Manage Admin")
	private WebElement manageAdminLink;

	// Logout Element
	@FindBy(xpath = "//h4[normalize-space()='ADMIN']")
	private WebElement adminDropDown;

	@FindBy(linkText = "Log Out")
	private WebElement logoutLink;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Navigate Towards the employee section
	@Step("Navigating to Employee Section")
	public void goToEmployeeSection() {
		employeeSectionLink.click();
	}

	// Navigate towards the department section
	@Step("Navigating to Department Section")
	public void goToDepartmentSection() {
		departmentSectionLink.click();
	}

	// Navigate towards the LeaveTypes section
	@Step("Navigating to LeaveTypes Section")
	public void goToLeaveTypesSection() {
		leaveTypesLink.click();
	}

	// Navigate towards the Manage leave section
	@Step("Navigating to Manage Leave Section")
	public void goToManageLeaveSection() {
		manageLeaveLink.click();
	}

	// Navigate towards the manage admin section
	@Step("Navigating to Manage Leave Section")
	public void goToManageAdminSection() {
		manageAdminLink.click();
	}

	// Logout of the application
	@Step("Logging out of the Application")
	public void logout() {
		adminDropDown.click();
		logoutLink.click();
	}
}
