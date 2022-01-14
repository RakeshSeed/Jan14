package datadriventest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bhanepages.BH_HomePage;
import bhanepages.BH_LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class InternalDataDriven {

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
	public Object[][] dp()  {    
		
		Object[][] obj= new Object[3][2];
		
		obj[0][0]="test1"; 
		obj[0][1]="test";
		
		obj[1][0]="test2"; 
		obj[1][1]="test";
		
		obj[2][0]="test3"; 
		obj[2][1]="test";
		
		return obj;
		
	} 
	
	  @AfterMethod
	  public void afterMethod() {
		  //driver.close();
	  }
	
}
