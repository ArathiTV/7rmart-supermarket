package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubCategoriesPage {
	public WebDriver driver;

	@FindBy(xpath = " ")
	private WebElement pageTitle;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/delete?del=3296&page_ad=1']")
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

	public String deleteCategory() {
		deleteButton.click();
		driver.switchTo().alert().accept();
		return weAlertMessage.getText();
	}

}
