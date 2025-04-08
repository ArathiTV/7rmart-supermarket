package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;

public class AdminUserPage {
PageUtility pageutility;
	public WebDriver driver;
	@FindBy(xpath = "//h1[text()='Admin Users']")
	private WebElement pageTitle;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	
	@FindBy(xpath ="//input[@id='username']")
	private WebElement userName;
	
	@FindBy(xpath ="//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath ="//select[@id='user_type']")
	private WebElement userType;
	
	@FindBy(xpath ="//button[@name='Create']")
	private WebElement saveButton;
	
	@FindBy(xpath ="//div[@class='card-footer center']//a[@type='button']")
	private WebElement resetButton;
	
	@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMsg;

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
	
	public void clickOnNewButton() {
		newButton.click();
	}
	
	public void enterNewUserName(String userNames) {
		userName.sendKeys(userNames);
	}
	
	public void enterNewPassword(String passwords) {
		password.sendKeys(passwords);
	}
	
	public void enterNewUserType(String userTypes) {
		userType.sendKeys(userTypes);
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
	public void addNewAdminUser(String userNames,String passwords,String userTypes) {
		clickOnNewButton();
		enterNewUserName(userNames);
		enterNewPassword(passwords);
		enterNewUserType(userTypes);
		clickSaveButton();
	}
	
	public String showAlertmessage() {
		return alertMsg.getText();
	}
	
	public void clickRestButtonn() {
		resetButton.click();
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
		pageutility.select_ByVisibleText(newButton, userType);
		
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