package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;
	JavascriptExecutor js;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
		js=(JavascriptExecutor) driver;
	}

	public void jisClick(WebElement element) {
		js.executeScript("arguments[0].click();", element);

	}

	public void jsScroll(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView;", element);
	}

	public void select_ByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}

	public void select_ByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text); 

	}

	public void select_ByValue(WebElement element, int index) {
		Select select = new Select(element);     
		select.selectByIndex(index);
	}
	
	public void  acceptAlert() {
		driver.switchTo().alert().accept();
		
	} 
}