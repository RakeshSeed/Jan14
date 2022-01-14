package datadriventest;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bhanepages.BH_HomePage;
import bhanepages.BH_LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExternalDataDriven {

	WebDriver driver;
	BH_LoginPage lp;
	BH_HomePage bh;
	@BeforeMethod
	  public void beforeMethod() {
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
	  }
	
	@Test(dataProvider="dp")
	  public void testcase1(String user,String pass) {      
		  bh= new BH_HomePage(driver);
		  bh.launchApp();
		  bh.cancelJoiningSubs();
		  
		  lp=new BH_LoginPage(driver);
		  lp.startLogin();
		  lp.doLoginAs(user, pass);
		
		
	}
	
	@DataProvider
	public Object[][] dp() throws IOException  {    
		
	
		XSSFWorkbook wb=new  XSSFWorkbook(".//src//test//resources//Files//BhaneLogin.xlsx");
		//XSSFWorkbook is class which open spreadsheet file in background
		
		XSSFSheet sheet=wb.getSheetAt(0);
		//this will open sheet at index or first
		
		int rowNum=sheet.getLastRowNum()+1;
		
		int cellNum=sheet.getRow(0).getLastCellNum();
		System.out.println(rowNum);
		System.out.println(cellNum);
		
		Object[][] obj= new Object[rowNum][cellNum];
	
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < cellNum; j++) {
				obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		

	wb.close();
	return obj;
		
	} 
	
	@AfterMethod
	  public void afterMethod() {
		 driver.close();
	  }
	
}
