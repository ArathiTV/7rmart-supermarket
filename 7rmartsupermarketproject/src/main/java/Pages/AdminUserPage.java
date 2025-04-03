package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUserPage {
PageUtility pageutility;
	public WebDriver driver;
	@FindBy(xpath = "//h1[text()='Admin Users']")
	private WebElement pageTitle;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;

	@FindBy(xpath = "//input[@id='un']")
	private WebElement weUserName;

	@FindBy(xpath = "//select[@id='ut']")
	private WebElement weUserType;

	@FindBy(xpath = "//button[@name='Search']")
	private WebElement search;

	@FindBy(xpath = "(//a[@class='btn btn-default btn-fix'])[1]")
	private WebElement reset;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	private WebElement showUser;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement weNewButton;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() {
		return pageTitle.getText();
	}

	public void clickOnSearch() {
		searchButton.click();

	}

	public void enterUserName(String userName) {
		weUserName.sendKeys(userName);
	}

	public void selectDropDown(String userType) {
		pageutility = new PageUtility(driver);
		pageutility.select_ByVisibleText(weUserType, userType);
		
	}

	public void clickSearchButton() {
		search.click();
	}

	public void clickRestButton() {
		reset.click();
	}

	public String showSearchAdminUser() {
		return showUser.getText();
	}

	public void searchAdminUsers(String userName, String userType) {
		clickOnSearch();
		enterUserName(userName);
		selectDropDown(userType);
		clickSearchButton();
	}
	
	
	
	public String getButtonColor() {
		return weNewButton.getCssValue("color");
		
	}
}