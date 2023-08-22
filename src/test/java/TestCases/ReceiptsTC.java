package TestCases;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.ReceiptPom;
import Utility.BaseClass;

public class ReceiptsTC extends BaseClass{
Map<String,String> maptestMap;
	@DataProvider(name="testlink")
	public Object[][]getData() throws Exception{
		String fileString="C:\\Users\\vijay\\eclipse-workspace\\RiddhiHousingSocietyPoject\\TestData\\AddNewReceiptsSheet.xlsx";
		Object[][]obj=exlRead(fileString);
		return obj;
		
	}
	
	
	public void loginPage() 
	   {
	       loginTC lt=new loginTC();
		   lt.loginWithValidCredential();
       }
	
	
	@Test(dataProvider="testlink",priority=1)
	public void addNewReceipts(Map<String,String>maptestMap){
		ReceiptPom rp=new ReceiptPom(driver);
		loginPage();
		rp.clickOnReceipts();
		rp.clickOnAddReceipts();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		rp.selectResidentdrp(maptestMap.get("Resident"));
		rp.paymentFor(maptestMap.get("PaymentFor"));
		rp.selectpaymentMode(maptestMap.get("PaymentMode"));
		rp.entertotalAmount(maptestMap.get("TotalAmt"));
		rp.enterreceivedAmount(maptestMap.get("ReceivedAmt"));
		rp.enetrtransactionDetails(maptestMap.get("TransactionDetails"));
		rp.clickonSubmit();
	
}
	}

