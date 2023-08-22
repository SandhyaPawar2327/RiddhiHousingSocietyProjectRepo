package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ReceiptPom {
	WebDriver driver;

@FindBy(xpath="(//span[@class=\"app-menu__label\"])[4]")WebElement btnReceipt;
@FindBy(xpath="//a[@href=\"add_receipt.php\"]")WebElement btnaddReceipts;
@FindBy(xpath="//select[@name='userid']")WebElement drpResident;
@FindBy(xpath="//textarea[@name=\"payment_desc\"]")WebElement txtpaymentfor;
@FindBy(xpath="//select[@name=\"mode_of_payment\"]")WebElement drp_modeofpayment;
@FindBy(xpath="//input[@name=\"total_amount\"]")WebElement totalAmount;
@FindBy(xpath="//input[@name=\"received_amount\"]")WebElement receivedAmount;
@FindBy(xpath="//input[@name=\"balance_amount\"]")WebElement balanceAmount;
@FindBy(xpath="//textarea[@placeholder=\"Transaction Details\"]")WebElement transactionDetails;
@FindBy(xpath="//button[@type=\"submit\"]")WebElement btnSubmit;
@FindBy(xpath="//button[@type=\"reset\"]")WebElement btnClear;
		

public ReceiptPom(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
public void clickOnReceipts() {
	btnReceipt.click();
}
public void clickOnAddReceipts() {
btnaddReceipts.click();
}
public void selectResidentdrp(String value) {
	Select s=new Select(drpResident);
 // s.selectByValue(value);
  s.selectByVisibleText(value);
	
}
public void paymentFor(String paymentFor) {
	txtpaymentfor.sendKeys(paymentFor);
}
public void selectpaymentMode(String value) {
	Select s=new Select(drp_modeofpayment);
	s.selectByValue(value);

}
public void entertotalAmount(String totalAmt) {
	totalAmount.sendKeys(totalAmt);
}
public void enterreceivedAmount(String receivedAmt) {
	receivedAmount.sendKeys(receivedAmt);	
}
public void enetrtransactionDetails(String tDetails) {
	transactionDetails.sendKeys(tDetails);
}
public void clickonSubmit() {
	btnSubmit.click();
}
public void clickonClear() {
	btnClear.click();
}
}