package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import config.ConfigReader;
import pages.AddNewEmployeeSectionPage;
import pages.DashBoardPage;
import pages.EmployeeSectionPage;
import pages.LoginPage;
import utils.ExcelUtils;

public class EmployeeTest extends BaseClass {

	@Test(priority = 2)
	@DataProvider(name = "employeeData")
	public Object[][] employeeData() {
		String path = System.getProperty("user.dir") + "C:\\New Eclipse\\ELMS28\\TestData\\TestDataEmp.xlsx";
		return ExcelUtils.readExcelData(path);
	}

	@Test(dataProvider = "employeeData")
	public void addEmployeeTest(String employeeId, String firstName, String lastName, String email, String department,
			String gender, String dob, String contact, String country, String address, String city, String password,
			String confirmPassword) {

		// Step 1------------> Login
		// Login first
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		// Step 2----------->Navigate to Employee Section
		DashBoardPage dashboard = new DashBoardPage(driver);
		dashboard.goToEmployeeSection();

		// Step 3------------->Click on add new employee
		EmployeeSectionPage employeeSection = new EmployeeSectionPage(driver);
		employeeSection.clickAddNewEmployee();

		// Step 4-------------->Fill and Submit the form
		AddNewEmployeeSectionPage newemployee = new AddNewEmployeeSectionPage(driver);
		newemployee.addEmployee(employeeId, firstName, lastName, email, department, gender, dob, contact, country,
				address, city, password, confirmPassword);

		// Step5------------>After submission,we should returned new employee list
		// It is necessary to navigate back to employee list first to check new employee
		// record
		// is present or not
		dashboard.goToLeaveTypesSection();
		boolean isPresent = employeeSection.isEmployeePresent(employeeId);
		Assert.assertTrue(isPresent, "Employee with ID" + employeeId + "was not found in the list");

	}

}
