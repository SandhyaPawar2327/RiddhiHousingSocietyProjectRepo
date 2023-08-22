package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.SectionPom;
import Utility.BaseClass;

public class SectionTestCases extends BaseClass {
public static String sectionName="ParkingSection";

public void loginPage() {
	loginTC lt=new loginTC();
	lt.loginWithValidCredential();
}
	
 @Test
	public void sectionTest01() throws Exception {
	   SectionPom sp=new SectionPom(driver);
	    loginPage();
		sp.clickOnSection();
		sp.sectionName(sectionName);
		sp.clickOnSubmit();
		sp.drp_show("50");
		sp.search("Test");
		sp.printAlertMsg();
	   }	

}