package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	@FindBy(xpath = "//a[@class='d-block']")
	private WebElement profileName;

	@FindBy(xpath = " //p[text()='Admin Users']//following::a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-admin\"]")
	private WebElement adminUsersLink;

	@FindBy(xpath = "//div[@class='inner']//p[text()='Manage News']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement manageNewsLink;

	@FindBy(xpath = "//p[text()='Sub Category']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	private WebElement subCategoryLink;
	@FindBy(xpath = "//h1[text()='List Sub Categories']")
	private WebElement subCategoryPage;
	@FindBy(xpath = "//img[@class='img-circle elevation-2']")
	private WebElement image;
	@FindBy(xpath = "//ul[@class='navbar-nav']")
	private WebElement weNavBar;
	@FindBy(xpath = "//aside[@class='main-sidebar elevation-4 sidebar-light-dark']")
	private WebElement weMenuBar;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProfileName() {
		return profileName.getText();
	}

	public AdminUserPage navigateToAdminUser() {
		adminUsersLink.click();
		return new AdminUserPage(driver);
	}

	public void navigateToManageNews() {
		manageNewsLink.click();
	}

	public void navigateToSubCategory() {
		subCategoryLink.click();
	}

	public String getSubCategoryList() {
		return subCategoryPage.getText();
	}

	public String showSubCategory() {
		navigateToSubCategory();
		return getSubCategoryList();
	}

	public boolean isImageshowing() {
		return image.isDisplayed();
	}

	public void clickNavBar() {
		weNavBar.click();
	}

	public boolean isDisplyedMenuBar() {
		return weMenuBar.isDisplayed();
	}

	public boolean checkNavBar() {
		clickNavBar();
		return isDisplyedMenuBar();
	}
}