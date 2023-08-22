package TestCases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import PageObject.ListOfExpensesPom;
import Utility.BaseClass;
import net.bytebuddy.utility.RandomString;

public class ListOfExpensesTC extends BaseClass{
	public static String empName2="Ashok shitole";
	//WebElement  scrollbar;
	public void loginPage() {
		loginTC lt=new loginTC();
		lt.loginWithValidCredential();
		
	}
	@Test
	public void ListOfExpensesTC_01() throws Exception {
		ListOfExpensesPom exp=new ListOfExpensesPom(driver);
		loginPage();
		exp.clickOnExpenses();
		exp.clickonListExpenses();
		exp.enterFromDate();
		exp.enterToDate();
		exp.selectempDrpodown("Ashok Shitole");
		exp.clickonSearch();
		driver.navigate().back();
		exp.delete();
		
	}
	public void scrolldown_02() throws Exception {
		ListOfExpensesPom exp=new ListOfExpensesPom(driver);
		exp.clickOnExpenses();
		exp.clickonListExpenses();
		exp.scrolling();
		Thread.sleep(2000);
		


		
	}

}
