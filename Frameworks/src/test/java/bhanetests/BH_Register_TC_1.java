package bhanetests;

import org.testng.annotations.Test;

import bhanepages.BH_HomePage;
import bhanepages.BH_RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BH_Register_TC_1 {
 
	WebDriver driver;
	BH_HomePage bh;
	BH_RegistrationPage rp;
  @Test
  public void guest_user_open_chrome() { 
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  
  }    
  
  @Test(dependsOnMethods="guest_user_open_chrome")
  public void  then_open_bhane_webapplication() {  
	  bh= new BH_HomePage(driver);
	  bh.launchApp();
	  bh.cancelJoiningSubs();
	  
  }   
  
  @Test(dependsOnMethods="then_open_bhane_webapplication")
  public void then_select_india() { 
	  bh.selectCountry(0);
  }  
  
  @Test(dependsOnMethods="then_select_india")
  public void then_try_to_register() {  
	  rp= new BH_RegistrationPage(driver);
	  rp.startRegistration();
	  rp.doRegisterAs("mark", "zuckerberg", "mark.zuckerberg@facebook.com", "9087654310", "test");
  }  
  
  
  
  
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  
  }

  @AfterMethod
  public void afterMethod() {
	  //driver.close();
  }

}
