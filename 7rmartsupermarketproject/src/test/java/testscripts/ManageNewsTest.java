package testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AdminUserPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageNewsPage;
import automationCore.Base;
import utilities.GeneralUtility;

public class ManageNewsTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	ManageNewsPage managenewspage;

	public void setupPage(WebDriver driver) {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		homepage.navigateToManageNews();
		managenewspage = new ManageNewsPage(driver);
	}

	@Test
	public void verifyWhetherUserIsAbleToViewManageNewsPage() {
		setupPage(driver);
		String expectedPageTitle = "Manage News";
		String actualPageTitle = managenewspage.getPageTitle(); 
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
		
		
	}
	
	@Test
	public void verifyWhetherUserIsAbleToCreateNewNews() {
		setupPage(driver);
		managenewspage.clickOnNew();
		managenewspage.enterNewNews("Holliday");
		managenewspage.clickSaveButton();
		String expectedResult = "News Created Successfully";
		String actualResult = managenewspage.getAlert();
		Assert.assertTrue(actualResult.contains(expectedResult));
		
	}
	@Test
	public void verifyWhetherUserIsAbleToSearchNews() {
		setupPage(driver);
		managenewspage.performSearch("Holliday");
		String expectedNews = "Holliday";
		String actualNews = managenewspage.showSearchNews();
		Assert.assertEquals(actualNews, expectedNews);
	}
	
	@Test
	public void verifyWhetherUserIsAbleToReset() {
		setupPage(driver);
		managenewspage.clickOnResetButton();
		String expectedNews = "Manage News";
		String actualNews = managenewspage.getPageTitle();
		Assert.assertEquals(actualNews, expectedNews);
	
}

		
	
	
	
	
	

		
}	
