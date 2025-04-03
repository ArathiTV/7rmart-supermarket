package dataproviders;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

import utilities.ExcelReader;

public class DataProviders {
	ExcelReader excelreader = new ExcelReader();

	@DataProvider(name = "SearchData")
	public Object[][] getLoginData() {
		excelreader.setExcelFile("UserSearchDataProvider");
		return excelreader.getMultidimentionalData(3, 2);

	}

}
