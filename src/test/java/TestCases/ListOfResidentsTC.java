package TestCases;

import org.testng.annotations.Test;

import PageObject.ListOfResidentsPom;
import Utility.BaseClass;

public class ListOfResidentsTC extends BaseClass {
	public void loginPage() {
		loginTC lt=new loginTC();
		lt.loginWithValidCredential();
		
	}
	@Test
	public void ListOfResidentTc01() throws Exception {
		loginPage();
		ListOfResidentsPom list=new ListOfResidentsPom(driver);
		list.clickOnUsers();
		list.clickonListResidents();
		list.searchResidents(search);
		list.clickonView();
		driver.navigate().back();
		list.clickonDelete();
		log.info("Success! User deleted successfully");
		list.getSuccessMsg();
		
	}

}
