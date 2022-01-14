package bhanetests;

import org.testng.annotations.Test;

import bhanepages.BH_HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BH_TC_1 {
	
	WebDriver driver;
	
	
  @Test
  public void testcase1() {
	  BH_HomePage bh=new BH_HomePage (driver);
	  bh.launchApp();
	  bh.cancelJoiningSubs();
	  bh.selectCountry(1);
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
