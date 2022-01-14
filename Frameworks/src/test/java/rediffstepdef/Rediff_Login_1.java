package rediffstepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Rediff_Login_1 {
	WebDriver driver;
	
	@Before
	public void setup() {  
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@After
	public void afterscenario() {  
		driver.close();
	}
	
	
	@When("Login page is open {string}")
	public void login_page_is_open(String string) {
		driver.get(string);
	}

	@Given("user want to enter a  username {string}")
	public void user_want_to_enter_a_username(String string) {
	  driver.findElement(By.id("login1")).sendKeys(string);
	}

	@When("user enter password {string} and click login button")
	public void user_enter_password_and_click_login_button(String string) {
		 driver.findElement(By.id("password")).sendKeys(string);
		 driver.findElement(By.name("proceed")).click();
	}

	@Then("I verify the {string} in step")
	public void i_verify_the_in_step(String string) {

		if(driver.findElement(By.xpath("//*[@id='div_login_error']")).isDisplayed()) {    
			System.out.println("Login failed:"+string);
			
		} 
		else { 
			System.out.println("pass");
		} 
	}
}
