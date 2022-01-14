package bhanepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BH_RegistrationPage {
	WebDriver driver;

	public BH_RegistrationPage(WebDriver idriver) {
		this.driver = idriver;
		PageFactory.initElements(idriver, this);
	}

	@FindBy(xpath = "//li[contains(text(),'account')]")
	WebElement accountBtn;

	@FindBy(xpath = "//div[contains(text(),'sign up >')]")
	WebElement signupBtn;

	@FindBy(xpath = "//body/div[@id='modal-register']/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement firstname;

	@FindBy(xpath = "//body/div[@id='modal-register']/div[1]/form[1]/div[1]/div[2]/div[1]/input[1]")
	WebElement lasttname;

	@FindBy(xpath = "//body/div[@id='modal-register']/div[1]/form[1]/div[1]/div[3]/div[1]/input[1]")
	WebElement emailId;

	@FindBy(xpath = "//body/div[@id='modal-register']/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/input[1]")
	WebElement mobileNo;

	@FindBy(xpath = "//body/div[@id='modal-register']/div[1]/form[1]/div[1]/div[5]/div[1]/input[1]")
	WebElement password;

	@FindBy(xpath = "//body/div[@id='modal-register']/div[1]/form[1]/div[2]/button[1]")
	WebElement submit;

	public void startRegistration() {
		try {
			accountBtn.click();
			Thread.sleep(5000);
			signupBtn.click();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void startLogin() {
		try {
			accountBtn.click();
			Thread.sleep(5000);
			
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void doRegisterAs(String first,String surname,String email,String mobno,String pass) {   
		
		try {
			
			firstname.sendKeys(first);
			lasttname.sendKeys(surname);
			emailId.sendKeys(email);
			mobileNo.sendKeys(mobno);
			password.sendKeys(pass);
			submit.click();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
