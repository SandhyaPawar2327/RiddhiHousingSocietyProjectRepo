package TestCases;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObject.ContentPom;
import Utility.BaseClass;

public class ContentTestCases extends BaseClass{
	
		Map<String,String> maptestMap;
		
@DataProvider(name="testlink")
    public Object[][]getData() throws Exception{
	String fileString="C:\\Users\\vijay\\eclipse-workspace\\RiddhiHousingSocietyPoject\\TestData\\ContentsSheet.xlsx";
	Object[][]obj=exlRead(fileString);
	return obj;
			
}
public void loginPage() 
{
       loginTC lt=new loginTC();
	   lt.loginWithValidCredential();
}
		
	
	@Test(dataProvider="testlink",priority=1)
	public void addNewUserContentTest(Map<String,String>maptestMap) throws Exception {
		ContentPom cp=new ContentPom(driver);
		loginPage();
		cp.clickContent();
		cp.clickAddContent();
        cp.contentDropdown(maptestMap.get("SelectSection"));
		cp.entercontenttittle(maptestMap.get("ContentTittle"));
		cp.enterconttentprice(maptestMap.get("ContentChargesPriceCost"));
		cp.entercontentseqence(maptestMap.get("ContentSequence"));
		cp.setContentTag(maptestMap.get("ContentImgAltTag"));
		cp.entercontentdescription(maptestMap.get("ContentDescription"));
		cp.enterDate(maptestMap.get("Date"));
		cp.entercontentlocation(maptestMap.get("Location"));
		cp.enterlink(maptestMap.get("AddLink"));
		cp.setContentImage(maptestMap.get("Image"));
		cp.printSuccessMsg();
		cp.clicksubmit();
		
		}

	
	//@Test
	public void contentTc_02() {//code for sucessfully content added msg print
		WebElement getsucessfulMsg=driver.findElement(By.xpath("//div[@class=\"alert alert-success\"]"));
		System.out.println(getsucessfulMsg.getText());
		
	}

}