package utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {
	public String getAtribute(WebElement element, String atribute) {
		return element.getDomAttribute(atribute);
	}

	public String getCssValue(WebElement element, String cssProperty) {
		return element.getCssValue(cssProperty);
	}

	public List<String> getTextoFelements(List<WebElement> elements) {
		List<String> data = new ArrayList<String>();

		for (WebElement element : elements) {
			data.add(element.getText());
		}
		return data;
	}
	
	public static String getRandomName() {
		Faker faker = new Faker();
		return faker.name().firstName();
	}

}
