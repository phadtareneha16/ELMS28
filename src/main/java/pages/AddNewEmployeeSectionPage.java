package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Step;

public class AddNewEmployeeSectionPage {

	// Add new employee form
	// fill out the form for new employee

	private WebDriver driver;

	// form fields
	@FindBy(name = "empcode")
	private WebElement employeeField;

	@FindBy(name = "firstName")
	private WebElement firstNameField;

	@FindBy(name = "lastName")
	private WebElement lastNameField;

	@FindBy(name = "email")
	private WebElement emailField;

	@FindBy(name = "department")
	private WebElement departmentDropdown;

	@FindBy(name = "gender")
	private WebElement genderDropdown;

	@FindBy(name = "dob")
	private WebElement dobField;

	@FindBy(name = "mobileno")
	private WebElement contactNumberField;

	@FindBy(name = "country")
	private WebElement countryField;

	@FindBy(name = "address")
	private WebElement addressField;

	@FindBy(name = "city")
	private WebElement cityField;

	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(name = "confirmpassword")
	private WebElement confirmpasswordField;

	@FindBy(xpath = "//button[@id='update']")
	private WebElement proceedButton;

	public AddNewEmployeeSectionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Perfom the filling of form

	@Step("Adding new employee with {employeeId}")
	public void addEmployee(String employeeId, String firstName, String lastName, String email, String department,
			String gender, String dob, String contact, String country, String address, String city, String password,
			String confirmPassword) {

		// Fill the text fields
		employeeField.clear();
		employeeField.sendKeys(employeeId);

		firstNameField.clear();
		firstNameField.sendKeys(firstName);

		lastNameField.clear();
		lastNameField.sendKeys(lastName);

		emailField.clear();
		emailField.sendKeys(email);

		// Department dropdown
		Select deptSelect = new Select(departmentDropdown);
		deptSelect.selectByVisibleText(department);

		// gender dropdown
		Select genderSelect = new Select(genderDropdown);
		genderSelect.selectByVisibleText(gender);

		// DOB Field Picker
		dobField.clear();
		dobField.sendKeys(dob);

		contactNumberField.clear();
		contactNumberField.sendKeys(contact);

		countryField.clear();
		countryField.sendKeys(country);

		addressField.clear();
		addressField.sendKeys(address);

		cityField.clear();
		cityField.sendKeys(city);

		passwordField.clear();
		passwordField.sendKeys(password);

		confirmpasswordField.clear();
		confirmpasswordField.sendKeys(confirmPassword);

		// Submit the form
		proceedButton.click();

	}

}
