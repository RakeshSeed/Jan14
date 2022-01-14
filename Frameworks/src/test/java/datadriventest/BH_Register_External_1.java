package datadriventest;

import org.testng.annotations.Test;

import bhanepages.BH_HomePage;
import bhanepages.BH_RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BH_Register_External_1 {

	WebDriver driver;
	BH_HomePage bh;
	BH_RegistrationPage rp;

	@Test(dataProvider = "dp")
	public void try_to_register(String first, String last, String email, String mobno, String pass) {
		bh = new BH_HomePage(driver);
		bh.launchApp();
		bh.cancelJoiningSubs();
		bh.selectCountry(0);
		rp = new BH_RegistrationPage(driver);
		rp.startRegistration();
		rp.doRegisterAs(first, last, email, mobno, pass);
	}

	@DataProvider
	public Object[][] dp() throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook(".//src//test//resources//Files//Registration.xlsx");

		XSSFSheet sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum() + 1;
		int cellNum = sheet.getRow(0).getLastCellNum();

		Object[][] obj = new Object[rowNum][cellNum];

		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < cellNum; j++) {

				if (sheet.getRow(i).getCell(j).getCellType().equals(CellType.STRING)) {
					obj[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				}

				else if (sheet.getRow(i).getCell(j).getCellType().equals(CellType.NUMERIC)) {
					long value = (long) sheet.getRow(i).getCell(j).getNumericCellValue();
					obj[i][j] = Long.toString(value);
				}
			}
		}
		wb.close();
		return obj;

	}

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void afterMethod() {
		//driver.close();
	}

}
