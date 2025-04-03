package Pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;
	public Properties properties = new Properties();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		try {
			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement PasswordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signinButton;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement errormsg;

	public void enterUserNameOnUserNameField( String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPasswordOnPasswordField(String password) {
		PasswordField.sendKeys(password);
	}

	public void clickOnSigninButton() {
		WaitUtility waitutility = new WaitUtility(driver);
		waitutility.waitForClickable(signinButton, 20);
		signinButton.click();
		
	}

	public HomePage login(String userName, String password) {
		enterUserNameOnUserNameField(userName);
		enterPasswordOnPasswordField(password);
		clickOnSigninButton();
		return new HomePage(driver);
	}
	
	public HomePage  login() { // method overloading 
		String userName = properties.getProperty("userName");
		String password = properties.getProperty("password");
		enterUserNameOnUserNameField(userName);
		enterPasswordOnPasswordField(password);
		clickOnSigninButton();
		return new HomePage(driver); 
	}
	
	public String getErrorMessage() {
		return errormsg.getText();
	}

}
