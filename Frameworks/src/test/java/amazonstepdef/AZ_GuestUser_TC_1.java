package amazonstepdef;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AZ_GuestUser_TC_1 {
	WebDriver driver;
	String parentWinId;

	@Given("google chrome is open")
	public void google_chrome_is_open() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Given("amazon.in is open")
	public void amazon_in_is_open() {
		driver.get("https://www.amazon.in/");
		parentWinId = driver.getWindowHandle();

	}

	@When("I search oneplus 9r")
	public void i_search_oneplus_9r() {
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Oneplus 9r", Keys.ENTER);

	}

	@When("click on that oneplus 9r link")
	public void click_on_that_oneplus_9r_link() {
		driver.findElement(By.xpath("//span[contains(text(),'OnePlus 9R 5G (Carbon Black, 8GB RAM, 128GB Storag')]"))
				.click();

	}

	@When("another window open")
	public void another_window_open() {
		System.out.println(driver.getTitle());
	}

	@Then("guest user switch to other window")
	public void guest_user_switch_to_other_window() {
		Set<String> allWin = driver.getWindowHandles();

		for (String win : allWin) {
			if (!win.equals(parentWinId)) {
				driver.switchTo().window(win);
			}

		}
		System.out.println(driver.getTitle());

	}

	@Then("click buy now validate sigin is opened")
	public void click_buy_now_validate_sigin_is_opened() {
		driver.findElement(By.xpath("//input[@id='buy-now-button']")).click();
		Assert.assertEquals(driver.getTitle(), "Amazon Sign In");
	}

}
