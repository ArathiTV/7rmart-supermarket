package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import automationCore.Base;

public class LoginTest extends Base {
	LoginPage loginpage;
	HomePage homepage;

	@Test(groups = {"smoke","regression"})
	public void verifyWhetherUserIsAbleToLoginWithValidCredentials() {

		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login("admin", "admin");
		String expectedProfileName = "Admin";
		String actualProfileName = homepage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);
	}

	@Test(groups = "smoke")
	public void verifyWhetherUserIsAbleToErrorMsgIsVisibleForInvalidCedentials() {
		loginpage = new LoginPage(driver);
		loginpage.login("admin", "admins");
		String expectedErrorMsg = "Invalid Username/Password";
		String actualErrorMsg = loginpage.getErrorMessage();
		System.out.println(actualErrorMsg);
		Assert.assertTrue(actualErrorMsg.contains(expectedErrorMsg)); 
	}
	
	@Test(groups = "smoke") 
	public void verifyWhetherUserIsAbleToLoginWithEmptyFields() {
		loginpage = new LoginPage(driver);
		loginpage.clickOnSigninButton();
		
	}

}
