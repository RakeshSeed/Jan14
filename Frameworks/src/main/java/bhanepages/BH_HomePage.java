package bhanepages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BH_HomePage {

	WebDriver driver;

	public BH_HomePage(WebDriver idriver) {
		this.driver = idriver;
		PageFactory.initElements(idriver, this);
	}

	@FindBy(xpath = "//div[@id='mdiv']")
	WebElement cancel;

	@FindBy(how = How.XPATH, using = "//body/div[7]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]")
	WebElement joiningName;

	@FindBy(tagName = "a")
	List<WebElement> allLink;

	@FindBy(xpath = "//body/div[7]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]")
	WebElement joiningEmail;

	@FindBy(xpath = "//button[contains(text(),'sign up')]")
	WebElement signupSubs;
	
	@FindBy(xpath = "//header/div[1]/div[1]/div[4]/ul[1]/li[1]/form[1]/span[1]/span[1]/span[1]/span[2]")
	WebElement countryArrow;
	
	@FindBy(xpath = "//ul[@class='select2-results__options']/li")
	List<WebElement> countryList;
	
	

	public void cancelJoiningSubs() {
		try {
			if (cancel.isDisplayed()) {
				cancel.click();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void joinSubs(String user, String email) {
		try {
			joiningName.sendKeys(user);
			joiningEmail.sendKeys(email);
			signupSubs.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void launchApp() {  
		try {
			driver.get("https://www.bhaane.com/");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	} 
	
	//use int 0 for india ,1-usa, 2- european,3-uk
	public void selectCountry(int index) {  
		try {
			countryArrow.click();
			Thread.sleep(5000);
			countryList.get(index).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	

}
