package bhanepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BH_LoginPage {

	
		WebDriver driver ;
		
		public  BH_LoginPage(WebDriver idriver) {
			this.driver= idriver;
			PageFactory.initElements(idriver,this);
		}


		@FindBy(xpath = "//li[contains(text(),'account')]")
		WebElement accountBtn;
		
		@FindBy(xpath="//*[@id='modal-login']/div/form/div[1]/input")
		WebElement regEmail;

		@FindBy(xpath="//*[@id='modal-login']/div/form/div[2]/input")
		WebElement regPassWord ;

		@FindBy(xpath="//button[@type='submit']")
		WebElement loginButton ;

	
		public void startLogin() {
			try {
				accountBtn.click();
				Thread.sleep(5000);
				
			}

			catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

		public void doLoginAs(String user , String pass) {
			try {
			regEmail.sendKeys(user);
			regPassWord.sendKeys(pass);
			loginButton.submit(); 
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	
}
