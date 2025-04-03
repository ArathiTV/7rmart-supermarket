package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import automationCore.Base;

public class HomeTest extends Base {
	
	LoginPage loginpage;
	HomePage homepage;
	
	@Test()
	public void verifyWhetherUserIsAbleToEnterSubCategory() {
		
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		String expectedSubCategoryList = "List Sub Categories";
		String actualSubCategoryList = homepage.showSubCategory();
		Assert.assertEquals(actualSubCategoryList, expectedSubCategoryList);
	}
}
