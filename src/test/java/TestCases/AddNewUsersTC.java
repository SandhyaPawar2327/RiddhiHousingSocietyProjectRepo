package TestCases;

import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.UsersPom;
import Utility.BaseClass;

public class AddNewUsersTC extends BaseClass{
	Map<String,String> maptestMap;
	@DataProvider(name="testlink")
	public Object[][]getData() throws Exception{
		String fileString="C:\\Users\\vijay\\eclipse-workspace\\RiddhiHousingSocietyPoject\\TestData\\AddNewUsersTC.xlsx";
		Object[][]obj=exlRead(fileString);
		return obj;
		
	}
	public void loginPage() 
	   {
	       loginTC lt=new loginTC();
		   lt.loginWithValidCredential();
       }
	
	@Test(dataProvider="testlink",priority=1)
	public void SubmitAddNewUser(Map<String,String>maptestMap) throws Exception {
		UsersPom up=new UsersPom(driver);
		loginPage();
		up.clickOnUsers();
		up.clickOnAddUsers();
		up.setRole(maptestMap.get("Role"));
		up.enterfullname(maptestMap.get("FullName"));
		log.info("Enter the full name");
		up.entermobilenum(maptestMap.get("MobileNumberUserName"));
		log.info("Enter mobile number");
		up.enterpassword(maptestMap.get("Password"));
		log.info("Enter the password");
	    up.enterlandlinenumber(maptestMap.get("AlternateLandLineNumber"));
	    log.info("Enter the landline number");
	    up.enteremail(maptestMap.get("Email"));
	    log.info("Enter the email");
	    up.enteraddress(maptestMap.get("Address"));
	    log.info("Enter the address");
	    up.selectGender(maptestMap.get("Gender"));
	    log.info("Select gender");
	    up.enteradharNumber(maptestMap.get("AadharNo"));
	    log.info("Enter the Aadhar number");
	    up.enetrPANnum(maptestMap.get("PANNo"));
	    log.info("Enter the PAN number");
	    up.clickonSubmit();
	    		
		
	}
	@Test(dataProvider="testlink",priority=2)
	public void ClearAddNewUser(Map<String,String>maptestMap) throws Exception {
		UsersPom up=new UsersPom(driver);
		loginPage();
		up.clickOnUsers();
		up.clickOnAddUsers();
		up.setRole(maptestMap.get("Role"));
		up.enterfullname(maptestMap.get("FullName"));
		
		up.entermobilenum(maptestMap.get("MobileNumberUserName"));
		up.enterpassword(maptestMap.get("Password"));
	    up.enterlandlinenumber(maptestMap.get("AlternateLandLineNumber"));
	    up.enteremail(maptestMap.get("Email"));
	    up.enteraddress(maptestMap.get("Address"));
	    up.selectGender(maptestMap.get("Gender"));
	    up.enteradharNumber(maptestMap.get("AadharNo"));
	    up.enetrPANnum(maptestMap.get("PANNo"));
	    up.clickonClear();
	    		
		
	}

}
