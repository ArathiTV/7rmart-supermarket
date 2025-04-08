package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AdminUserPage;
import Pages.HomePage;
import Pages.LoginPage;
import automationCore.Base;
import dataproviders.DataProviders;
import listeners.RetryAnalyzer;
import utilities.ExcelReader;
import utilities.GeneralUtility;

public class AdminUserTest extends Base {

	LoginPage loginpage;
	HomePage homepage;
	AdminUserPage adminuserpage;

	@Test // doubt
	public void verifyWhetherAdminIsAbleToViewAdminUserPage() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		adminuserpage = new AdminUserPage(driver);
		loginpage.login();
		homepage.navigateToAdminUser();
		String expectedPageTitle = "Admin Users";
		String actualPageTitle = adminuserpage.getPageTitle();
		System.out.println(GeneralUtility.getRandomName());
		Assert.assertEquals(actualPageTitle, expectedPageTitle);

	}

	@Test // doubt
	public void verifyWhetherAdminIsAbleToCreateNewUser() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		adminuserpage = new AdminUserPage(driver);
		loginpage.login();
		homepage.navigateToAdminUser();
		String userName = GeneralUtility.getRandomName();
		String password = GeneralUtility.getRandomName();
		adminuserpage.addNewAdminUser(userName, password + "123", "Partner");
		String expectedUser = "User Created Successfully";
		String actualUser = adminuserpage.showAlertmessage();
		Assert.assertTrue(actualUser.contains(expectedUser));

	}

	@Test(dataProvider = "SearchData", dataProviderClass = DataProviders.class)
	public void verifyWhetherAdminIsAbleToSearchForUsers(String userName, String userType) {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		adminuserpage = new AdminUserPage(driver);
		loginpage.login();
		homepage.navigateToAdminUser();
		adminuserpage.searchAdminUsers(userName, userType);
		String expectedUser = userName;
		String actualUser = adminuserpage.showSearchAdminUser();
		Assert.assertEquals(actualUser, expectedUser);

	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void verifyWhetherAdminIsAbleToSearchForUser() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		adminuserpage = homepage.navigateToAdminUser(); // object Chaining
		adminuserpage.searchAdminUsers("Aparna", "Admin");
		String expectedUser = "Aparna";
		String actualUser = adminuserpage.showSearchAdminUser();
		Assert.assertEquals(actualUser, expectedUser);

	}

	@Test(groups = { "smoke", "regression" })
	public void verifyWhetherNewButtonColor() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		adminuserpage = new AdminUserPage(driver);
		loginpage.login();
		homepage.navigateToAdminUser();
		String expectedColor = "rgba(255, 255, 255, 1)";
		String actualColor = adminuserpage.getButtonColor();
		System.out.println(actualColor);
		Assert.assertEquals(actualColor, expectedColor);

	}

	@Test
	public void excelCheck() {
		ExcelReader excelreader = new ExcelReader();
		excelreader.setExcelFile("LoginData");
		System.out.println(excelreader.getCellData(0, 0));
	}

}
