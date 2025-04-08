package testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SubCategoriesPage;
import automationCore.Base;

public class SubCategoriesTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	SubCategoriesPage subcategoriespage;

	public void setupPage(WebDriver driver) {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		subcategoriespage = new SubCategoriesPage(driver);
		loginpage.login();
		homepage.navigateToSubCategory();
	}

	@Test
	public void verifyWhetherUserIsAbleToViewSubCategoryPage() {
		setupPage(driver);
		String expectedPageTitle = "List Sub Categories";
		String actualPageTitle = subcategoriespage.getPageTitle();
		Assert.assertEquals(actualPageTitle, expectedPageTitle);

	}

	@Test
	public void verifyWhetherUserIsAbleToDeleteCategory() {
		setupPage(driver);
		subcategoriespage.deleteItem();
		String actualResult = subcategoriespage.getText();
		String expectectedResult = "Sub Category Deleted Successfully";
		Assert.assertTrue(actualResult.contains(expectectedResult));

	}

}
