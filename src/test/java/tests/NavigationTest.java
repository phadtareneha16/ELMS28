package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import config.ConfigReader;
import io.qameta.allure.Description;
import pages.DashBoardPage;
import pages.DepartmentSectionPage;
import pages.LeaveTypesPage;
import pages.LoginPage;
import pages.ManageAdminPage;
import pages.ManageLeavePage;

public class NavigationTest extends BaseClass {

	@Test(priority = 3)
	@Description("Verify Navigation to all the departments")
	public void verifyNavigationToAllSections() {
		// Login first
		LoginPage loginPage = new LoginPage(driver);

		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		DashBoardPage dashboard = new DashBoardPage(driver);

		// Department section
		dashboard.goToDepartmentSection();
		DepartmentSectionPage deptPage = new DepartmentSectionPage(driver);
		Assert.assertNotNull(deptPage.getHeading(), "Department Section heading is null");

		// Leave Types
		dashboard.goToLeaveTypesSection();
		LeaveTypesPage leavePage = new LeaveTypesPage(driver);
		Assert.assertNotNull(leavePage.getHeading(), "Leave Types Section heading is null");

		// Manage Leave
		dashboard.goToManageLeaveSection();
		ManageLeavePage manageleavepage = new ManageLeavePage(driver);
		Assert.assertNotNull(manageleavepage.getHeading(), "Manage Leave Section heading is null");

		// Manage Admin
		dashboard.goToManageAdminSection();
		ManageAdminPage manageadminpage = new ManageAdminPage(driver);
		Assert.assertNotNull(manageleavepage.getHeading(), "Manage Admin Section heading is null");

	}

}
