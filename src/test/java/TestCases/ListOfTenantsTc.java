package TestCases;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import PageObject.ListOfTenantsPom;
import Utility.BaseClass;

public class ListOfTenantsTc extends BaseClass {
	public void loginPage() {
		loginTC lt=new loginTC();
		lt.loginWithValidCredential();
	}
	@Test
	public void ListOfTenantsTC_01() throws Exception  {
		loginPage();
	ListOfTenantsPom tenants=new ListOfTenantsPom(driver);
              tenants.clickonUsers();
              tenants.clickonListTenants();
              tenants.clickonView();
              driver.navigate().back();
              
              tenants.clickonDelete();
              Alert alt=driver.switchTo().alert();
             	//capturing alert message
             	String alertMessage=driver.switchTo().alert().getText();
             	System.out.println(alertMessage);
             	Thread.sleep(3000);
             	driver.switchTo().alert().dismiss();

}
}