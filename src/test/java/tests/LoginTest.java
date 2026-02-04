package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import config.ConfigReader;
import io.qameta.allure.Description;
import pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test(priority = 1)
	@Description("Verify that admin can login with valid credentials")
	public void verifyAdminLogin() {
		LoginPage loginPage = new LoginPage(driver);

		String user = ConfigReader.getProperty("username");

		String pass = ConfigReader.getProperty("password");

		String oldUrl = driver.getCurrentUrl();

		loginPage.login(user, pass);

		// After login the URL should remain the same login URL
		String newUrl = driver.getCurrentUrl();

		Assert.assertEquals(newUrl, oldUrl, "Login Failed :URL did not change after login");

	}

}
