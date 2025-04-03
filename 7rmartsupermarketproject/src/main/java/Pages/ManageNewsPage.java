package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;

	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	private WebElement pageTitle;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//textarea[@id=\"news\"]")
	private WebElement weNews;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;
	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElement cancelButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement weSearchNews;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement weSearch;
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	private WebElement weReset;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	private WebElement showUser;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	private WebElement resetButton;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() {
		return pageTitle.getText();
	}

	public void clickOnNew() {
		newButton.click();

	}

	public void enterNewNews(String news) {
		weNews.sendKeys(news);
	}

	public void clickSaveButton() {
		saveButton.click();
	}

	public void clickCancelButton() {
		cancelButton.click();
	}

	public String getAlert() {
		return alert.getText();
	}

	public void clickOnSearch() {
		searchButton.click();
	}

	public void enterSearchNews(String news) {
		weSearchNews.sendKeys(news);
	}

	public void clickSearchButton() {
		weSearch.click();
	}

	public void clickResetButton() {
		weReset.click();
	}

	public void performSearch(String news) {
		clickOnSearch();
		enterSearchNews(news);
		clickSearchButton();
	}
	public String showSearchNews() {
		return showUser.getText();
	}
	public void clickOnResetButton() {
		resetButton.click();
	}

}