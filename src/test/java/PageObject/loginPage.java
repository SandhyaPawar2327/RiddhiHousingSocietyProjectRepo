package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	WebDriver driver;
	@FindBy(xpath="//input[@name='myusername']")WebElement myusername;
	@FindBy(xpath="//input[@name='mypassword']")WebElement mypassword;
	@FindBy(xpath="//button[@type='submit']")WebElement signInbutton;
	@FindBy(xpath="//div[@class=\"alert alert-danger\"]")WebElement errorMsg;
	
	public loginPage(WebDriver driver) 
	{  this.driver=driver;
       PageFactory.initElements(driver,this);

	}
     public void enteruserName(String uName) {
		myusername.sendKeys(uName);
	}

	public void enterPassword(String password) {
		mypassword.sendKeys(password);
	}
	public void signButton() {
		signInbutton.click();
	}
	public String  printErrorMsg() {
		 String errrorTextMessage= errorMsg.getText();
		 return errrorTextMessage;
		 
	}
	
}
