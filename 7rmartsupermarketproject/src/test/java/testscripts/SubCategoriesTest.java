package testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageNewsPage;
import Pages.SubCategoriesPage;
import automationCore.Base;

public class SubCategoriesTest  extends Base {
	LoginPage loginpage;
	HomePage homepage;
	SubCategoriesPage subcategoriespage;

	public void setupPage(WebDriver driver) {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		homepage.navigateToSubCategory();
		subcategoriespage = new SubCategoriesPage(driver);
	}
	
	@Test
	public void verifyWhetherUserIsAbleToViewManageNewsPage() {
		setupPage(driver);
		String expectedPageTitle = "Manage News";
		String actualPageTitle = subcategoriespage.getPageTitle(); 
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
		
		
	}

}
