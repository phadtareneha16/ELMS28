package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import config.ConfigReader;
import io.qameta.allure.Description;
import pages.DashBoardPage;
import pages.LoginPage;

public class LogoutTest extends BaseClass {

	@Test(priority = 5)
	@Description("Verify that admin can logout successfully")
	public void verifyLogOut() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		DashBoardPage dashboard = new DashBoardPage(driver);

		// Perform Logout
		dashboard.logout();

		// After logout current URL should match the configured login URL
		String exepectedURL = ConfigReader.getProperty("url");
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, exepectedURL, "Logout failed :current url does not match with login page url");

	}

}
