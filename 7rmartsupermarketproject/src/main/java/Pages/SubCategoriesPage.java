package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class SubCategoriesPage {
	public WebDriver driver;
	PageUtility pageutility;

	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	private WebElement pageTitle;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]//i[@class = 'fas fa-trash-alt']")
	private WebElement deleteButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement weAlertMessage;

	public SubCategoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() {
		return pageTitle.getText();
	}

	public void deleteCategory() {
		pageutility = new PageUtility(driver);
		pageutility.acceptAlert();
		
	}
	public void clickDeleteButton() {
		deleteButton.click();
	}
	public String getText() {
		return weAlertMessage.getText();
	}
	public void deleteItem() {
		clickDeleteButton();
		deleteCategory();
	}

}
