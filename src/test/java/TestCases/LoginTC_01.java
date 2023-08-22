package TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.loginPage;
import Utility.BaseClass;
import Utility.XLUtils;

public class LoginTC_01 extends BaseClass {
	@Test(dataProvider="LoginData")
	public void LoginDDT(String user,String pwd)
	{ loginPage lp=new loginPage(driver);
	lp.enteruserName(user);
	lp.enterPassword(pwd);
	lp.signButton();
	lp.printErrorMsg();
		
	}
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String path="C:\\Users\\vijay\\eclipse-workspace\\RiddhiHousingSocietyPoject\\TestData\\RiddhiProjectData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet");
		int colcount=XLUtils.getCellCount(path, "Sheet", 1);
		String logindata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++) 
		{ for(int j=0;j<colcount;j++)
		{
			logindata[i-1][j]=XLUtils.getCellData(path, "Sheet", i, j);
			

			
		}
		

		}
		
         return logindata;
				
		
		
	}

}
