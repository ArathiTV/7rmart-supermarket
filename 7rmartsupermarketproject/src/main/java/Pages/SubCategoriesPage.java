package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubCategoriesPage {
	public WebDriver driver;
	
	@FindBy(xpath = "//h1[text()='Manage News']")
	private WebElement pageTitle;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/delete?del=3296&page_ad=1']")
	private WebElement deleteButton;
	@FindBy(xpath = "//")
	private WebElement okButton;
	@FindBy(xpath = "")
	private WebElement cancelButton;
	
	private WebElement updateButton;
	@FindBy(xpath = "//")
	private WebElement okButton;
	@FindBy(xpath = "")
	private WebElement cancelButton;
	
	
	
	
	public SubCategoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		return pageTitle.getText();
	}
	

}
