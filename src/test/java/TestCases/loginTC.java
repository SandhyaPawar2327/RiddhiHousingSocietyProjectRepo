package TestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageObject.loginPage;
import Utility.BaseClass;

public class loginTC extends BaseClass {
	@Test(priority=1)
	public void loginWithValidCredential() {
		loginPage loginpage=new loginPage(driver);
		
		loginpage.enteruserName(readconfig.getUserName());
		log.info("Enter the user name");
		loginpage.enterPassword(readconfig.getPassword());
		log.info("Enter the password");
		loginpage.signButton();
		log.info("click the signin button");
		
				
	}
	@Test(priority=2,enabled=false)
	public void loginWithInvalidCredential() throws Exception {
		
		loginPage loginpage=new loginPage(driver);
		loginpage.enteruserName("Ridhii");
		loginpage.enterPassword("1000");
		loginpage.signButton();
		String expectedErrorMessage="Error!Invalid Username or Password";
		String actualErrorMessage=loginpage.printErrorMsg();
		assertEquals(expectedErrorMessage,actualErrorMessage);
		captureScreenshoot("loginshots");
	}
	
	@Test(priority=3 ,enabled=false)
	public void loginWithBlankUsernamePassword() {
		loginPage loginpage=new loginPage(driver);
		loginpage.enteruserName("");
		loginpage.enterPassword("");
		loginpage.signButton();
		String expectedErrorMessage="Error!Username and Password field should not left blank";
		String actualErrorMessage=loginpage.printErrorMsg();
		assertEquals(expectedErrorMessage,actualErrorMessage);

	}
	@Test(priority=4,enabled=false)
	public void loginWithBlankUsername() {
		
		loginPage loginpage=new loginPage(driver);
		loginpage.enteruserName("");
		loginpage.enterPassword("100");
		loginpage.signButton();
		String expectedErrorMessage="Error!Username field should not left blank";
		String actualErrorMessage=loginpage.printErrorMsg();
		assertEquals(expectedErrorMessage,actualErrorMessage);
		
	}
	@Test(priority=5,enabled=false)
	public void loginWithBlankPassword() {
		
		loginPage loginpage=new loginPage(driver);
		loginpage.enteruserName("Ridhhi");
		loginpage.enterPassword("");
		loginpage.signButton();
		String expectedErrorMessage="Error!Username field should not left blank";
		String actualErrorMessage=loginpage.printErrorMsg();
		assertEquals(expectedErrorMessage,actualErrorMessage);
		
	}
	
}
